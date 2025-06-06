package br.com.eaugusto.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import br.com.eaugusto.dao.generic.GenericSetDAO;
import br.com.eaugusto.domain.Client;

/**
 * DAO Implementation For Managing Client Entities Using GenericSetDAO.
 * 
 * <p>This class uses a generic Set-based storage for {@link Client} entities,
 * handling the underlying storage map for entity sets.</p>
 * 
 * It implements basic CRUD operations and updates client data accordingly.
 *
 * @author Eduardo Augusto (https://github.com/AsrielDreemurrGM/)
 * @since May 21, 2025
 */
public class ClientSetDAO extends GenericSetDAO<Client> implements IClientDAO {

	public ClientSetDAO() {
		super();
	}

	@Override
	public Class<Client> getClassType() {
		return Client.class;
	}

	@Override
	public Boolean register(Client entity) {
		Set<Client> entitySet = storage.get(getClassType());
		if (entitySet == null) {
			entitySet = new HashSet<>();
			storage.put(getClassType(), entitySet);
		}
		return entitySet.add(entity);
	}

	@Override
	public void delete(String cpf) {
		Set<Client> entitySet = storage.get(getClassType());
		if (entitySet != null) {
			entitySet.removeIf(client -> client.getCodeOrCPF().equals(cpf));
		}
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
		Set<Client> entitySet = storage.get(getClassType());
		if (entitySet != null) {
			return entitySet.stream()
					.filter(client -> client.getCodeOrCPF().equals(cpf))
					.findFirst()
					.orElse(null);
		}
		return null;
	}

	@Override
	public Collection<Client> searchAll() {
		Set<Client> entitySet = storage.get(getClassType());
		return entitySet != null ? entitySet : new HashSet<>();
	}

	@Override
	public void updateRegisteredEntityWithNewData(Client entity, Client registeredEntity) {
		registeredEntity.updateWith(entity);
	}
}
