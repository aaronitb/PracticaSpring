package cat.itb.projectespring.model.repositorio;

import cat.itb.projectespring.model.entidad.Fruta;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioFrutas extends CrudRepository<Fruta, String> {

}
