package br.zupacademy.pedro.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Estadorepository extends JpaRepository<Estado,Long> {
    Optional<Estado> findByidAndPaisId(Long id, Long pais);
    List<Estado> findByPaisId(Long idPais);
}
