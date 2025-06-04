package br.com.eaugusto.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.eaugusto.dao.generic.GenericMapDAO;
import br.com.eaugusto.domain.Product;

public class ProductMapDAO extends GenericMapDAO<Product> implements IProductDAO {

	public ProductMapDAO() {
		super();
		Map<String, Product> innerMap = this.map.get(getClassType());
		
		if (innerMap == null) {
			innerMap = new HashMap<>();
			this.map.put(getClassType(), innerMap);
		}
	}
	
	@Override
	public void updateEntity(Product product) {
		Product existingProduct = this.map.get(getClassType()).get(product.getCodeOrCPF());
	
		if (existingProduct != null) {
			updateRegisteredEntityWithNewData(product, existingProduct);
		} else {
			System.out.println("Produto não encontrado para atualização: " + product.getCodeOrCPF());
		}
	}

	@Override
	public Class<Product> getClassType() {
		return Product.class;
	}

	@Override
	public void updateRegisteredEntityWithNewData(Product newEntity, Product registeredEntity) {
		registeredEntity.setName(newEntity.getName());
	}
}
