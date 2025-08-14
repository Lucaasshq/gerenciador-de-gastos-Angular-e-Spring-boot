package org.lucas.algamoneyapi.controller.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.lucas.algamoneyapi.config.JwtUtil.JwtUtil;
import org.lucas.algamoneyapi.dto.LoginDTO;
import org.lucas.algamoneyapi.dto.RefreshTokenDto;
import org.lucas.algamoneyapi.dto.TokenResponseDTO;
import org.lucas.algamoneyapi.dto.RegisterDTO;
import org.lucas.algamoneyapi.exeception.EmailNaoEncontradoException;
import org.lucas.algamoneyapi.model.Usuario;
import org.lucas.algamoneyapi.model.enums.Roles;
import org.lucas.algamoneyapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDTO login, HttpServletResponse response) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
                );

                UserDetails usuario = (UserDetails) authentication.getPrincipal();
                Usuario username = usuarioRepository.findByEmail(login.getEmail()).orElseThrow( () -> new EmailNaoEncontradoException("Usuario de email "+ login.getEmail()+" não encontrado" ));
                String token = jwtUtil.gerarToken(usuario, jwtUtil.EXPIRATION_TOKEN(Date.from(Instant.now())), username.getUsername());
                String refresh_token = jwtUtil.gerarToken(usuario, jwtUtil.EXPIRATION_REFRESH_TOKEN(Date.from(Instant.now())), username.getUsername());

                int maxAge = (int) ((jwtUtil.EXPIRATION_REFRESH_TOKEN(Date.from(Instant.now())).getTime() - System.currentTimeMillis()) / 1000);
                Cookie refreshTokenCookie = new Cookie("refreshToken", refresh_token);
                refreshTokenCookie.setHttpOnly(true);
                refreshTokenCookie.setSecure(true);
                refreshTokenCookie.setPath("/");
                refreshTokenCookie.setMaxAge(maxAge);

                response.addCookie(refreshTokenCookie);
                return ResponseEntity.ok(new TokenResponseDTO(token,null));


            } catch (AuthenticationCredentialsNotFoundException e){
                return ResponseEntity.status(401).body("email ou senha inválido.");
            }
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshTokenDto refreshToken) {


        return ResponseEntity.ok(jwtUtil.obterRefreshToken(refreshToken));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        if (usuarioRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            return ResponseEntity.status(400).body("email já existe.");
        }

        if (registerDTO.getPassword().length() < 8){
            return ResponseEntity.status(400).body("Senha: deve conter no minimo 8 caracteres");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(registerDTO.getUsername());
        novoUsuario.setEmail(registerDTO.getEmail());
        novoUsuario.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        novoUsuario.setRoles(Roles.USUARIO); // ou Roles.ADMIN se quiser

        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletResponse response){
        Cookie cookie = new Cookie("refreshToken", null);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        return ResponseEntity.noContent().build();
    }


}
