package FlashBrain_Backend.config;

import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class UsuarioConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 = new Usuario("Pedro Nunes","pedro@gmail.com","1234");
        Usuario usuario2 = new Usuario("Raul Vinicius","raul@gmail.com","1234");
        Usuario usuario3 = new Usuario("Jorge Henrique","henrique@gmail.com","1234");
        Usuario usuario4 = new Usuario("Thiago Carvalho","thiago@gmail.com","1234");
        Usuario usuario5 = new Usuario("Mycael Macêdo","mycael@gmail.com","1234");
        Usuario usuario6 = new Usuario("Joas Miguel","joas@gmail.com","1234");
        Usuario usuario7 = new Usuario("Gabriel Macêdo","gabriel@gmail.com","1234");

        usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3,usuario4,usuario5,usuario6,usuario7));

    }
}

