package FlashBrain_Backend.repository;

import FlashBrain_Backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findBySenha(String senha);
}
