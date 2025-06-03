package br.com.eaugusto.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.eaugusto.dao.generic.GenericDAO;
import br.com.eaugusto.domain.Client;

public class ClientMapDAO extends GenericDAO<Client> implements IClientDAO {

	public ClientMapDAO() {
		super();
		Map<String, Client> innerMap = this.map.get(getClassType());
		if (innerMap == null) {
			innerMap = new HashMap<>();
			this.map.put(getClassType(), innerMap);
		}
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
