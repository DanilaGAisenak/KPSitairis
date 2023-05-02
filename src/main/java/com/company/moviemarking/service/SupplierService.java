package com.company.moviemarking.service;

import com.company.moviemarking.entity.Movie;

import java.util.List;

public interface SupplierService {
	Movie save(Movie movie);
	Movie findById(int id);
	List<Movie> findAllSuppliers();
	void removeSupplier(int id);

	List<Movie> listMovies(String title);
}
