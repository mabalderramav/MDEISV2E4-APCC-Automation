package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"medeisv2e4-apcc-ui/src/test/resources/features/"},
        glue = {"bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui"},
        plugin = {"pretty"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
