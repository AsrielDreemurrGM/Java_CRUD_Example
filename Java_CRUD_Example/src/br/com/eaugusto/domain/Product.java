package br.com.eaugusto.domain;

public class Product implements Persistable {

	private String code;
	private String name;
	
	public String getCode() {
		return code;
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
	public String getCodeOrCPF() {
		return this.code;
	}
}
