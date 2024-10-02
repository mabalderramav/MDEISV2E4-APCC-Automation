package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.api.steps.clients;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.randomString.RandomWords;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientResponseEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.services.ClientService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class ClientSteps {
    private final ClientService clientService;
    private ClientResponseEntity clientResponseEntity;
    private String codeExpected;

    public ClientSteps() {
        this.clientService = new ClientService();
        this.clientResponseEntity = new ClientResponseEntity();
        this.codeExpected = "";
    }

    @When("I send a request to POST client endpoint 'clients' with the following data")
    public void iSendARequestToPOSTClientEndpointWithTheFollowingData(final Map<String, String> data) {
        var clientEntity = new ClientEntity();
        codeExpected = data.get("code").replace("{code}", "auto_".concat(RandomWords.generateWordWithUuid()));
        clientEntity.setCode(codeExpected);
        clientEntity.setName(data.get("name"));
        clientEntity.setCiNit(data.get("ciNit"));
        clientEntity.setDocumentType(data.get("documentType"));
        clientEntity.setEmail(data.get("email"));

        // Send the request to the endpoint
        clientResponseEntity = clientService.createClient(clientEntity);
    }

    @Then("I should receive a response with status {int}")
    public void iShouldReceiveAResponseWithStatus(int statusCodeExpected) {
        var actualStatusCode = clientResponseEntity.getStatusCode();
        Assertions.assertEquals(statusCodeExpected, actualStatusCode);
    }

    @Then("I should receive a response with the following data")
    public void iShouldReceiveAResponseWithTheFollowingData(final Map<String, String> data) {
        var successExpected = data.get("success");
        var messageExpected = data.get("message");

        Assertions.assertAll(
                () -> Assertions.assertEquals(successExpected, clientResponseEntity.getSuccess()),
                () -> Assertions.assertEquals(messageExpected, clientResponseEntity.getMessage())
        );
    }

    @And("the response should contain the following data")
    public void theResponseShouldContainTheFollowingData(final Map<String, String> data) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(codeExpected, clientResponseEntity.getClientEntity().getCode()),
                () -> Assertions.assertEquals(data.get("name"), clientResponseEntity.getClientEntity().getName()),
                () -> Assertions.assertEquals(data.get("ciNit"), clientResponseEntity.getClientEntity().getCiNit()),
                () -> Assertions.assertEquals(data.get("documentType"), clientResponseEntity.getClientEntity().getDocumentType()),
                () -> Assertions.assertEquals(data.get("email"), clientResponseEntity.getClientEntity().getEmail())
        );
    }
}
