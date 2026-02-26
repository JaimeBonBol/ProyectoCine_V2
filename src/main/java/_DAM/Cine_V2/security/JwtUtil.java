package _DAM.Cine_V2.security;

import _DAM.Cine_V2.modelo.Rol;
import _DAM.Cine_V2.modelo.Usuario;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value; // Import de Spring, NO de Lombok
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expirationTime;

    private SecretKey key;

    @PostConstruct
    public void init() {
        // La clave debe tener al menos 32 caracteres (256 bits)
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(Usuario usuario) {
        // Extraer los nombres de los roles del Set<Rol> como lista de Strings
        List<String> roles = usuario.getRoles().stream()
                .map(Rol::getNombre)
                .collect(Collectors.toList());

        return Jwts.builder()
                .subject(usuario.getEmail())
                .claim("roles", roles) // Lista de nombres de roles, ej: ["USER", "ADMIN"]
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key) // En 0.12.x no se pone el algoritmo, se detecta por la key
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            // Nueva sintaxis de validación
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload() // .getBody() es antiguo, ahora es .getPayload()
                .getSubject();
    }
}