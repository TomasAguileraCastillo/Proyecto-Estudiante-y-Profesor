package cl.praxis.desafioSpring.controller;

import cl.praxis.desafioSpring.model.dto.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tomasaguilera")
public class InitController {
    Persona p = new Persona();
    @GetMapping
    public String init(){
        llenadodatos();
        impresion();
        return "index";
    }
     public void llenadodatos(){
         p.setNombre("Tomas");
         p.setApellido("Aguilera");
         p.setEdad(42);
     }
     public void impresion(){
         System.out.println("Nombre : " + p.getNombre());
         System.out.println("Apellido : " + p.getApellido() );
         System.out.println("Edad : " + p.getEdad() );
     }




}
