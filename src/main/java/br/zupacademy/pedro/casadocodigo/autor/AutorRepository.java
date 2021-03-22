package br.zupacademy.pedro.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findByEmail(String email);
}
