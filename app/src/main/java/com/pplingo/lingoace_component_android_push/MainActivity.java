package com.pplingo.lingoace_component_android_push;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pplingo.common_push.JPushManager;
import com.pplingo.common_push.bean.CommonPushResultBean;
import com.pplingo.common_push.callback.CommPushCallBack;
import com.pplingo.common_push.callback.PushSeqCallBack;

import java.util.Map;

import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSetAlias = findViewById(R.id.btn_setAlias);
        Button btnGetAlias = findViewById(R.id.btn_getAlias);
        JPushManager.getInstance().init(MainActivity.this);
        JPushManager.getInstance().setUp(MainActivity.this, true);
        JPushManager.getInstance().callBack = new CommPushCallBack() {
            @Override
            public void onTagCheckResult(CommonPushResultBean commonBean) {
                Log.e("MainActivity", "拿到了检查标签的操作");
            }

            @Override
            public void onTagOperateResult(CommonPushResultBean commonBean) {
                Log.e("MainActivity", "拿到了操作标签的操作");
            }

            @Override
            public void onAliasOperatorResult(CommonPushResultBean commonBean) {
                Log.e("MainActivity", "拿到了操作别名的回调");
            }

            @Override
            public void transmitReceiveRegistrationId(String rId) {

            }

            @Override
            public void transmitMessageReceive(String title, Map<String, Object> extras) {

            }

            @Override
            public void transmitNotificationOpen(String title, String alert, Map<String, Object> extras) {

            }

            @Override
            public void transmitNotificationReceive(String title, String alert, Map<String, Object> extras) {

            }
        };
        btnSetAlias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JPushManager.getInstance().setAlias(MainActivity.this, "LingoAceComponentAndroidPush", new PushSeqCallBack() {
                    @Override
                    public void getSeq(int seq) {
                        Log.e("=====",""+seq);

                    }
                });
            }
        });

        btnGetAlias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JPushManager.getInstance().getAlias(MainActivity.this, new PushSeqCallBack() {
                    @Override
                    public void getSeq(int seq) {
                        Log.e("=====",""+seq);
                    }
                });
            }
        });


    }

    /**
     * 建议使用优先级：1
     */
    private void useHandler1() {
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String registerId = JPushInterface.getRegistrationID(MainActivity.this);
                Log.e("===RegistrationId", registerId);
                Toast.makeText(MainActivity.this, registerId, Toast.LENGTH_LONG);
            }
        }, 2000);
    }
}