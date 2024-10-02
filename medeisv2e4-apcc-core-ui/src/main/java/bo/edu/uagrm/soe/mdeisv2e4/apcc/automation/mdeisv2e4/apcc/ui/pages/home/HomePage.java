package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.home;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "a[href='/clientes']")
    private WebElement clientsLink;

    public HomePage() {
        super();
    }

    public void clickClientsLink() {
        action.click(clientsLink);
    }
}
