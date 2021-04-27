package cat.itb.projectespring.controlador;

import cat.itb.projectespring.model.entidad.Fruta;
import cat.itb.projectespring.model.servicio.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorFruta {

    String nombre;

    @Autowired
    private FrutaService servicioFruta;

    @GetMapping("/")
    public String index(Model m){
        m.addAttribute("listaFruta",servicioFruta.sortByName());
        m.addAttribute("Fruta",new Fruta());
        return "index";
    }

    @RequestMapping( value ="/delete/{name}", method = RequestMethod.POST)
    public String eliminarFruta(@PathVariable("name") String fruta){
        servicioFruta.eliminarFrutaPorNombre(fruta);
        return "redirect:/";
    }

    @RequestMapping("/afegir")
    public String afegirFruta(Model model) {
        model.addAttribute("Fruta", new Fruta());
        return "nuevaFruta";
    }

    @PostMapping("/afegirFruta")
    public String AfegirFruta(@ModelAttribute("Fruta") Fruta e){
        servicioFruta.afegir(e);
        return "redirect:/";
    }

    @RequestMapping( value ="/update/{name}", method = RequestMethod.POST)
    public String updateFruta(@PathVariable("name") String fruta, Model m){
        nombre = fruta;
        m.addAttribute("Fruta",servicioFruta.consultaPorNombre(fruta));
        return "actualizarFruta";
    }

    @PostMapping("/updateFruta")
    public String updateFrutapost(@ModelAttribute("Fruta") Fruta e){
        servicioFruta.updateFruta(e);
        return "redirect:/";
    }

}




