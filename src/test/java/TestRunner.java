import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json",
                "pretty","summary"}
        , features = "src/test/resources/features/ImageRecognizeAPI.feature"
        , monochrome = true
)
public class TestRunner
{
}