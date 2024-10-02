package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.clients;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.base.BasePage;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.steps.StrategySetterStep;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ClientsPage extends BasePage {

    @FindBy(css = "input[name='code']")
    private WebElement codeTextBox;

    @FindBy(css = "input[name='name']")
    private WebElement nameTextBox;

    @FindBy(css = "input[name='ciNit']")
    private WebElement ciNitTextBox;

    @FindBy(css = "select[name='documentType']")
    private WebElement documentTypeDropdownList;

    @FindBy(css = "input[name='email']")
    private WebElement emailTypeTextBox;

    @FindBy(css = "button[type='submit']")
    private WebElement createButton;

    @FindBy(xpath= "//div[contains(text(), 'Guardado correctamente')]")
    private WebElement successMessage;

    public ClientsPage() {
        super();
    }

    public void fillCode(String code) {
        action.setValue(codeTextBox, code);
    }

    public void fillName(String name) {
        action.setValue(nameTextBox, name);
    }

    public void fillCiNit(String ciNit) {
        action.setValue(ciNitTextBox, ciNit);
    }

    public void fillDocumentType(String documentType) {
        action.selectDropDown(documentTypeDropdownList, documentType);
    }

    public void fillEmail(String email) {
        action.setValue(emailTypeTextBox, email);
    }

    public void fillClientForm(final Map<ClientFormFields, String> dataClientForm) {
        var sortedKeys = new ArrayList<>(dataClientForm.keySet());
        Collections.sort(sortedKeys);
        sortedKeys.forEach(step -> getStrategyMap(dataClientForm).get(step).executeStep());
    }

    private Map<ClientFormFields, StrategySetterStep> getStrategyMap(final Map<ClientFormFields, String> dataClientForm) {
        return Map.of(
                ClientFormFields.CODE, () -> fillCode(dataClientForm.get(ClientFormFields.CODE)),
                ClientFormFields.NAME, () -> fillName(dataClientForm.get(ClientFormFields.NAME)),
                ClientFormFields.CI_NIT, () -> fillCiNit(dataClientForm.get(ClientFormFields.CI_NIT)),
                ClientFormFields.DOCUMENT_TYPE, () -> fillDocumentType(dataClientForm.get(ClientFormFields.DOCUMENT_TYPE)),
                ClientFormFields.EMAIL, () -> fillEmail(dataClientForm.get(ClientFormFields.EMAIL))
        );
    }

    public void clickCreateButton() {
        action.click(createButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return action.isElementDisplayed(successMessage);
    }

    public String getSuccessMessage() {
        return action.getText(successMessage);
    }
}
