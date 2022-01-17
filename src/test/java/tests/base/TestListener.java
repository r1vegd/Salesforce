package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info(String.format(">>>>>>>Test %s started", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format(">>>>>>>Test %s successfully finished", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(String.format(">>>>>>>Test %s failed", result.getName()));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info(String.format(">>>>>>>Test %s failed with timeout", result.getName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test finished");
    }
}