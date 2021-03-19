package br.zupacademy.pedro.casadocodigo.repositories;

import br.zupacademy.pedro.casadocodigo.entities.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
