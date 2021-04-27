package cat.itb.projectespring.model.servicio;

import cat.itb.projectespring.model.entidad.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService servicioUsuarios;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario u= servicioUsuarios.consultaPorId(s);
        User.UserBuilder builder=null;
        if(u!=null){
            builder=User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.roles(u.getRol());
        }
        else throw new UsernameNotFoundException("Usuario no encontrado");
        return builder.build();
    }

}
