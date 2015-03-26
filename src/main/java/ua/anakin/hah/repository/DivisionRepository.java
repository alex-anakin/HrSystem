package ua.anakin.hah.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.anakin.hah.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Long>{

	Division findByName(String name);

	
}
