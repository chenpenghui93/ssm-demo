package com.example.toolkit.common.inject;

import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author cph
 * @Date 2020/4/5
 */
@Controller
public class BizController {

    private final BizService bizService;

    public BizController(BizService bizService) {
        this.bizService = bizService;
    }

}
