package br.zupacademy.pedro.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Categoria findByNomeCategoria(String nomeCategoria);

}
