const {Builder, By, Key} = require('selenium-webdriver');
const {Given, When, Then, AfterAll, After} = require('@cucumber/cucumber');
const assert = require('assert');
const until = require('selenium-webdriver/lib/until');
const And = Given;

const VIDEO_RESULTS = By.css("[jsname='TFTr6");
const VIDEO_TITLE = By.css(".WZIVy>.uOId3b>.fc9yUc>.cHaqb");
const VIDEO_LINK = By.className("X5OiLe");
const SEARCH_INPUT = By.name("q");
const ANSWER_SNIPPET = By.css("[data-tts='answers']");
const YOUTUBE_HOME_PAGE = "https://www.youtube.com";
const GOOGLE_HOME_PAGE = "https://www.google.com";


let driver;

And('I am on the Google Search page', {timeout: 60 * 1000}, async function () {
    driver = await new Builder().forBrowser('chrome').build();
    await driver.get(GOOGLE_HOME_PAGE);
});

When('I search with the keyword {string}', {timeout: 2 * 5000}, async function (searchTerm) {
    const element = driver.wait(until.elementLocated(SEARCH_INPUT));
    element.sendKeys(searchTerm, Key.RETURN);
});

Then('I see the answer {string} is highlighted', async function (answer) {
    const answerEl = driver.wait(until.elementLocated(ANSWER_SNIPPET));
    const actualAnswer = await answerEl.getAttribute("data-tts-text");
    assert.equal(answer, actualAnswer);
});

Then('The search result number {int} will be the song {string}', async function (result, songName) {
    // const videos = await driver.findElements(VIDEO_RESULTS);
    // this.videoSearchResult = videos[result - 1];
    // this.expectedSongName = songName;
    // const titleEl = await this.videoSearchResult.findElement(VIDEO_TITLE);
    // const title = await titleEl.getText();
    // console.log(`The song name ${title}`);
    // assert.equal(true, title.contains(songName));
});

Then('I can play it on Youtube', async function () {
    // const videoLink = await this.videoSearchResult.findElements(VIDEO_LINK).get(1);
    // videoLink.click();
    // const currentUrl = await driver.getCurrentUrl();
    // console.log(`Opened url: ${currentUrl}`);
    // assert.equal(true, currentUrl.contains(YOUTUBE_HOME_PAGE));
    //
    // const titleOfVideoPlaying = await driver.getTitle();
    // console.log(`The playing song name ${titleOfVideoPlaying}`);
    // assert.equal(true, titleOfVideoPlaying.contains(this.expectedSongName));
});

Then('I want to close browser', async function () {
    await driver.quit();
});

