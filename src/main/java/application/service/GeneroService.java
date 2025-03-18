package application.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import application.model.Genero;
import application.record.GeneroDTO;
import application.repository.GeneroRepository;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepo;
    
    public Iterable<GeneroDTO> getAll() {
        return generoRepo.findAll().stream().map(GeneroDTO::new).toList();
    }
    
    public GeneroDTO getOne(long id) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        return new GeneroDTO(resultado.get());
    }
    
    public GeneroDTO insert(GeneroDTO genero) {
        Genero newGenero = new Genero(genero);
        Genero savedGenero = generoRepo.save(newGenero);
        GeneroDTO response = new GeneroDTO(savedGenero);
        return response;
    }
    
    public GeneroDTO update(long id, GeneroDTO genero) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        resultado.get().setDescricao(genero.descricao());
        return new GeneroDTO(generoRepo.save(resultado.get()));
    }
    
    public void delete(long id) {
        if(!generoRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Gênero Não Encontrado"
            );
        }
        generoRepo.deleteById(id);
    }
}