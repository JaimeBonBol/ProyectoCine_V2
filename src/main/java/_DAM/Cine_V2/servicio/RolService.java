package _DAM.Cine_V2.servicio;

import _DAM.Cine_V2.dto.request.RolRequestDTO;
import _DAM.Cine_V2.dto.response.RolResponseDTO;
import _DAM.Cine_V2.mapper.RolMapper;
import _DAM.Cine_V2.modelo.Rol;
import _DAM.Cine_V2.repositorio.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public List<RolResponseDTO> findAll() {
        return rolRepository.findAll().stream()
                .map(rolMapper::toResponse)
                .collect(Collectors.toList());
    }

    public RolResponseDTO findById(Long id) {
        return rolRepository.findById(id)
                .map(rolMapper::toResponse)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
    }

    public RolResponseDTO save(RolRequestDTO dto) {
        Rol rol = rolMapper.toEntity(dto);
        Rol saved = rolRepository.save(rol);
        return rolMapper.toResponse(saved);
    }

    public RolResponseDTO update(Long id, RolRequestDTO dto) {
        Rol existing = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + id));
        existing.setNombre(dto.getNombre());
        Rol saved = rolRepository.save(existing);
        return rolMapper.toResponse(saved);
    }

    public void deleteById(Long id) {
        if (!rolRepository.existsById(id)) {
            throw new RuntimeException("Rol no encontrado con ID: " + id);
        }
        rolRepository.deleteById(id);
    }
}
