package cat.itb.projectespring.model.servicio;


import cat.itb.projectespring.model.entidad.Usuario;
import cat.itb.projectespring.model.repositorio.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    @PostConstruct
    public void init() {
        repositorioUsuarios.save(new Usuario("aaron", passwordEncoder("123456"), "123456"));
        repositorioUsuarios.save(new Usuario("pepita", passwordEncoder("654321"), "654321" ));
        repositorioUsuarios.save(new Usuario("administrador", passwordEncoder("administrador"), "administrador","ADMIN"));

    }

    public void afegir(Usuario e) {
        e.setPassword(passwordEncoder(e.getPassword()));
        repositorioUsuarios.save(e);
    }

    public Usuario consultaPorId(String s) {
        return repositorioUsuarios.findById(s).orElse(null);
    }

    public String passwordEncoder(String s) {
        return new BCryptPasswordEncoder().encode(s);
    }
}
