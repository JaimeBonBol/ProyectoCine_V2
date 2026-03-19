package _DAM.Cine_V2.security;

import _DAM.Cine_V2.modelo.Usuario;
import _DAM.Cine_V2.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority; // <-- NUEVO IMPORT
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CineUserDetailsService implements UserDetailsService {

    private final UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // 1. Buscamos el usuario
        Usuario u = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));

        // 2. Mapeamos cada Rol a un SimpleGrantedAuthority
        List<SimpleGrantedAuthority> authorities = u.getRoles().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                .toList();

        // 3. Construimos el UserDetails con las authorities
        return User.builder()
                .username(u.getEmail())
                .password(u.getPassword())
                .authorities(authorities) // <-- AQUÍ USAMOS AUTHORITIES
                .build();
    }
}