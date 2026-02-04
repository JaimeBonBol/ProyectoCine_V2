package _DAM.Cine_V2.repositorio;

import _DAM.Cine_V2.modelo.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
