package org.lucas.algamoneyapi.config.JwtUtil;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.lucas.algamoneyapi.dto.RefreshTokenDto;
import org.lucas.algamoneyapi.dto.TokenResponseDTO;
import org.lucas.algamoneyapi.model.Usuario;
import org.lucas.algamoneyapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static io.jsonwebtoken.Jwts.builder;

@Component
public class JwtUtil {

    @Autowired
    UsuarioRepository usuarioRepository;

    private static final String SECRET = "63640264849a87c90356129d99ea165e37aa5fabc1fea46906df1a7ca50db492";
    public static final long EXPIRE_DAYS = 0;
    public static final long EXPIRE_HOURS = 0;
    public static final long EXPIRE_MINUTES = 1;
    public static final long EXPIRERATION_REFRESH_TOKEN_DAYS = 7;


    private static final Key KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String gerarToken(UserDetails userDetails, Date expiration) {
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .toList();

        Date limit = EXPIRATION_TOKEN(expiration);

        return builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", roles)
                .setExpiration(limit)
                .signWith(KEY)
                .compact();
    }


    public static String extrairEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Date EXPIRATION_TOKEN(Date start){
        LocalDateTime dateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = dateTime.plusDays(EXPIRE_DAYS).plusHours(EXPIRE_HOURS).plusMinutes(EXPIRE_MINUTES);
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date EXPIRATION_REFRESH_TOKEN(Date start){
        LocalDateTime dateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = dateTime.plusDays(EXPIRERATION_REFRESH_TOKEN_DAYS);
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    public RefreshTokenDto obterRefreshToken(RefreshTokenDto refreshToken) {

        String email = JwtUtil.extrairEmail(refreshToken.getNovoAcessToken());
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Pessoa não encontra ao tentar obter refresh token"));
        var authToken = new UsernamePasswordAuthenticationToken(
                usuario, null, usuario.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        List<String> roles = usuario.getAuthorities()
                .stream()
                .map(grantedAuthority -> grantedAuthority.getAuthority())
                .toList();

        Date expiration = EXPIRATION_REFRESH_TOKEN(new Date());

        String novoAcessToken = Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("roles", roles)
                .setExpiration(expiration)
                .signWith(KEY)
                .compact();

        return new RefreshTokenDto(novoAcessToken);
    }
}
