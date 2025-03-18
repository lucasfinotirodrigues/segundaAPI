package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import application.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    
}