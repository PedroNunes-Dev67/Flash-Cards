package FlashBrain_Backend.controller;

import FlashBrain_Backend.dto.UsuarioResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import FlashBrain_Backend.dto.UsuarioDto;
import FlashBrain_Backend.service.UsuarioService;
import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/novoUsuario")
    public ResponseEntity<UsuarioResponseDto> cadastro(@RequestBody @Valid UsuarioDto usuarioDto){


        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastro(usuarioDto));
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody @Valid UsuarioDto usuarioDto){

        usuarioService.login(usuarioDto);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/updateUsuario/{id}")
    public ResponseEntity<Void> updateUsuario(@PathVariable(name = "id") Long id, @RequestBody @Valid UsuarioDto usuarioDto){

        usuarioService.updateUsuario(id, usuarioDto);
        return ResponseEntity.ok().build();
    }
}
