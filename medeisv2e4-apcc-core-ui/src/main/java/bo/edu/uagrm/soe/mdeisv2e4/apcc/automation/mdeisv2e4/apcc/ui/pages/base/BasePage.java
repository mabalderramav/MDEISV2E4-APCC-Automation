package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.base;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.environment.EnvironmentManager;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.webdrivers.WebDriverActions;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.webdrivers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected final WebDriver webDriver;
    protected final WebDriverWait webDriverWait;
    protected final EnvironmentManager environmentManager;

    protected WebDriverActions action;

    public BasePage() {
        environmentManager = EnvironmentManager.getInstance();
        WebDriverManager webDriverManager = WebDriverManager.getInstance();
        webDriver = webDriverManager.getWebDriver();
        webDriverWait = webDriverManager.getWebDriverWait();
        this.action = new WebDriverActions(webDriver, webDriverWait);
        PageFactory.initElements(webDriver, this);
    }
}
