package br.com.eaugusto.dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.eaugusto.domain.Persistable;


/**
 * Abstract implementation of a generic DAO using Sets for storage.
 *
 * @param <T> The type of entity.
 * 
 * @author Eduardo Augusto (https://github.com/AsrielDreemurrGM/)
 * @since June 02, 2025
 */
public abstract class GenericSetDAO<T extends Persistable> implements IGenericDAO<T> {

	protected Map<Class<T>, Set<T>> storage;

	public abstract Class<T> getClassType();

	public abstract void updateRegisteredEntityWithNewData(T newEntity, T registeredEntity);

	protected GenericSetDAO() {
		if (this.storage == null) {
			this.storage = new HashMap<>();
		}
	}

	@Override
	public Boolean register(T entity) {
		Set<T> entitySet = this.storage.get(getClassType());

		if (entitySet == null) {
			entitySet = new java.util.HashSet<>();
			this.storage.put(getClassType(), entitySet);
		}

		return entitySet.add(entity); // Set rejects duplicates based on equals/hashCode
	}

	@Override
	public void delete(String value) {
		Set<T> entitySet = this.storage.get(getClassType());

		if (entitySet == null) return;

		T toRemove = null;

		for (T entity : entitySet) {
			if (entity.getCodeOrCPF().equals(value)) {
				toRemove = entity;
				break;
			}
		}

		if (toRemove != null) {
			entitySet.remove(toRemove);
		}
	}

	@Override
	public void updateEntity(T entity) {
		Set<T> entitySet = this.storage.get(getClassType());

		if (entitySet == null) return;

		for (T registered : entitySet) {
			if (registered.getCodeOrCPF().equals(entity.getCodeOrCPF())) {
				updateRegisteredEntityWithNewData(entity, registered);
				break;
			}
		}
	}

	@Override
	public T search(String value) {
		Set<T> entitySet = this.storage.get(getClassType());

		if (entitySet == null) return null;

		for (T entity : entitySet) {
			if (entity.getCodeOrCPF().equals(value)) {
				return entity;
			}
		}

		return null;
	}

	@Override
	public Collection<T> searchAll() {
		Set<T> entitySet = this.storage.get(getClassType());

		return entitySet != null ? entitySet : java.util.Collections.emptySet();
	}
}
