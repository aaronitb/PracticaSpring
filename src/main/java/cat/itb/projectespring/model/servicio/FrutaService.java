package cat.itb.projectespring.model.servicio;

import cat.itb.projectespring.model.entidad.Fruta;
import cat.itb.projectespring.model.entidad.Usuario;
import cat.itb.projectespring.model.repositorio.RepositorioFrutas;
import cat.itb.projectespring.model.repositorio.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class FrutaService {

    @Autowired
    private RepositorioFrutas repositorioFrutas;

    @PostConstruct
    public void init() {
        repositorioFrutas.save(new Fruta("Platano", "Amarillo", "Dulce", "Primavera"));
        repositorioFrutas.save(new Fruta("Melon", "Verde", "Dulce", "Verano"));
        repositorioFrutas.save(new Fruta("Limon", "Amarillo", "Acido", "Otoño"));

    }

    public void afegir(Fruta e) {
        repositorioFrutas.save(e);
    }

    public Fruta consultaPorNombre(String s) {
        return repositorioFrutas.findById(s).orElse(null);
    }

    public void eliminarFrutaPorNombre(String s) {
        repositorioFrutas.deleteById(s);
    }

    public void updateFruta(Fruta e) {
        if (repositorioFrutas.existsById(e.getNombreFruta())){
            repositorioFrutas.save(e);
        }
    }

    public List<Fruta> sortByName() {
        List<Fruta> listado = listado();
        listado.sort(Comparator.comparing(Fruta::getNombreFruta));
        return listado;
    }

    public List<Fruta> listado(){
        List<Fruta> listado = new ArrayList<>();
        repositorioFrutas.findAll().iterator().forEachRemaining(listado::add);
        return listado;
    }
}
