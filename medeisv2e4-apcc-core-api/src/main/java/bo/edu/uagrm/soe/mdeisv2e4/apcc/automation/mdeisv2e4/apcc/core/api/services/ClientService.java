package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.services;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.entities.ClientResponseEntity;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.core.api.repositories.ClientRepository;

public class ClientService {
    private final ClientRepository clientRepository;

    /**
     * Constructor for {@link ClientService} utility class.
     */
    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    /**
     * Creates a new client.
     *
     * @param clientEntity client entity.
     * @return client response entity.
     */
    public ClientResponseEntity createClient(final ClientEntity clientEntity) {
        return clientRepository.createClient(clientEntity);
    }
}
