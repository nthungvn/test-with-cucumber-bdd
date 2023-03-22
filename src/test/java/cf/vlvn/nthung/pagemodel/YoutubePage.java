package cf.vlvn.nthung.pagemodel;

import cf.vlvn.nthung.shared.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubePage {

    private static final String HOME_PAGE = "https://www.youtube.com";
    private static final By SEARCH_INPUT = By.name("search_query");
    private static final By VIDEO_RESULT = By.cssSelector("ytd-video-renderer");
    private static final By VIDEO_TITLE = By.cssSelector(".title-and-badge a");

    private final WebDriver driver;

    public YoutubePage(TestContext context) {
        this.driver = context.getDriver();
    }

    public boolean isOpen(String link) {
        return link.contains(HOME_PAGE);
    }

    public void openHomePage() {
        driver.get(HOME_PAGE);
    }

    public WebElement getSearchInput() {
        return driver.findElement(SEARCH_INPUT);
    }

    public WebElement getSearchTheFirstResult() {
        return driver.findElement(VIDEO_RESULT);
    }

    public String getNameFromVideoResult(WebElement videoEl) {
        WebElement videoLink = videoEl.findElement(VIDEO_TITLE);
        return videoLink.getAttribute("title");
    }

    public void openVideoResult(WebElement videoEl) {
        WebElement videoLink = videoEl.findElement(VIDEO_TITLE);
        videoLink.click();
    }
}
