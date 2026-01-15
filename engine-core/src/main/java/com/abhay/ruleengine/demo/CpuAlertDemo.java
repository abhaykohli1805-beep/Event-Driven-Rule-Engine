package com.abhay.ruleengine.demo;

import com.abhay.ruleengine.engine.Action;
import com.abhay.ruleengine.engine.Condition;
import com.abhay.ruleengine.engine.Rule;
import com.abhay.ruleengine.engine.RuleEngine;
import com.abhay.ruleengine.events.EventType;

/**
 * Demonstrates CPU monitoring alert rule.
 */
public class CpuAlertDemo {

    public static void register(RuleEngine engine) {

        Condition cpuHighTwiceInTwoMinutes = (store, event) -> {
            if (event.getType() != EventType.CPU_HIGH) {
                return false;
            }

            long twoMinutesAgo = event.getTimestamp() - 120_000;

            long count = store.countEvents(
                    EventType.CPU_HIGH,
                    event.getEntityId(),
                    twoMinutesAgo
            );

            return count >= 2;
        };

        Action alertAction = event ->
                System.out.println(
                        "⚠️ ALERT: High CPU detected for service: "
                                + event.getEntityId()
                );

        Rule cpuAlertRule = new Rule(cpuHighTwiceInTwoMinutes, alertAction);

        engine.registerRule(cpuAlertRule);
    }
}
