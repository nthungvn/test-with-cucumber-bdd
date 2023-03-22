package cf.vlvn.nthung.steps;

import cf.vlvn.nthung.pagemodel.YoutubePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class YoutubeStepDefs {

    private static final Logger log = LoggerFactory.getLogger(YoutubeStepDefs.class);

    private final YoutubePage youtubePage;

    public YoutubeStepDefs(YoutubePage youtubePage) {
        this.youtubePage = youtubePage;
    }

    @Given("I am on the Youtube page")
    public void iAmTheYoutubePage() {
        youtubePage.openHomePage();
    }

    @When("I search {string}")
    public void iSearch(String searchTerm) {
        WebElement searchInput = youtubePage.getSearchInput();
        searchInput.sendKeys(searchTerm);
        searchInput.submit();
    }

    @Then("I can play the first result that will be the song {string} I want")
    public void iCanPlayNumberResultWhatWillBeTheSong(int result, String songName) {
        WebElement videoSearchResult = youtubePage.getSearchTheFirstResult();
        String title = youtubePage.getNameFromVideoResult(videoSearchResult);
        log.debug("The song name {}", title);
        assertTrue(title.contains(songName));
        youtubePage.openVideoResult(videoSearchResult);
    }
}
