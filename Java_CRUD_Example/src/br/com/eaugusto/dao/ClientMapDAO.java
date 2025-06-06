package br.com.eaugusto.dao;

import br.com.eaugusto.dao.generic.GenericMapDAO;
import br.com.eaugusto.domain.Client;

public class ClientMapDAO extends GenericMapDAO<Client> implements IClientDAO {

	public ClientMapDAO() {
		super();
	}
	
	@Override
	public Class<Client> getClassType() {
		return Client.class;
	}

	@Override
	public void updateRegisteredEntityWithNewData(Client newClientInformation, Client registeredClient) {
		registeredClient.updateWith(newClientInformation);
	}
}
