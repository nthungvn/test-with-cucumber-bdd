package cf.vlvn.nthung.shared;

import cf.vlvn.nthung.config.AppConfig;
import cf.vlvn.nthung.config.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestContext {
    private final AppConfig config;
    private WebDriver driver;

    public TestContext(AppConfig config) {
        this.config = config;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            if (BrowserType.FIREFOX.same(config.browser())) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new FirefoxDriver(options);
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
            }
        }
        return driver;
    }
}
