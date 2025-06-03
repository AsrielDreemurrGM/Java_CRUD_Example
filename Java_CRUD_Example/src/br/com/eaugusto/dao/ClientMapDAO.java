package br.com.eaugusto.dao;

import br.com.eaugusto.dao.generic.GenericDAO;
import br.com.eaugusto.domain.Client;

public class ClientMapDAO extends GenericDAO<Client> implements IClientDAO {

//	private Map<String, Client> map;
//
//	public ClientMapDAO() {
//		this.map = new HashMap<>();
//	}
//
//	@Override
//	public Boolean register(Client client) {
//		if (this.map.containsKey(client.getCpf())) {
//			return false;
//		}
//		this.map.put(client.getCpf(), client);
//		return true;
//	}
//
//	@Override
//	public Client delete(String cpf) {
//		return this.map.remove(cpf);
//	}
//
//	@Override
//	public void modify(Client client) {
//		Client registeredClient = this.map.get(client.getCpf());
//
//		if (registeredClient != null) {
//			registeredClient.setName(client.getName());
//			registeredClient.setPhoneNumber(client.getPhoneNumber());
//			registeredClient.setAddressNumber(client.getAddressNumber());
//			registeredClient.setAddress(client.getAddress());
//			registeredClient.setCity(client.getCity());
//			registeredClient.setState(client.getState());
//		}
//	}
//
//	@Override
//	public Client search(String cpf) {
//		return this.map.get(cpf);
//	}
//
//	@Override
//	public Collection<Client> searchAll() {
//		return this.map.values();
//	}
}
