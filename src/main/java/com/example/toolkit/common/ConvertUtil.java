package com.example.toolkit.common;

import com.alibaba.fastjson.JSON;
import com.google.common.base.CaseFormat;

/**
 * 转换工具类
 *
 * @author chenpenghui
 * @date 2018/12/20
 */
public class ConvertUtil {

    /**
     * Java 对象转换为 JSON 字符串
     *
     * @param obj
     * @return String
     */
    public static final String toJson(final Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * JSON 字符串解析为 Java 对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return T
     */
    public static final <T> T toObject(final String json, final Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 小驼峰转下划线,例 "testData" -> "test_data"
     *
     * @param str
     * @return
     */
    public static String lowerCamel2Underscope(String str) {
        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }
}
