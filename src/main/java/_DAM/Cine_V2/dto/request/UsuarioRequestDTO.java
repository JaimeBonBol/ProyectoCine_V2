package _DAM.Cine_V2.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

        @Email(message = "Email inválido")
        @NotBlank(message = "El email es obligatorio")
        private String email;

        @NotBlank(message = "La contraseña es obligatoria")
        private String password;

        private List<Long> rolIds;
}
