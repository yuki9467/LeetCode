package com.interview;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * I want to build a service, and I have below requirements
1. I have a thread to send message to downstream, the request message contains two fields, ID and Content
2. I have another thread to mock the downstream response, the response message contains two fields, ID and Content.
3. I need a separate thread to monitor if downstream response message come back within 5 seconds timeout, if yes, just print the downstream response message,
if not, then print a message saying that "waiting for response timeout".
For monitor thread, I want to keep checking if the response of the corresponding request message is more than 5 seconds, rather than waiting for all messages response within 5 seconds
 */
class RequestMessage{

    final long sendTime;
    volatile String response;

    public RequestMessage(long sendTime){
        this.sendTime = sendTime;
        this.response = null;
    }
}
public class MonitorThread {
    private static final ConcurrentHashMap<String, RequestMessage> messageMap = new ConcurrentHashMap<>();
    private static final int TIMEOUT_MS = 5000;

    public static void main(String[] args) {
        // sender thread
        new Thread(() -> {
        int counter = 1;
        try {
        // 每秒发送一条消息
        Thread.sleep(1000);
        String id = UUID.randomUUID().toString();
        String content = "REQ_" + counter++;

        messageMap.put(id, new RequestMessage(System.currentTimeMillis()));

        System.out.println("[发送] ID: " + id + " | 内容: " + content);

        } catch (InterruptedException e) {
        e.printStackTrace();
        }

        }, "SenderThread").start();

        // response thread
        new Thread(() -> {
        try {
        // 延迟两秒响应
        Thread.sleep(2000);
        if (!messageMap.isEmpty()) {
        // 随机取一条没有response的（response is null）
        String randomId = messageMap.keys().nextElement();
        RequestMessage request = messageMap.get(randomId);

        if (request != null && request.response == null) {
        request.response = "RESP-for-" + randomId.substring(0, 8);
        System.out.println("[响应生成] ID: " + randomId);
        }
        }

        } catch (InterruptedException e) {

        e.printStackTrace();
        }

        },"ResponseThread").start();;

        // monitor thread
        new Thread(() -> {

            try {
                // 每秒检查一次
                Thread.sleep(1000);

                long currentTime = System.currentTimeMillis();
                for(Map.Entry<String, RequestMessage> entry : messageMap.entrySet()){
                    String id = entry.getKey();
                    RequestMessage message = entry.getValue();

                    // 收到响应
                    if (message.response != null) {
                    System.out.println("[监控] 收到响应! ID: " + id + " | 内容: " + message.response);
                    messageMap.remove(id); // 从监控中移除
                    }// 没有收到响应且超时
                    else if (currentTime - message.sendTime > TIMEOUT_MS) {

                    System.out.println("[监控] 等待响应超时! ID: " + id);
                    messageMap.remove(id); // 从监控中移除
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "MonitorThread").start();

    }
}
