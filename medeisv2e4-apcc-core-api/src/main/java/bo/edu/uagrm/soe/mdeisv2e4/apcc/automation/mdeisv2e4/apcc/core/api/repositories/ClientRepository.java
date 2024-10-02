package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.repositories;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.api.client.ApiRequest;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.api.client.RequestManager;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.api.environment.EnvironmentManager;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientResponseEntity;

import java.util.HashMap;

import static bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.utils.json.JsonParser.fromJsonString;

/**
 * This class is a repository for the entity Client.
 */
public class ClientRepository {
    private static final String MDEISV2E4_APCC = "MDEISV2E4-APCC";
    public static final String CLIENTS = "clientes";
    private final EnvironmentManager environmentManager;

    /**
     * Constructor for {@link ClientRepository} utility class.
     */
    public ClientRepository() {
        this.environmentManager = EnvironmentManager.getInstance();
    }

    /**
     * Creates a new client.
     *
     * @param clientEntity client entity.
     * @return client response entity.
     */
    public ClientResponseEntity createClient(final ClientEntity clientEntity) {
        var endpoint = environmentManager.getUrl(MDEISV2E4_APCC).concat(CLIENTS);
        var apiRequest = new ApiRequest();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        var bodyRequest = """
                {
                    "code": "%s",
                    "name": "%s",
                    "ciNit": "%s",
                    "documentType": "%s",
                    "email": "%s"
                }
                """.formatted(clientEntity.getCode(), clientEntity.getName(), clientEntity.getCiNit(),
                clientEntity.getDocumentType(), clientEntity.getEmail());
        apiRequest.setHeaders(headers);
        apiRequest.setBody(bodyRequest);
        var response = RequestManager.post(apiRequest, endpoint);
        var clientResponseEntity = fromJsonString(response.getBody(), ClientResponseEntity.class);
        clientResponseEntity.setStatusCode(response.getStatusCode());
        return clientResponseEntity;
    }
}
