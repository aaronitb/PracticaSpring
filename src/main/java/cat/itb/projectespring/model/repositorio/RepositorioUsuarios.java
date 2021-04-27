package cat.itb.projectespring.model.repositorio;

import cat.itb.projectespring.model.entidad.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuarios extends CrudRepository<Usuario, String> {

}
