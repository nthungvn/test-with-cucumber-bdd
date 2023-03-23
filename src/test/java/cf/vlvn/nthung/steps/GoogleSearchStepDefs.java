package cf.vlvn.nthung.steps;

import cf.vlvn.nthung.pagemodel.GooglePage;
import cf.vlvn.nthung.pagemodel.YoutubePage;
import cf.vlvn.nthung.shared.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchStepDefs {
    private static final Logger log = LoggerFactory.getLogger(GoogleSearchStepDefs.class);

    private final TestContext context;
    private final GooglePage googlePage;
    private final YoutubePage youtubePage;
    private WebElement videoSearchResult;
    private String expectedSongName;

    public GoogleSearchStepDefs(TestContext context,
                                GooglePage googlePage,
                                YoutubePage youtubePage) {
        this.context = context;
        this.googlePage = googlePage;
        this.youtubePage = youtubePage;

    }

    @Given("I am on the Google Search page")
    public void iAmTheGoogleSearchPage() {
        googlePage.openHomePage();
    }

    @When("I search with the keyword {string}")
    public void iAmTypeKeywordToTheSearchBox(String searchTerm) {
        WebElement searchInput = googlePage.getSearchInput();
        searchInput.sendKeys(searchTerm);
        searchInput.submit();
    }

    @Then("The search result number {int} will be the song {string}")
    public void theSearchResultNumberWillBeTheSong(int result, String songName) {
        videoSearchResult = googlePage.getVideoSearchResultAt(result);
        this.expectedSongName = songName;
        String title = googlePage.getNameFromVideoResult(videoSearchResult);
        log.debug("The song name {}", title);
        assertTrue(title.contains(songName));
    }

    @Then("I can play it on Youtube")
    public void iCanPlayItOnYoutube() {
        googlePage.openVideoSearch(videoSearchResult);
        String currentUrl = context.getDriver().getCurrentUrl();
        log.debug("Opened url: {}", currentUrl);
        assertTrue(youtubePage.isOpen(currentUrl));

        String titleOfVideoPlaying = youtubePage.getTitleOfVideoPlaying();
        log.debug("The playing song name {}", titleOfVideoPlaying);
        assertTrue(titleOfVideoPlaying.contains(expectedSongName));
    }

    @Then("I see the answer {string} is highlighted")
    public void iSeeTheAnswerIsHighlighted(String answer) {
        String actualAnswer = googlePage.getTheAnswerSnippet();
        assertEquals(answer, actualAnswer);
    }
}
