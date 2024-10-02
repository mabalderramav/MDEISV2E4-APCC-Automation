package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.api.steps.clients;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.randomString.RandomWords;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientResponseEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.services.ClientService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class ClientSteps {
    private final ClientService clientService;
    private ClientResponseEntity clientResponseEntity;

    public ClientSteps() {
        this.clientService = new ClientService();
        this.clientResponseEntity = new ClientResponseEntity();
    }

    @When("I send a request to POST client endpoint 'clients' with the following data")
    public void iSendARequestToPOSTClientEndpointWithTheFollowingData(final Map<String, String> data) {
        var clientEntity = new ClientEntity();
        clientEntity.setCode(data.get("code").replace("{code}", "auto_".concat(RandomWords.generateWordWithUuid())));
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
}
