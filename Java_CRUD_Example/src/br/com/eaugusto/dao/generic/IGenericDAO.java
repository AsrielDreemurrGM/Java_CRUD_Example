package br.com.eaugusto.dao.generic;

import java.util.Collection;

import br.com.eaugusto.domain.Persistable;
import br.com.eaugusto.domain.Product;

public interface IGenericDAO <T extends Persistable> {

	public Boolean register(T entity);

	public T delete(String value);

	public void modify(T entity);

	public T search(String value);

	public Collection<T> searchAll();
}
