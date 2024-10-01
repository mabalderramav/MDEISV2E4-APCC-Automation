package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.browsers;


import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.config.UiConfig;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Initializes an instance of a Chrome web driver.
 */
public abstract class Chrome {
    protected static final boolean IS_HEADLESS_MODE = UiConfig.getInstance().isHeadlessMode();

    protected static final String WEBDRIVER_VERSION = UiConfig.getInstance().getChromeDriverVersion();

    /**
     * Initializes options of {@link Chrome}.
     */
    protected ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (IS_HEADLESS_MODE) {
            chromeOptions.addArguments("--headless=new");
        }
        return chromeOptions;
    }
}
