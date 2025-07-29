package org.lucas.algamoneyapi.auth;

import org.lucas.algamoneyapi.config.JwtUtil.JwtUtil;
import org.lucas.algamoneyapi.dto.LoginDTO;
import org.lucas.algamoneyapi.dto.LoginResponseDTO;
import org.lucas.algamoneyapi.dto.RegisterDTO;
import org.lucas.algamoneyapi.model.Usuario;
import org.lucas.algamoneyapi.model.enums.Roles;
import org.lucas.algamoneyapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> login (@RequestBody LoginDTO login) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
                );

                String token = jwtUtil.gerarToken(login.getUsername());
                return ResponseEntity.ok(new LoginResponseDTO(token));
            } catch (AuthenticationCredentialsNotFoundException e){
                return ResponseEntity.status(401).body("Usuário ou senha inválido.");
            }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO) {
        if (usuarioRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            return ResponseEntity.status(400).body("Usuário já existe.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(registerDTO.getUsername());
        novoUsuario.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        novoUsuario.setRoles(Roles.USUARIO); // ou Roles.ADMIN se quiser

        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso.");
    }


}
