package br.zupacademy.pedro.casadocodigo.livro;

import br.zupacademy.pedro.casadocodigo.autor.AutorRepository;
import br.zupacademy.pedro.casadocodigo.categoria.Categoria;
import br.zupacademy.pedro.casadocodigo.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

//    @Autowired
//    private AutorRepository autorRepository;
//
//    @Autowired
//    private CategoriaRepository categoriaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroRequestDTO> insertLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO){
        Livro livro=livroRequestDTO.transformToEntityLivro(livroRequestDTO, entityManager);
        livro=livroRepository.save(livro);
        return  ResponseEntity.ok().body(new LivroRequestDTO(livro));
    }


}
