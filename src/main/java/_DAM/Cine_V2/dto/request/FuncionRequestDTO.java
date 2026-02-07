package _DAM.Cine_V2.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionRequestDTO {

        @NotNull(message = "La fecha y hora son obligatorias")
        private LocalDateTime fechaHora;

        private double precio;

        @NotNull(message = "La película es obligatoria")
        private Long peliculaId;

        @NotNull(message = "La sala es obligatoria")
        private Long salaId;
}
