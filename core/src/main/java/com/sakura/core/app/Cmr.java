package com.sakura.core.app;

import android.content.Context;

/**
 * app配置工具类
 */
public final class Cmr {

    public static Configurator init(Context context){
        Configurator.getInstance()
                .getCmr_Configs()
                .put(ConfigKeys.APPLICATION_CONTEXT,context.getApplicationContext());
        return Configurator.getInstance();
    }

    /**
     * 获得配置器
     * @return
     */
    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    /**
     * 获得相应配置
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getConfiguration(Object key){
        return getConfigurator().getConfiguration(key);
    }

    /**
     * 获得Context
     * @return
     */
    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }
}
