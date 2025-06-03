package br.com.eaugusto.dao.generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.eaugusto.domain.Persistable;
import br.com.eaugusto.domain.Product;

public abstract class GenericDAO<T extends Persistable> implements IGenericDAO<T> {

	private Map<Class, Map<Long, T>> map;
	
	public GenericDAO() {
		this.map = new HashMap<>();
	}

	@Override
	public Boolean register(T entity) {
		return null;
	}

	@Override
	public T delete(String value) {
		return null;
	}

	@Override
	public void modify(T entity) {
		
	}

	@Override
	public T search(String value) {
		return null;
	}

	@Override
	public Collection<T> searchAll() {
		return null;
	}
}
