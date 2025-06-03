package br.com.eaugusto.dao;

import java.util.Collection;

import br.com.eaugusto.domain.Product;

public class ProductDAO implements IProductDAO {

	@Override
	public Boolean register(Product product) {
		return null;
	}

	@Override
	public Product delete(String code) {
		return null;
	}

	@Override
	public void modify(Product product) {
		
	}

	@Override
	public Product search(String code) {
		return null;
	}

	@Override
	public Collection<Product> searchAll() {
		return null;
	}
}
