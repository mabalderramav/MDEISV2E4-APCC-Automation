package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.steps.clients;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.helpers.HomeHelper;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.clients.ClientFormFields;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.clients.ClientsPage;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.home.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClientSteps {
    private final ClientsPage clientsPage;

    public ClientSteps() {
        this.clientsPage = new ClientsPage();
    }

    @Given("I am go to home page")
    public void goToHomePage() {
        HomeHelper.goToHomePage();
    }

    @Given("I am on the client page")
    public void iAmOnTheClientPage() {
        HomePage homePage = new HomePage();
        homePage.clickClientsLink();
    }

    @Given("I fill in the client form")
    public void iFillInTheClientForm(final Map<String, String> clientData) {
        var clientFormData = new HashMap<ClientFormFields, String>();
        clientData.forEach((key, value) -> {
            var clientFormField = Arrays.stream(ClientFormFields.values())
                    .filter(field -> field.getFieldName().equalsIgnoreCase(key)).findFirst().orElse(null);
            clientFormData.put(clientFormField, value);
        });
        clientsPage.fillClientForm(clientFormData);
    }

    @Given("I click on the save button")
    public void iClickOnTheSaveButton() {
        clientsPage.clickCreateButton();
    }

    @Then("I should display a {string} message")
    public void iShouldDisplayAMessage(String message) {
        Assertions.assertAll(
                () -> Assertions.assertTrue(clientsPage.isSuccessMessageDisplayed()),
                () -> Assertions.assertEquals(message, clientsPage.getSuccessMessage())
        );
    }
}
