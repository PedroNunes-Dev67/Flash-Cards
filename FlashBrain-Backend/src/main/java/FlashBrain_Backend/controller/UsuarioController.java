package FlashBrain_Backend.controller;

import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable String email){

        Usuario usuario = usuarioService.findByEmail(email);

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/novoUsuario")
    public ResponseEntity<Usuario> cadastro(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = usuarioService.cadastro(usuarioDto);
        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
        }
    }

    @PatchMapping("/updateUsuario/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable(name = "id") Long id, @RequestBody UsuarioDto usuarioDto){

        Usuario usuario = usuarioService.updateUsuario(id,usuarioDto);

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.ok(usuario);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listaUsuario(){
        List<Usuario> list = usuarioService.listaUsuario();

        if (list.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.ok(list);
        }
    }
}
