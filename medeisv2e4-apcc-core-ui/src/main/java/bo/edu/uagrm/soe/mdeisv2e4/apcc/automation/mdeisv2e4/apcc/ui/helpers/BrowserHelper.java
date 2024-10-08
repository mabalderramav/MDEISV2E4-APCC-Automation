package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.helpers;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.webdrivers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Objects;

/**
 * Browser helper class.
 */
public final class BrowserHelper {
    private BrowserHelper() {
    }

    /**
     * Close the browser.
     */
    public static void closeBrowser() {
        if (!Objects.isNull(WebDriverManager.getInstance().getWebDriver())) {
            WebDriverManager.getInstance().quitWebDriver();
        }
    }

    /**
     * Take a screenshot.
     *
     * @return image as byte[].
     */
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverManager.getInstance().getWebDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}
