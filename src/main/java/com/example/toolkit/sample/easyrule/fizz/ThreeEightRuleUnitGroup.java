package com.example.toolkit.sample.easyrule.fizz;

import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.support.UnitRuleGroup;

/**
 * @Description
 * @Author chenpenghui
 * @Date 2020/4/17
 */
@Rule(name = "被3和8同时整除", description = "组合规则")
public class ThreeEightRuleUnitGroup extends UnitRuleGroup {

    public ThreeEightRuleUnitGroup(Object... rules) {
        for (Object rule : rules) {
            addRule(rule);
        }
    }

    @Override
    public int getPriority() {
        return 99;
    }
}