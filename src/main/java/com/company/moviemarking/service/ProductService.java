package com.company.moviemarking.service;

import com.company.moviemarking.entity.Critics;
import com.company.moviemarking.entity.Mark;
import com.company.moviemarking.dto.ProductDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
	Mark save(ProductDTO productDTO);

	Mark findById(int id);

	List<Mark> findAllProducts();

	void sellProduct(int productId, int quantity);

	void removeProduct(int productId);
}
