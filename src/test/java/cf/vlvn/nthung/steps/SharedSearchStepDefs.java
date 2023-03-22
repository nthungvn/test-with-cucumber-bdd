package cf.vlvn.nthung.steps;

import cf.vlvn.nthung.config.AppConfig;
import cf.vlvn.nthung.shared.TestContext;
import io.cucumber.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SharedSearchStepDefs {
    private static final Logger log = LoggerFactory.getLogger(SharedSearchStepDefs.class);

    private final AppConfig appConfig;
    private final TestContext context;

    public SharedSearchStepDefs(AppConfig appConfig, TestContext context) {
        this.appConfig = appConfig;
        this.context = context;
    }

    @And("I want to close browser")
    public void iWantToCloseBrowser() {
        if (appConfig.isQuitBrowser()) {
            try {
                Thread.sleep(appConfig.browserQuitTimeout());
            } catch (InterruptedException e) {
                log.error("Cannot waiting the browser quitting");
            }
            context.getDriver().quit();
        }
    }

}