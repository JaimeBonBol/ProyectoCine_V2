package _DAM.Cine_V2.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentaRequestDTO {

        @NotNull(message = "El usuario es obligatorio")
        private Long usuarioId;

        @NotEmpty(message = "Debe incluir al menos una entrada")
        private List<EntradaRequestDTO> entradas;
}
