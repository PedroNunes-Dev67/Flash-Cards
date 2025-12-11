package FlashBrain_Backend.service;

import FlashBrain_Backend.dto.LoginDTO;
import FlashBrain_Backend.dto.TokenDTOResponse;
import FlashBrain_Backend.dto.UsuarioDTOResponse;
import FlashBrain_Backend.exceptions.ResourceUserException;
import FlashBrain_Backend.model.enums.RoleUsuario;
import FlashBrain_Backend.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import FlashBrain_Backend.dto.UsuarioDtoRequest;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UsuarioDTOResponse cadastro(UsuarioDtoRequest usuarioDtoRequest) {

        if (usuarioRepository.findByEmail(usuarioDtoRequest.getEmail()) != null) throw new ResourceUserException("Usuário já cadastrado");

        String senha = new BCryptPasswordEncoder().encode(usuarioDtoRequest.getSenha());

        Usuario usuario = new Usuario(usuarioDtoRequest.getNome(), usuarioDtoRequest.getEmail(), senha);

        usuario.setRole(RoleUsuario.USUARIO);
        usuarioRepository.save(usuario);

        return new UsuarioDTOResponse(usuario);

    }

    public TokenDTOResponse login(LoginDTO loginDTO){

        var username = new UsernamePasswordAuthenticationToken(loginDTO.email(),loginDTO.senha());

        var authentication = authenticationManager.authenticate(username);

        String token = tokenService.generateToken((Usuario) authentication.getPrincipal());

        return new TokenDTOResponse(token);
    }
}
