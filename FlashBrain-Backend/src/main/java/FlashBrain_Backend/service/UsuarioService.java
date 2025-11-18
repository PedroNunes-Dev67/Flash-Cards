package FlashBrain_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastro(UsuarioDto usuarioDto){

        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail()).orElse(null);

        if (usuario != null){
            return null;
        }
        else {
            return usuario = usuarioRepository.save(new Usuario(usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getSenha()));
        }
    }

    public Usuario updateUsuario(UsuarioDto usuarioDto){

        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail()).orElse(null);

        if (usuario == null) {
            return null;
        }
        else if (usuario.getSenha().equals(usuarioDto.getSenha())){
            return null;
        }
        else{
            usuario.setSenha(usuarioDto.getSenha());
            return usuarioRepository.save(usuario);
        }
    }

    public ResponseEntity<Void> login(UsuarioDto usuarioDto){

        Usuario usuario = usuarioRepository.findByEmail(usuarioDto.getEmail()).orElse(null);

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else if (!usuario.getSenha().equals(usuarioDto.getSenha())){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        else{
            return ResponseEntity.ok().build();
        }

    }
}
