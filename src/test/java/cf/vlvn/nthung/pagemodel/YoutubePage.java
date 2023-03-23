package cf.vlvn.nthung.pagemodel;

import cf.vlvn.nthung.shared.TestContext;
import org.openqa.selenium.WebDriver;

public class YoutubePage {

    private static final String HOME_PAGE = "https://www.youtube.com";

    private final WebDriver driver;

    public YoutubePage(TestContext context) {
        this.driver = context.getDriver();
    }

    public boolean isOpen(String link) {
        return link.contains(HOME_PAGE);
    }

    public String getTitleOfVideoPlaying() {
        return driver.getTitle();
    }
}
