package br.com.eaugusto.dao;

import java.util.Collection;

import br.com.eaugusto.domain.Client;

public interface IClientDAO {

	public Boolean register(Client client);

	public Client delete(String cpf);

	public void modify(Client client);

	public Client search(String cpf);

	public Collection<Client> searchAll();

}
