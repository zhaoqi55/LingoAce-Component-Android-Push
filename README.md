# LingoAce-Component-Android-Push
极光推送Android端插件

前置条件：FCM相关内容解锁 需要将FireBase官网下申请下来的google-services.json文件放置在app目录下\n
并且将apply plugin: 'com.google.gms.google-services'添加到app目录下的build.gradl顶部
华为推送相关解锁需要添加华为开发者官网申下来的agconnect-services.json文件放置在app目录下，
并且将apply plugin: 'com.huawei.agconnect'添加到build.gradle顶部
如果需要使用FCM通道 app根目录下build.gradle的dependencies中需要添加：classpath 'com.google.gms:google-services:4.3.4'
如果需要使用华为通道 app根目录下build.gradle的dependencies中需要添加：classpath 'com.huawei.agconnect:agcp:1.4.2.300' 
repositories 和 allprojects 下repositories中需要添加maven {url 'http://developer.huawei.com/repo/'}

需要在主目录下添加config.gradle,
ext {
    manifestPlaceholders = [
            JPUSH_PKGNAME : "com.zts.firebaseapp",  
            JPUSH_APPKEY : "7f8c2bd1c2741cb2e70d5d93", //极光开发平台上注册的包名对应的appkey.
            JPUSH_CHANNEL : "developer-default", //暂时填写默认值即可.
            //xiaomi_config_start
            XIAOMI_APPID  : "MI-2882303761518978812",
            XIAOMI_APPKEY : "MI-5411897862812",
            //xiaomi_config_end
            //oppo_config_start
            OPPO_APPKEY   : "OP-b2ea2344c99d4e13bb3a1a6ff6444bcd",
            OPPO_APPID    : "OP-30454587",
            OPPO_APPSECRET: "OP-a8e2dc3aa5524e7bbd889a9b822bef03",
            //oppo_config_end
            //meizu_config_start
            MEIZU_APPKEY  : "MZ-41bccd5067674039b8446fc935fcb2fe",
            MEIZU_APPID   : "MZ-138291",
            //vivo_config_start
            VIVO_APPKEY   : "vivo的APPKEY",
            VIVO_APPID    : "vivo的APPID",
    ]
}
根目录下的build.gradle需要在顶部添加apply from: "config.gradle"

主项目的AndroidManifest.xml中需要添加：
   <service
            android:name="com.pplingo.jiguang_android.JPushCustomService"
            android:process=":pushcore">
            <intent-filter>
                <action android:name="cn.jiguang.user.service.action" />
            </intent-filter>
        </service>
        <receiver android:name="com.pplingo.common_push.PushMessageReceiver">
            <intent-filter>
                <action android:name="cn.jpush.android.intent.RECEIVE_MESSAGE" />
                <category android:name="${applicationId}"/>
            </intent-filter>
        </receiver>
        <meta-data
            android:name="com.google.firebase.messaging.default_notification_channel"
            android:value="@string/default_notification_channel_id" />
        <service
            android:name="com.pplingo.common_push.fcm.MyFirebaseMessagingService"
            android:enabled="true"
            android:exported="true">
            <intent-filter android:priority="10">
                <action android:name="com.google.firebase.MESSAGING_EVENT" />
            </intent-filter>
        </service>
        <service
            android:name="com.pplingo.common_push.fcm.MyFirebaseInstanceIDService"
            android:enabled="true"
            android:exported="true">
            <intent-filter android:priority="10">
                <action android:name="com.google.firebase.INSTANCE_ID_EVENT" />
            </intent-filter>
        </service>
        
        over


