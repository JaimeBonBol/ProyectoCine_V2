package _DAM.Cine_V2.repositorio;

import _DAM.Cine_V2.modelo.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findByNombre(String nombre);
}
