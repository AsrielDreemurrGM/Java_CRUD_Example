package br.com.eaugusto.dao;

import java.util.Collection;

import br.com.eaugusto.domain.Product;

public interface IProductDAO {

	public Boolean register(Product product);

	public Product delete(String code);

	public void modify(Product product);

	public Product search(String code);

	public Collection<Product> searchAll();
}
