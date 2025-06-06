package br.com.eaugusto.dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.eaugusto.domain.Persistable;

/**
 * Abstract implementation of a generic DAO using nested Maps for storage.
 *
 * @param <T> The type of entity.
 * 
 * @author Eduardo Augusto (https://github.com/AsrielDreemurrGM/)
 * @since June 02, 2025
 */
public abstract class GenericMapDAO<T extends Persistable> implements IGenericDAO<T> {

	// Outer map: associates each class with its corresponding map of entities
	protected Map<Class<T>, Map<String, T>> storage;

	public abstract Class<T> getClassType();

	public abstract void updateRegisteredEntityWithNewData(T newEntity, T registeredEntity);

	protected GenericMapDAO() {
		this.storage = new HashMap<>();
		storage.computeIfAbsent(getClassType(), entityClass -> new HashMap<>());
	}

	@Override
	public Boolean register(T entity) {
		Map<String, T> entityMap = storage.get(getClassType());
		if (entityMap.containsKey(entity.getCodeOrCPF())) {
			return false;
		}
		entityMap.put(entity.getCodeOrCPF(), entity);
		return true;
	}

	@Override
	public void delete(String identifier) {
		Map<String, T> entityMap = storage.get(getClassType());
		T registeredEntity = entityMap.get(identifier);

		if (registeredEntity != null) {
			entityMap.remove(identifier);
		}
	}

	@Override
	public void updateEntity(T entity) {
		Map<String, T> entityMap = storage.get(getClassType());
		T registeredEntity = entityMap.get(entity.getCodeOrCPF());

		if (registeredEntity != null) {
			updateRegisteredEntityWithNewData(entity, registeredEntity);
		}
	}

	@Override
	public T search(String identifier) {
		Map<String, T> entityMap = storage.get(getClassType());
		return entityMap.get(identifier);
	}

	@Override
	public Collection<T> searchAll() {
		Map<String, T> entityMap = storage.get(getClassType());
		return entityMap.values();
	}
}
