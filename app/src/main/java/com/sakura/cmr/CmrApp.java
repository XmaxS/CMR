package com.sakura.cmr;

import android.app.Application;
import com.sakura.core.app.Cmr;

/**
 * 全局初始化，数据可以在所有的activity中使用
 */
public class CmrApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        /**
         * 标准初始化模式
         */
        Cmr.init(this)
                .withLoaderDelayed(1000)
                .configure();

    }
}
