package cf.vlvn.nthung;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun = true, features = "classpath:features", snippets = CAMELCASE)
public class RunCucumberTest {
}
