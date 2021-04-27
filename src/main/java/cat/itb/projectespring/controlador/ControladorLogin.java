package cat.itb.projectespring.controlador;

import cat.itb.projectespring.model.entidad.Usuario;
import cat.itb.projectespring.model.servicio.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class ControladorLogin {

    @Autowired
    private UserService servicio;

    @PostMapping("/registration")
    public String afegirSubmit(@ModelAttribute("usuario") Usuario e){
        e.setRol("USER");
        servicio.afegir(e);
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }
}
