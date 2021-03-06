package com.leftso.entity;

/**
 * 测试用类
 * 
 * @author leftso
 *
 */
// @Document
public class Customer {

	private String id;
	private String firstName;
	private String lastName;

	public Customer() {

	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
