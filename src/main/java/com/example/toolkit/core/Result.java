package com.example.toolkit.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果集
 *
 * @author chenpenghui
 * @date 2020/6/14
 */
public class Result extends HashMap<String, Object> {

    private static final long serialVersionUID = -1914243303483670534L;

    public Result() {
        put("code", "0");
        put("msg", "success");
    }

    public static Result ok() {
        return new Result();
    }

    public static Result ok(Map<String, Object> map) {
        Result result = new Result();
        result.putAll(map);
        return result;
    }

    public static Result ok(Object obj) {
        Result result = new Result();
        result.put("data", obj);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.put("msg", msg);
        return result;
    }

    public static Result error(int code, String msg) {
        Result result = new Result();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error() {
        return error(500, "未知异常，请联系管理员");
    }

}
