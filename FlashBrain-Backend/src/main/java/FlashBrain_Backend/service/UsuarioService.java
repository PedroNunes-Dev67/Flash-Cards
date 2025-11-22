package FlashBrain_Backend.service;

import FlashBrain_Backend.dto.UsuarioResponseDto;
import FlashBrain_Backend.exceptions.ResourceUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDto cadastro(UsuarioDto usuarioDto){

        if (usuarioRepository.findByEmail(usuarioDto.getEmail()).isPresent()){
            throw new ResourceUserException("Erro! Usuario já cadastrado");
        }
        Usuario usuario = new Usuario(usuarioDto.getNome(),usuarioDto.getEmail(),usuarioDto.getSenha());
        usuarioRepository.save(usuario);
        return new UsuarioResponseDto(usuario);

    }

    public Usuario updateUsuario(Long id, UsuarioDto usuarioDto){

            Usuario user = usuarioRepository.findById(id)
                    .orElseThrow(() -> new ResourceUserException("Erro! Usuário não cadastrado!"));

            if (user.getSenha().equals(usuarioDto.getSenha())){
                throw new ResourceUserException("Erro! Senha não pode ser igual a anterior!");
            }
            user.setSenha(usuarioDto.getSenha());
            return usuarioRepository.save(user);
    }

    public Usuario login(UsuarioDto usuarioDto){

        return usuarioRepository.findByEmail(usuarioDto.getEmail())
                .filter(usuario -> usuario.getSenha().equals(usuarioDto.getSenha()))
                .orElseThrow(() -> new ResourceUserException("Erro! Email ou senha incorretos!"));
    }
}
