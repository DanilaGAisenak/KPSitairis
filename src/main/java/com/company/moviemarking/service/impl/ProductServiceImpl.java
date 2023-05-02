package com.company.moviemarking.service.impl;

import com.company.moviemarking.dto.ProductDTO;
import com.company.moviemarking.entity.Critics;
import com.company.moviemarking.entity.Mark;
import com.company.moviemarking.repository.ProductRepository;
import com.company.moviemarking.service.ProductService;
import com.company.moviemarking.service.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	private ProductMapper productMapper;

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}

	@Override
	public Mark save(ProductDTO productDTO) {
		Mark mark = productMapper.toEntitySup(productDTO);
		return productRepository.save(mark);
	}

	@Override
	public Mark findById(int id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<Mark> findAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void sellProduct(int productId, int quantity) {
		Mark mark = findById(productId);
		System.out.println(mark.getRating());
		System.out.println(quantity);
		if (mark.getRating() == quantity) {
			productRepository.delete(mark);
		}
		if (mark.getRating() > quantity) {
			mark.setRating(mark.getRating() - quantity);
			productRepository.saveAndFlush(mark);
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void removeProduct(int productId) {
		Mark mark = findById(productId);
		productRepository.delete(mark);
	}

	public void update(Integer id, String script, Integer rating, Integer duration, String comment){
		Optional<Mark> mark = productRepository.findById(id);
		if (!(mark.get()==null)){
			mark.get().setScript(script);
			mark.get().setRating(rating);
			mark.get().setDuration(duration);
			mark.get().setComment(comment);
		}
		productRepository.save(mark.get());
	}
}
