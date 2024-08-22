package cl.praxis.EjercicioSpring.controller;


import cl.praxis.EjercicioSpring.model.Estudiante;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.*;

@Controller
@RequestMapping("/")
public class InitController {

    @GetMapping
    public String init(Model model){

        List<Estudiante> lista = new ArrayList<Estudiante>();
        lista.add(new Estudiante(1,"Raul","Loyola"));
        lista.add(new Estudiante(2,"Martin","Otarola"));
        lista.add(new Estudiante(3,"Jose","Castro"));
        lista.add(new Estudiante(4,"Brian","Alvarez"));
        lista.add(new Estudiante(5,"Cecilio","Miranda"));
        lista.add(new Estudiante(6,"Grimanesa","jimenez"));

        model.addAttribute("lista",lista);


        return "index";
    }

}
