package com.pplingo.common_push;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;

public class PushMessageReceiver extends JPushMessageReceiver {
    private static final String TAG = "PushMessageReceiver";

    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage message) {
        Log.e(TAG, "[onNotifyMessageArrived] " + message);
    }

    @Override
    public void onNotifyMessageDismiss(Context context, NotificationMessage message) {
        Log.e(TAG, "[onNotifyMessageDismiss] " + message);
    }

    @Override
    public void onRegister(Context context, String registrationId) {
        Log.e(TAG, "[onRegister] " + registrationId);
    }

    @Override
    public void onConnected(Context context, boolean isConnected) {
        Log.e(TAG, "[onConnected] " + isConnected);
    }

    @Override
    public void onCommandResult(Context context, CmdMessage cmdMessage) {
        Log.e(TAG, "[onCommandResult] " + cmdMessage);
    }

    @Override
    public void onTagOperatorResult(final Context context, final JPushMessage jPushMessage) {

        super.onTagOperatorResult(context, jPushMessage);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                JPushManager.getInstance().onTagOperatorResult(context, jPushMessage);
            }
        });

    }

    @Override
    public void onCheckTagOperatorResult(final Context context, final JPushMessage jPushMessage) {

        super.onCheckTagOperatorResult(context, jPushMessage);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                JPushManager.getInstance().onCheckTagOperatorResult(context, jPushMessage);
            }
        });
    }

    @Override
    public void onAliasOperatorResult(final Context context, final JPushMessage jPushMessage) {
        super.onAliasOperatorResult(context, jPushMessage);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                JPushManager.getInstance().onAliasOperatorResult(context, jPushMessage);
            }
        });
    }


}
