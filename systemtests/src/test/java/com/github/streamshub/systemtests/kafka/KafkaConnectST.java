package com.github.streamshub.systemtests.kafka;

import com.github.streamshub.systemtests.AbstractST;
import com.github.streamshub.systemtests.TestCaseConfig;
import com.github.streamshub.systemtests.constants.TestTags;
import com.github.streamshub.systemtests.logs.LogWrapper;
import com.github.streamshub.systemtests.setup.console.ConsoleInstanceSetup;
import com.github.streamshub.systemtests.setup.strimzi.KafkaSetup;
import com.github.streamshub.systemtests.utils.playwright.PwPageUrls;
import com.github.streamshub.systemtests.utils.playwright.PwUtils;
import com.github.streamshub.systemtests.utils.resourceutils.KafkaNamingUtils;
import com.github.streamshub.systemtests.utils.resourceutils.NamespaceUtils;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.github.streamshub.systemtests.utils.Utils.getTestCaseConfig;


@Tag(TestTags.REGRESSION)
public class KafkaConnectST extends AbstractST {
    private static final Logger LOGGER = LogWrapper.getLogger(KafkaST.class);

    @Test
    void testConnect() {
        final TestCaseConfig tcc = getTestCaseConfig();
        LOGGER.info("START");
        tcc.page().navigate(PwPageUrls.getKafkaBaseUrl(tcc, tcc.kafkaName()));
        LOGGER.info("STOP");
    }

    @BeforeEach
    void testCaseSetup() {
        final TestCaseConfig tcc = getTestCaseConfig();
        NamespaceUtils.prepareNamespace(tcc.namespace());
        KafkaSetup.setupDefaultKafkaIfNeeded(tcc.namespace(), tcc.kafkaName());
        KafkaSetup.setupDefaultConnectIfNeeded(tcc.namespace(), KafkaNamingUtils.kafkaConnectName(tcc.kafkaName()), tcc.kafkaName(), tcc.kafkaUserName(), 1);

        ConsoleInstanceSetup.setupIfNeeded(ConsoleInstanceSetup.getDefaultConnectConsoleInstance(tcc.namespace(),
            tcc.consoleInstanceName(), tcc.kafkaName(), tcc.kafkaUserName(), KafkaNamingUtils.kafkaConnectName(tcc.kafkaName())).build());
        PwUtils.login(tcc);
    }

    @AfterEach
    void testCaseTeardown() {
        getTestCaseConfig().playwright().close();
    }

}
