package com.example.toolkit.demo.easyrule.helloworld;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author chenpenghui
 * @date 2020/6/15
 */
public class Launcher {
    public static void main(String[] args) {

        Facts facts = new Facts();

        Rules rules = new Rules();
        rules.register(new HelloWorldRule());

        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

    }
}
