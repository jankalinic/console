package com.github.streamshub.systemtests.annotations;

import com.github.streamshub.systemtests.Environment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class OlmInstallOnlyCondition implements ExecutionCondition {
    private static final Logger LOGGER = LogManager.getLogger(OlmInstallOnlyCondition.class);

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        if(Environment.isOlmInstall()) {
            return ConditionEvaluationResult.enabled("Test is enabled");
        }
        LOGGER.warn("Test is disabled");
        return ConditionEvaluationResult.disabled("Test is disabled due to different install type requirement");
    }
}