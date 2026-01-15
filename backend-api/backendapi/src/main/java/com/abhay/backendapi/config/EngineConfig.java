package com.abhay.backendapi.config;

import com.abhay.ruleengine.engine.RuleEngine;
import com.abhay.ruleengine.demo.LoginFailureDemo;
import com.abhay.ruleengine.demo.CpuAlertDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfig {

    @Bean
    public RuleEngine ruleEngine() {
        RuleEngine engine = new RuleEngine();

        // Register rules
        LoginFailureDemo.register(engine);
        CpuAlertDemo.register(engine);

        return engine;
    }
}
