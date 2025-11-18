package FlashBrain_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.model.Usuario;
import FlashBrain_Backend.service.UsuarioService;
import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/novoUsuario")
    public ResponseEntity<Void> cadastro(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = usuarioService.cadastro(usuarioDto);
        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid UsuarioDto usuarioDto){

        return usuarioService.login(usuarioDto);
    }
    

    @PatchMapping("/updateUsuario")
    public ResponseEntity<Void> updateUsuario(@RequestBody @Valid UsuarioDto usuarioDto){

        Usuario usuario = usuarioService.updateUsuario(usuarioDto);

        if (usuario == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else{
            return ResponseEntity.ok().build();
        }
    }
}
