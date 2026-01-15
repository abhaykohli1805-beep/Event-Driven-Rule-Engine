package com.abhay.ruleengine;

import com.abhay.ruleengine.demo.CpuAlertDemo;
import com.abhay.ruleengine.demo.LoginFailureDemo;
import com.abhay.ruleengine.engine.RuleEngine;
import com.abhay.ruleengine.events.Event;
import com.abhay.ruleengine.events.EventType;

/**
 * Entry point of the application.
 * Demonstrates security and monitoring rule execution.
 */
public class Main {

    // Time constants (avoid magic numbers)
    private static final long ONE_SECOND = 1_000;
    private static final long THIRTY_SECONDS = 30_000;

    public static void main(String[] args) throws InterruptedException {

        RuleEngine engine = new RuleEngine();

        registerRules(engine);

        simulateLoginFailures(engine);
        simulateCpuAlerts(engine);
    }

    private static void registerRules(RuleEngine engine) {
        LoginFailureDemo.register(engine);
        CpuAlertDemo.register(engine);
    }

    private static void simulateLoginFailures(RuleEngine engine) throws InterruptedException {
        engine.process(new Event(
                EventType.LOGIN_FAILED,
                "abhay",
                System.currentTimeMillis()
        ));

        Thread.sleep(ONE_SECOND);

        engine.process(new Event(
                EventType.LOGIN_FAILED,
                "abhay",
                System.currentTimeMillis()
        ));

        Thread.sleep(ONE_SECOND);

        engine.process(new Event(
                EventType.LOGIN_FAILED,
                "abhay",
                System.currentTimeMillis()
        ));
    }

    private static void simulateCpuAlerts(RuleEngine engine) throws InterruptedException {
        Thread.sleep(ONE_SECOND);

        engine.process(new Event(
                EventType.CPU_HIGH,
                "auth-service",
                System.currentTimeMillis()
        ));

        Thread.sleep(THIRTY_SECONDS);

        engine.process(new Event(
                EventType.CPU_HIGH,
                "auth-service",
                System.currentTimeMillis()
        ));
    }
}
