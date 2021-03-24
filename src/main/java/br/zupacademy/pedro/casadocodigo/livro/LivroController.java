package br.zupacademy.pedro.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    @Transactional
    public ResponseEntity<List<LivroExibirRequestDTO>> findAll(){
        List<Livro> list = livroRepository.findAll();
        return ResponseEntity.ok().body(list.stream()
                .map(livro->new LivroExibirRequestDTO(livro)).collect(Collectors.toList()));
    }


}
