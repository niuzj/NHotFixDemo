package niu.nhotfixdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

/**
 * Created by Qinlian_niu on 2018/3/1.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //*******************升级设置*********************
        //自动初始化开关
        Beta.autoInit = true;
        //自动检查更新开关,true表示初始化时自动检查升级; false表示不会自动检查升级,需要手动调用Beta.checkUpgrade()方法;
        Beta.autoCheckUpgrade = true;
        //升级检查周期设置 60s
        Beta.upgradeCheckPeriod = 0;
        //延迟初始化,设置启动延时为1s（默认延时3s），APP启动1s后初始化SDK，避免影响APP启动速度;
        Beta.initDelay = 1 * 1000;
        //设置通知栏大图标
        Beta.largeIconId = R.mipmap.ic_launcher;
        //设置状态栏小图标
        Beta.smallIconId = R.mipmap.ic_launcher;
        //设置是否显示消息通知
        Beta.enableNotification = true;
        //升级SDK默认是开启热更新能力的，如果你不需要使用热更新，可以将这个接口设置为false。
        Beta.enableHotfix = true;
        //********************热更新设置********************


        //初始化
        Bugly.init(this, Constant.BUGLY_ID, Constant.DEBUG);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);

        Beta.installTinker();
    }
}
