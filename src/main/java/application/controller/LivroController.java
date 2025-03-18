package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.record.LivroDTO;
import application.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public Iterable<LivroDTO> list() {
        return livroService.getAll();
    }

    @GetMapping("/{id}")
    public LivroDTO getOne(@PathVariable long id) {
        return livroService.getOne(id);
    }

    @PostMapping
    public LivroDTO insert(@RequestBody LivroDTO livro) {
        return livroService.insert(livro);
    }

    @PutMapping("/{id}")
    public LivroDTO update(@PathVariable long id, @RequestBody LivroDTO livro) {
        return livroService.update(id, livro);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        livroService.delete(id);
    }
}
