package cn.evilcoder.singleton;

/**
 * Created by huangshanqi on 2016/9/7.
 * 枚举类型的单例
 */
public enum EnumSingleton {
    INSTANCE(new EnumSingletonClass());

    private EnumSingletonClass instance;

    public EnumSingletonClass getInstance() {
        return instance;
    }

    public void setInstance(EnumSingletonClass instance) {
        this.instance = instance;
    }

    private EnumSingleton(EnumSingletonClass instance) {
        this.instance = instance;
    }
}
