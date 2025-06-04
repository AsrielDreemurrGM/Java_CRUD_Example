package br.com.eaugusto.domain;

public class Product implements Persistable {

	private String code;
	private String name;
	private String description;
	private double value;
	private String brand;
	
	public Product(String name, String code, String description, double value, String brand) {
		this.name = name;
		this.code = code;
		this.description = description;
		this.value = value;
		this.brand = brand;
	}
	
	public String getDescription() {
		return description;
	}

	public double getValue() {
		return value;
	}

	public String getBrand() {
		return brand;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
	    return "Informações do Produto:\n"
	        + "Nome: " + name + "\n"
	        + "Código: " + code + "\n"
	        + "Descrição: " + description + "\n"
	        + "Valor: R$ " + String.format("%.2f", value) + "\n"
	        + "Marca: " + brand;
	}

	@Override
	public String getCodeOrCPF() {
		return this.code;
	}
}
