package br.zupacademy.pedro.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<CategoriaRequestDTO> insertCategoria(@RequestBody @Valid CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria(categoriaRequestDTO.getNomeCategoria());
        categoria = categoriaRepository.save(categoria);
        categoriaRequestDTO=new CategoriaRequestDTO(categoria);
        return ResponseEntity.ok().body(categoriaRequestDTO);

    }
}
