package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.sales;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.sleeps.SleepUtils;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesPage extends BasePage {
    @FindBy(css = "input[name='clientCode']")
    private WebElement clientCodeTextBox;

    @FindBy(css = "select[name='payCondition']")
    private WebElement payConditionDropdownList;

    @FindBy(xpath = "//button[contains(text(), 'Agregar Producto')]")
    private WebElement addProductButton;

    @FindBy(xpath = "//button[contains(text(), 'Registrar Factura')]")
    private WebElement registerSalesButton;

    @FindBy(xpath= "//div[contains(text(), 'Guardado correctamente')]")
    private WebElement successMessage;

    public void fillClientSection(String clientCode, String type) {
        action.setValue(clientCodeTextBox, clientCode);
        action.selectDropDown(payConditionDropdownList, type);
    }

    public void clickAddProductButton() {
        action.click(addProductButton);
    }

    public void clickOnGetProductButton(String productCode) {
        var cssSelector = String.format("button[data-testid='btnGetProduct-%s']", productCode);
        action.click(By.cssSelector(cssSelector));
        SleepUtils.waitFor(2);
    }

    public void clickRegisterSaleButton() {
        action.click(registerSalesButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return action.isElementDisplayed(successMessage);
    }

    public String getSuccessMessage() {
        return action.getText(successMessage);
    }
}
