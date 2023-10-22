package myfirstapi.projetosamuel.controllers;

import myfirstapi.projetosamuel.model.Usuarios;
import myfirstapi.projetosamuel.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/create")
    public ResponseEntity<Usuarios> createUsuario(@RequestBody Usuarios usuario) {
        Usuarios createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable Long id, @RequestBody Usuarios usuario){
        Usuarios usuarioAtualizado = usuarioService.updateUsuario(id, usuario);
        if (usuarioAtualizado != null){
            return ResponseEntity.ok(usuarioAtualizado);
        } else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuarioById(@PathVariable Long id){
        Usuarios usuario = usuarioService.getUsuarioById(id);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        } else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/all")
    public ResponseEntity<List<Usuarios>> getAllUsuarios(){
        List<Usuarios> usuarios = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id){
        usuarioService.deleteUsuarioById(id);
        return ResponseEntity.noContent().build();
    }
}
