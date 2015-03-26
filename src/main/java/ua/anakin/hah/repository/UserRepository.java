package ua.anakin.hah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.anakin.hah.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByName(String name);
	
	

}
