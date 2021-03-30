package br.zupacademy.pedro.casadocodigo.livro;

import br.zupacademy.pedro.casadocodigo.livro.dtos.DetalhesLivroResponseDTO;
import br.zupacademy.pedro.casadocodigo.livro.dtos.ExibirListaLivrosResponseDTO;
import br.zupacademy.pedro.casadocodigo.livro.dtos.LivroRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {
    private LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<LivroRequestDTO> insertLivro(@RequestBody @Valid LivroRequestDTO livroRequestDTO){
        Livro livro=livroRequestDTO.transformToEntityLivro();
        livro=livroRepository.save(livro);
        return  ResponseEntity.ok().body(new LivroRequestDTO(livro));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<ExibirListaLivrosResponseDTO>> findAll(){
        List<Livro> list = livroRepository.findAll();
        return ResponseEntity.ok().body(list.stream()
                .map(livro->new ExibirListaLivrosResponseDTO(livro)).collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalhesLivroResponseDTO> findById(@PathVariable Long id){
        Optional<Livro> livroOtional = livroRepository.findById(id);
        Livro livro = livroOtional.orElseThrow(()->new EntityNotFoundException("Entidade não encontrado nos registros"));
        return ResponseEntity.ok().body(new DetalhesLivroResponseDTO(livro));
    }


}
