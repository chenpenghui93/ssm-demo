package com.example.ssmdemo.helloworld.jsonDemo;

import com.alibaba.fastjson.JSON;

/**
 * 对象与JSON互转，使用工具类便于后续切换JSON生成工具
 * JSON：http://www.json.org/json-zh.html
 * fastjson：https://github.com/alibaba/fastjson/wiki
 * API：JSON.toJSONString()，JSON.parseObject()
 *
 * @author cph
 * @version 1.0.0
 * @date 2018/12/20
 */
public class JsonUtils {

    /**
     * 对象转换为JSON字符串
     *
     * @param obj
     * @return String
     */
    public static final String toJson(final Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * JSON字符串解析为对象
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
