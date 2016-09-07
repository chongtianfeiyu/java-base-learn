package cn.evilcoder.singleton;

/**
 * Created by huangshanqi on 2016/9/7.
 * 静态内部类，懒惰加载
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {

    }

    private static class SingletonHolder {
        private static StaticInnerSingleton instance = new StaticInnerSingleton();
    }
    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
    }
}
