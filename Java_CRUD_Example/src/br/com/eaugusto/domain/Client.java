package br.com.eaugusto.domain;

import java.util.Objects;

public class Client {
	
	private String name;
	private String cpf;
	private String phoneNumber;
	private String address;
	private Integer number;
	private String city;
	private String state;
	
	public Client(String name, String cpf, String phoneNumber, String address, String numberAsString, String city, String state) {
		this.name = name;
		this.cpf = cpf.trim();
		this.phoneNumber = phoneNumber.trim();
		this.address = address;
		this.number = Integer.valueOf(numberAsString.trim());
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public Integer getNumber() {
		return number;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	

}
