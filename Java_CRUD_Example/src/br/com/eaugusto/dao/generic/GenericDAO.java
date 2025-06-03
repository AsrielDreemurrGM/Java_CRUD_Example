package br.com.eaugusto.dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.eaugusto.domain.Persistable;

public abstract class GenericDAO<T extends Persistable> implements IGenericDAO<T> {

	protected Map<Class<T>, Map<String, T>> map;
	
	public abstract Class<T> getClassType();
	
	public abstract void modify(T entity, T registeredEntity);
	
	protected GenericDAO() {
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
	public void modify(T entity) {
		Map<String, T> innerMap = this.map.get(getClassType());
		
		T registeredEntity = innerMap.get(entity.getCodeOrCPF());
		
		if (registeredEntity != null) {
			modify(entity, registeredEntity);
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
