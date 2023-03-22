package cf.vlvn.nthung;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", snippets = CAMELCASE,
        tags = "@integration-test", stepNotifications = true)
public class RunCucumberIntegrationTest {
}
