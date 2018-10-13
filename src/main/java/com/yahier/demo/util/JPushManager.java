package com.yahier.demo.util;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

import static cn.jpush.api.push.model.Platform.*;
import static cn.jpush.api.push.model.notification.PlatformNotification.ALERT;

public class JPushManager {

    private final static String MASTER_SECRET = "1cadd4e0d5fba4c791f7b62f";
    private final static String APP_KEY = "4fad95f2ffa326da0762ebaa";

    public static void send() {
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_android_tag_alertWithTitle();

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("Got result - " + result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            System.out.println("Connection error, should retry later");

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            System.out.println("HTTP Status: " + e.getStatus() + " " + "Error Code: " + e.getErrorCode() + " " + "Error Message: " + e.getErrorMessage());
        }
    }

    private static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(ALERT, "yahier服务器的极光推送来了", null))
                .build();
    }


}
