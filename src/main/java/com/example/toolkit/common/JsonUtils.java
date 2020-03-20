package com.example.toolkit.common;

import com.alibaba.fastjson.JSON;

/**
 * JSON转换
 *
 * @author cph
 * @version 1.0.0
 * @date 2018/12/20
 */
public class JsonUtils {

    /**
     * Java对象转换为JSON字符串
     *
     * @param obj
     * @return String
     */
    public static final String toJson(final Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * JSON字符串解析为Java对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return T
     */
    public static final <T> T toObject(final String json, final Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

}
