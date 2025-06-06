package br.com.eaugusto.dao;

import br.com.eaugusto.dao.generic.GenericMapDAO;
import br.com.eaugusto.domain.Product;

public class ProductMapDAO extends GenericMapDAO<Product> implements IProductDAO {

	public ProductMapDAO() {
		super();
	}

	@Override
	public Class<Product> getClassType() {
		return Product.class;
	}

	@Override
	public void updateRegisteredEntityWithNewData(Product newEntity, Product registeredEntity) {
		registeredEntity.setName(newEntity.getName());
		registeredEntity.setDescription(newEntity.getDescription());
		registeredEntity.setValue(newEntity.getValue());
		registeredEntity.setBrand(newEntity.getBrand());
	}
}
