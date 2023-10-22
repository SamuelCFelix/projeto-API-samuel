package myfirstapi.projetosamuel.services;

import myfirstapi.projetosamuel.model.Usuarios;
import myfirstapi.projetosamuel.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuarios createUsuario(Usuarios usuario){
        return usuarioRepository.save(usuario);
    }
    public Usuarios updateUsuario(Long id, Usuarios usuario){
        Usuarios existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null){
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setCep(usuario.getCep());
            return usuarioRepository.save(existingUsuario);
        } else
            throw new RuntimeException("Impossível atualizar o usuário " + id + "pois ele não existe");
    }

    public List<Usuarios> getAllUsuarios(){
        return  usuarioRepository.findAll();
    }
    public  Usuarios getUsuarioById(Long id){
        Optional<Usuarios> optionalUsuarios = usuarioRepository.findById(id);
        if (optionalUsuarios.isPresent()){
            return optionalUsuarios.get();
        } else
            throw new RuntimeException("Usuário não encontrado com ID:" + id);
    }
    public void deleteUsuarioById(Long id){
        usuarioRepository.deleteById(id);
    }
}
