package br.com.eaugusto.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.eaugusto.domain.Client;

public class ClientSetDAO implements IClientDAO {

	private Set<Client> set;
	
	public ClientSetDAO() {
		this.set = new HashSet<>();
	}
	
	@Override
	public Boolean register(Client client) {
		return set.add(client);
	}

	@Override
	public void delete(String cpf) {
		Client toRemove = search(cpf);
		if (toRemove != null) {
			set.remove(toRemove);
		}
	}

	@Override
	public void modify(Client client) {
		Client existingClient = search(client.getCpf());
		
		if (existingClient != null) {
			existingClient.setName(client.getName());
			existingClient.setPhoneNumber(client.getPhoneNumber());
			existingClient.setAddress(client.getAddress());
			existingClient.setAddressNumber(client.getAddressNumber());
			existingClient.setCity(client.getCity());
			existingClient.setState(client.getState());
		}
	}

	@Override
	public Client search(String cpf) {
		for (Client client : set) {
			if (client.getCpf().equals(cpf));
			return client;
		}
		return null;
	}

	@Override
	public Collection<Client> searchAll() {
		return set;
	}

}
