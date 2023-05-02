package com.company.moviemarking.service;

import com.company.moviemarking.entity.Critics;

import java.util.List;

public interface CustomerService {
	Critics save(Critics critics);
	Critics findById(int id);
	List<Critics> findAllCustomers();
	void removeCustomer(int id);
}
