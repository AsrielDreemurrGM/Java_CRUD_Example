package br.com.eaugusto.dao.generic;

import java.util.Collection;

import br.com.eaugusto.domain.Persistable;

public interface IGenericDAO <T extends Persistable> {

	public Boolean register(T entity);

	public void delete(String value);

	public void updateEntity(T entity);

	public T search(String value);

	public Collection<T> searchAll();
}
