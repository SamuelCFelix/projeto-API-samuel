package myfirstapi.projetosamuel.controllers;

import myfirstapi.projetosamuel.model.Usuarios;
import myfirstapi.projetosamuel.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        Usuarios createdUsuario = usuarioService.createUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @GetMapping()
    public String welcome(){
        return "Eu estou surtando";
    }
}
