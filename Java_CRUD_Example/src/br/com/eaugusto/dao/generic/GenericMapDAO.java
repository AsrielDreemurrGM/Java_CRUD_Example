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

	protected Map<Class<T>, Map<String, T>> map;

	public abstract Class<T> getClassType();

	public abstract void updateRegisteredEntityWithNewData(T newEntity, T registeredEntity);

	protected GenericMapDAO() {
		if (this.map == null) {
			this.map = new HashMap<>();
		}
	}

	@Override
	public Boolean register(T entity) {
		Map<String, T> innerMap = this.map.get(getClassType());
		if (innerMap.containsKey(entity.getCodeOrCPF())) {
			return false;
		}
		innerMap.put(entity.getCodeOrCPF(), entity);
		return true;
	}

	@Override
	public void delete(String value) {
		Map<String, T> innerMap = this.map.get(getClassType());

		T registeredEntity = innerMap.get(value);

		if (registeredEntity != null) {
			innerMap.remove(value);
		}
	}

	@Override
	public void updateEntity(T entity) {
		Map<String, T> innerMap = this.map.get(getClassType());

		T registeredEntity = innerMap.get(entity.getCodeOrCPF());

		if (registeredEntity != null) {
			updateRegisteredEntityWithNewData(entity, registeredEntity);
		}
	}

	@Override
	public T search(String value) {
		Map<String, T> innerMap = this.map.get(getClassType());

		return innerMap.get(value);
	}

	@Override
	public Collection<T> searchAll() {
		Map<String, T> innerMap = this.map.get(getClassType());

		return innerMap.values();
	}
}
