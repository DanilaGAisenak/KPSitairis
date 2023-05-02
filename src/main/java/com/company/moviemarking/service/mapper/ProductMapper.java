package com.company.moviemarking.service.mapper;

import com.company.moviemarking.dto.ProductDTO;
import com.company.moviemarking.entity.Critics;
import com.company.moviemarking.entity.Mark;
import com.company.moviemarking.entity.Movie;
import com.company.moviemarking.service.SupplierService;
import com.company.moviemarking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
	private SupplierService supplierService;
	private CustomerService customerService;

	@Autowired
	public ProductMapper(SupplierService supplierService, CustomerService customerService) {
		this.supplierService = supplierService;
		this.customerService = customerService;
	}

	public ProductDTO toDto(Mark mark) {
		return ProductDTO.builder()
				.id(mark.getId())
				.script(mark.getScript())
				.comment(mark.getComment())
				.duration(mark.getDuration())
				.rating(mark.getRating())
				.build();
	}

	public Mark toEntitySup(ProductDTO productDTO) {
		Movie movie = supplierService.findById(Integer.valueOf(productDTO.getMovie()));
		Critics crititc = customerService.findById(Integer.valueOf(productDTO.getCritic()));
		return Mark.builder()
				.id(productDTO.getId())
				.script(productDTO.getScript())
				.duration(productDTO.getDuration())
				.comment(productDTO.getComment())
				.rating(productDTO.getRating())
				.movie(movie)
				.critics(crititc)
				.build();
	}
}
