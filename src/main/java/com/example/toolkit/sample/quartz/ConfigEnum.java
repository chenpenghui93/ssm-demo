package com.example.toolkit.sample.quartz;

/**
 * @author chenpenghui
 * @date 2021-2-24
 */
public enum ConfigEnum {
    STATUS_START("0", "启用"),
    STATUS_STOP("1", "禁用");

    private String code;
    private String message;

    ConfigEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String findByMessage(String code) {
        for (ConfigEnum configEnum : ConfigEnum.values()) {
            if (configEnum.code.equals(code)) {
                return configEnum.message;
            }
        }
        return null;
    }
}
