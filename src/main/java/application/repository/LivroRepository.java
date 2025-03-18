package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
