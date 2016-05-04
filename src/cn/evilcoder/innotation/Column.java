package cn.evilcoder.innotation;

import java.lang.annotation.*;

/**
 * Created by huangshanqi on 2016/5/4.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Column {
    public String value();
}
