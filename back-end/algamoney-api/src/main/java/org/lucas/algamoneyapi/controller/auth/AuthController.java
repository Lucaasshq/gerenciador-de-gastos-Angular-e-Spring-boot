package org.lucas.algamoneyapi.controller.auth;

import org.lucas.algamoneyapi.config.JwtUtil.JwtUtil;
import org.lucas.algamoneyapi.dto.LoginDTO;
import org.lucas.algamoneyapi.dto.TokenResponseDTO;
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
import org.springframework.security.core.userdetails.UserDetails;
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
                        new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword())
                );

                UserDetails usuario = (UserDetails) authentication.getPrincipal();

                String token = jwtUtil.gerarToken(usuario);
                return ResponseEntity.ok(new TokenResponseDTO(token));
            } catch (AuthenticationCredentialsNotFoundException e){
                return ResponseEntity.status(401).body("email ou senha inválido.");
            }
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


}
