package com.pplingo.common_push.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pplingo.common_push.JPushManager;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by HongJay on 2016/12/10.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    String TAG = "MyFirebaseMessagingService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Service", "消息服务已启动");
    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "收到推送 From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "收到推送 Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "收到通知 Message Notification Body: " + remoteMessage.getNotification().getBody());
          try {
              Map<String,Object> map = new HashMap<>();
              map.put("title",remoteMessage.getNotification().getTitle());
              map.put("content",remoteMessage.getNotification().getBody());
              JPushManager.getInstance().sendLocalNotification(map);
          }catch (Exception e){

          }
           // sendSubscribeMsg(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
        }
       // showNotify();

    }

    @Override
    public void onMessageSent(String s) {
        super.onMessageSent(s);
        Log.i("Service", "onMessageSent" + s);
    }

}
