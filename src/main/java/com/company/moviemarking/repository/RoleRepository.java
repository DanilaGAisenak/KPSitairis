package com.company.moviemarking.repository;

import com.company.moviemarking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
}
