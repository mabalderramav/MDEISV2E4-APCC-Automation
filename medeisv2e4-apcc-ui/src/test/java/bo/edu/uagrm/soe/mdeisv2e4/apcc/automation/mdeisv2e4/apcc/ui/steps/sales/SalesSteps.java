package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.steps.sales;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.home.HomePage;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.pages.sales.SalesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class SalesSteps {

    private final SalesPage salesPage;

    public SalesSteps() {
        this.salesPage = new SalesPage();
    }

    @And("I am on the sales page")
    public void iAmOnTheSalesPage() {
        HomePage homePage = new HomePage();
        homePage.clickSalesLink();
    }

    @When("I fill in the client section")
    public void iFillInTheClientSection(final Map<String, String> clientData) {
        var clientCode = clientData.get("Codigo Cliente");
        var payCondition = clientData.get("Tipo Pago");
        salesPage.fillClientSection(clientCode, payCondition);
    }

    @When("I fill on the details product section")
    public void iFillOnTheDetailsProductSection(List<Map<String, String>> detailsProductList) {
        detailsProductList.forEach(detailProduct -> {
            salesPage.clickAddProductButton();
            var productCode = detailProduct.get("Codigo Producto");
            salesPage.clickOnGetProductButton(productCode);
        });
    }

    @And("I click on 'Registrar Factura' button")
    public void iClickOnRegistrarFacturaButton() {
        salesPage.clickRegisterSaleButton();
    }

    @Then("I should display a {string} message on sales page")
    public void iShouldDisplayAMessageOnSalesPage(String message) {
        Assertions.assertAll(
                () -> Assertions.assertTrue(salesPage.isSuccessMessageDisplayed()),
                () -> Assertions.assertEquals(message, salesPage.getSuccessMessage())
        );
    }
}
