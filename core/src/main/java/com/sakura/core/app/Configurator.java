package com.sakura.core.app;

import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.HashMap;

/**
 * 项目初始化配置
 */
public class Configurator {
    private static final HashMap<Object,Object> Cmr_Configs = new HashMap<>();

    public Configurator() {
        Cmr_Configs.put(ConfigKeys.CONFIG_READY,false);
    }

    /**
     * 静态内部类，线程安全的单例懒汉模式
     */
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final HashMap<Object,Object> getCmr_Configs(){
        return Cmr_Configs;
    }

    /**
     * 配置成功
     */
    public final void configure(){
        Logger.addLogAdapter(new AndroidLogAdapter());
        Cmr_Configs.put(ConfigKeys.CONFIG_READY,true);
        Utils.init(Cmr.getApplicationContext());
    }

    /**
     * 加载圈圈时间配置
     * @param delayed
     * @return
     */
    public final Configurator withLoaderDelayed(long delayed){
        Cmr_Configs.put(ConfigKeys.LOADER_DELAYED,delayed);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) Cmr_Configs.get(ConfigKeys.CONFIG_READY);
        if (!isReady){
            throw new RuntimeException("Configuration is not ready, call configure!");
        }
    }

    /**
     * 本方法用于得到相应的配置数据
     * @param key
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        final Object value = Cmr_Configs.get(key);
        if (value == null){
            throw new NullPointerException(key.toString());
        }
        return (T) Cmr_Configs.get(key);
    }

}
