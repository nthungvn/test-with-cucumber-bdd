package cf.vlvn.nthung.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static cf.vlvn.nthung.config.BrowserType.CHROME;

public class AppConfig {
    private final Properties properties = new Properties();

    public AppConfig() {
        loadConfig();
    }

    public boolean isQuitBrowser() {
        return Boolean.parseBoolean(properties.getProperty("browser.quit", "true"));
    }

    public String browser() {
        return properties.getProperty("browser", CHROME.code());
    }

    private void loadConfig() {
        try (InputStream inputStream = this.getClass().getResourceAsStream("/app.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
