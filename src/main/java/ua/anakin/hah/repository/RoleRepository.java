package ua.anakin.hah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.anakin.hah.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);
	
	

}
