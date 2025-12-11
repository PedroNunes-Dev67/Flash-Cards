package FlashBrain_Backend.controller;

import FlashBrain_Backend.dto.LoginDTO;
import FlashBrain_Backend.dto.TokenDTOResponse;
import FlashBrain_Backend.dto.UsuarioDTOResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import FlashBrain_Backend.dto.UsuarioDtoRequest;
import FlashBrain_Backend.service.UsuarioService;
import jakarta.validation.Valid;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTOResponse> cadastro(@RequestBody @Valid UsuarioDtoRequest usuarioDtoRequest){

        UsuarioDTOResponse usuario = usuarioService.cadastro(usuarioDtoRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTOResponse> login(@RequestBody @Valid LoginDTO loginDTO){

        TokenDTOResponse token = usuarioService.login(loginDTO);

        return ResponseEntity.ok(token);
    }



}
