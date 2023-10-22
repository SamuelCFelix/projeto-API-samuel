package myfirstapi.projetosamuel.services;

import myfirstapi.projetosamuel.model.Usuarios;
import myfirstapi.projetosamuel.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuarios createUsuario(Usuarios usuario){
        return usuarioRepository.save(usuario);
    }
}
