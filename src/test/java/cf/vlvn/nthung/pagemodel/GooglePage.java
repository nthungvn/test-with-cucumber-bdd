package cf.vlvn.nthung.pagemodel;

import cf.vlvn.nthung.shared.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    private static final By VIDEO_RESULTS = By.cssSelector("[jsname='TFTr6");
    private static final By VIDEO_TITLE = By.cssSelector(".WZIVy>.uOId3b>.fc9yUc>.cHaqb");
    private static final By VIDEO_LINK = By.className("X5OiLe");
    private static final By SEARCH_INPUT = By.name("q");
    private static final String HOME_PAGE = "https://www.google.com/";
    private final WebDriver driver;

    public GooglePage(TestContext context) {
        this.driver = context.getDriver();
    }

    public WebElement getSearchInput() {
        return driver.findElement(SEARCH_INPUT);
    }

    public void openHomePage() {
        driver.get(HOME_PAGE);
    }

    public WebElement getVideoSearchResultAt(int order) {
        List<WebElement> videos = driver.findElements(VIDEO_RESULTS);
        return videos.get(order - 1);
    }

    public void openVideoSearch(WebElement videoEl) {
        WebElement videoLink = videoEl.findElements(VIDEO_LINK).get(1);
        videoLink.click();
    }

    public String getNameFromVideoResult(WebElement videoEl) {
        WebElement titleEl = videoEl.findElement(VIDEO_TITLE);
        return titleEl.getText();
    }

}
