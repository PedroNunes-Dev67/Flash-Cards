package FlashBrain_Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    public List<Usuario> listaUsuario(){
        return usuarioRepository.findAll();
    }

    public Usuario cadastro(UsuarioDto usuarioDto){

        Usuario usuario = findByEmail(usuarioDto.getEmail());

        if (usuario != null){
            return null;
        }
        else {
            return usuario = usuarioRepository.save(new Usuario(usuarioDto.getNome(), usuarioDto.getEmail(), usuarioDto.getSenha()));
        }
    }

    public Usuario updateUsuario(Long id, UsuarioDto usuarioDto){

        Usuario usuario = usuarioRepository.findById(id).orElse(null);

        if (usuario == null){
            return null;
        }else {
            if (usuario.getSenha().equals(usuarioDto.getSenha())){
                return null;
            }
            usuario.setSenha(usuarioDto.getSenha());
            return usuarioRepository.save(usuario);
        }
    }
}
