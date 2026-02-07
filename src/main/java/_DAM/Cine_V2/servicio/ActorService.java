package _DAM.Cine_V2.servicio;

import _DAM.Cine_V2.dto.request.ActorRequestDTO;
import _DAM.Cine_V2.dto.response.ActorResponseDTO;
import _DAM.Cine_V2.mapper.ActorMapper;
import _DAM.Cine_V2.modelo.Actor;
import _DAM.Cine_V2.repositorio.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;

    public List<ActorResponseDTO> findAll() {
        return actorRepository.findAll().stream()
                .map(actorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ActorResponseDTO findById(Long id) {
        return actorRepository.findById(id)
                .map(actorMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado con ID: " + id));
    }

    public ActorResponseDTO save(ActorRequestDTO dto) {
        Actor actor = actorMapper.toEntity(dto);
        Actor saved = actorRepository.save(actor);
        return actorMapper.toResponse(saved);
    }

    public ActorResponseDTO update(Long id, ActorRequestDTO dto) {
        Actor existing = actorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actor no encontrado con ID: " + id));
        existing.setNombre(dto.getNombre());
        Actor saved = actorRepository.save(existing);
        return actorMapper.toResponse(saved);
    }

    public void deleteById(Long id) {
        if (!actorRepository.existsById(id)) {
            throw new RuntimeException("Actor no encontrado con ID: " + id);
        }
        actorRepository.deleteById(id);
    }
}
