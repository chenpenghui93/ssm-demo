package com.example.toolkit.sample.quartz;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * QuartzConfig
 *
 * @author chenpenghui
 * @date 2021-2-24
 */
@Data
public class QuartzConfig {

    private Long id;

    @TableField(value = "t_name")
    private String name;

    @TableField(value = "t_group")
    private String groupName;

    private String classPath;

    private String methodName;

    private String status;

    private String cron;
}
