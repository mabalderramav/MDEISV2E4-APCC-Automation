package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"medeisv2e4-apcc-api/src/test/resources/features/"},
        glue = {"bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.api"},
        plugin = {"pretty"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
