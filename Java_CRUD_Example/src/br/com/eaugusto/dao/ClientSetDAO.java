package br.com.eaugusto.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.eaugusto.dao.generic.GenericMapDAO;
import br.com.eaugusto.domain.Client;

public class ClientSetDAO extends GenericMapDAO<Client> implements IClientDAO {

    private Set<Client> clientSet;

    public ClientSetDAO() {
        super();
        this.clientSet = new HashSet<>();
    }

    @Override
    public Class<Client> getClassType() {
        return Client.class;
    }

    @Override
    public Boolean register(Client entity) {
        // Using Set semantics: returns false if already present
        return clientSet.add(entity);
    }

    @Override
    public void delete(String cpf) {
        clientSet.removeIf(client -> client.getCodeOrCPF().equals(cpf));
    }

    @Override
    public void updateEntity(Client entity) {
        Client registeredEntity = search(entity.getCodeOrCPF());
        if (registeredEntity != null) {
            updateRegisteredEntityWithNewData(entity, registeredEntity);
        }
    }

    @Override
    public Client search(String cpf) {
        return clientSet.stream()
            .filter(client -> client.getCodeOrCPF().equals(cpf))
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<Client> searchAll() {
        return clientSet;
    }

    @Override
    public void updateRegisteredEntityWithNewData(Client entity, Client registeredEntity) {
        registeredEntity.updateWith(entity);
    }
}
