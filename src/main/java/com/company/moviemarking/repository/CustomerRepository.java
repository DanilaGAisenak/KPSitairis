package com.company.moviemarking.repository;

import com.company.moviemarking.entity.Critics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Critics, String> {
	Optional<Critics> findById(int id);
}
