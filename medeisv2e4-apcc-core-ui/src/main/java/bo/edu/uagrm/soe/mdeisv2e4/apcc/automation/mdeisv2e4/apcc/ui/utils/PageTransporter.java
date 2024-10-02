package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.utils;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.environment.EnvironmentManager;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.webdrivers.WebDriverManager;

/**
 * Class to navigate to specific pages.
 */
public class PageTransporter {
    /**
     * Private constructor for {@link PageTransporter}.
     */
    private PageTransporter() {
        // Default constructor.
    }

    /**
     * Navigates to specific Url.
     *
     * @param url valid Url string.
     */
    public static void navigateToUrl(String url) {
        var webDriverManager = WebDriverManager.getInstance();
        webDriverManager.getWebDriver().navigate().to(url);
    }

    /**
     * Refresh the page.
     */
    public static void refreshPage() {
        var webDriverManager = WebDriverManager.getInstance();
        webDriverManager.getWebDriver().navigate().refresh();
    }
}
