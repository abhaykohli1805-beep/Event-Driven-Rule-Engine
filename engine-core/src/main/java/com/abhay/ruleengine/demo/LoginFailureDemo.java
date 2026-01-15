package com.abhay.ruleengine.demo;

import com.abhay.ruleengine.engine.Action;
import com.abhay.ruleengine.engine.Condition;
import com.abhay.ruleengine.engine.Rule;
import com.abhay.ruleengine.engine.RuleEngine;
import com.abhay.ruleengine.events.EventType;

/**
 * Demonstrates a login failure rule.
 */
public class LoginFailureDemo {

    public static void register(RuleEngine engine) {

        Condition failedThreeTimesInOneMinute = (store, event) -> {
            if (event.getType() != EventType.LOGIN_FAILED) {
                return false;
            }

            long oneMinuteAgo = event.getTimestamp() - 60_000;

            long failureCount = store.countEvents(
                    EventType.LOGIN_FAILED,
                    event.getEntityId(),
                    oneMinuteAgo
            );

            return failureCount >= 3;
        };

        Action blockUserAction = event ->
                System.out.println("🚫 User blocked due to repeated login failures: "
                        + event.getEntityId());

        Rule loginFailureRule = new Rule(
                failedThreeTimesInOneMinute,
                blockUserAction
        );

        engine.registerRule(loginFailureRule);
    }
}
