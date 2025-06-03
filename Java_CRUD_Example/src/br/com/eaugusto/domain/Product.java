package br.com.eaugusto.domain;

public class Product implements Persistable {

	private Long code;
	private String name;
	
	public Long getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
