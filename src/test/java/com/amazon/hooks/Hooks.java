package com.amazon.hooks;

import java.io.IOException;
import com.amazon.utils.TestContext;
import com.amazon.utils.Utility;
import io.cucumber.java.*;

public class Hooks {
    private TestContext testContext;

    public Hooks() throws InterruptedException, IOException {
        this.testContext = TestContext.getInstance();
    }

    @Before
    public void beforeScenario(Scenario scenario) throws InterruptedException, IOException {
        testContext.getDriver().get(testContext.getUrl());
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException, InterruptedException {
        if (scenario.isFailed()) {
            String screenshotPath = testContext.getUtility().captureScreenshotReport(scenario.getName());
            scenario.attach(screenshotPath, "image/png", "screenshot");
        }
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        testContext.quitDriver();
    }
}
