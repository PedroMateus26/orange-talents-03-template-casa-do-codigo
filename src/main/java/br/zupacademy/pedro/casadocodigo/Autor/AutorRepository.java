package br.zupacademy.pedro.casadocodigo.Autor;

import br.zupacademy.pedro.casadocodigo.Autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findByEmail(String email);
}
