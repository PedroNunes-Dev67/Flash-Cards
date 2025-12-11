package FlashBrain_Backend.config;

import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.model.enums.RoleUsuario;
import FlashBrain_Backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@Configuration
@Profile("test")
public class UsuarioConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        String senha = new BCryptPasswordEncoder().encode("1234");

        Usuario usuario1 = new Usuario("Pedro Nunes","pedro@gmail.com",senha);
        Usuario usuario2 = new Usuario("Raul Vinicius","raul@gmail.com",senha);
        Usuario usuario3 = new Usuario("Jorge Henrique","henrique@gmail.com",senha);
        Usuario usuario4 = new Usuario("Thiago Carvalho","thiago@gmail.com",senha);
        Usuario usuario5 = new Usuario("Mycael Macêdo","mycael@gmail.com",senha);
        Usuario usuario6 = new Usuario("Joas Miguel","joas@gmail.com",senha);
        Usuario usuario7 = new Usuario("Gabriel Macêdo","gabriel@gmail.com",senha);

        usuario1.setRole(RoleUsuario.ADMIN);
        usuario2.setRole(RoleUsuario.ADMIN);
        usuario3.setRole(RoleUsuario.ADMIN);
        usuario4.setRole(RoleUsuario.ADMIN);
        usuario5.setRole(RoleUsuario.ADMIN);
        usuario6.setRole(RoleUsuario.ADMIN);
        usuario7.setRole(RoleUsuario.ADMIN);

        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3,usuario4,usuario5,usuario6,usuario7));

    }
}

