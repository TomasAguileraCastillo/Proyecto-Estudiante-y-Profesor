package cl.praxis.EjercicioSpring.controller;

import cl.praxis.EjercicioSpring.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    //endpoint del Controllador al hecer GetMAPPING si no lo tiene
    @GetMapping()
    public String ListT(Model model){
        List<Teacher> listaT = new ArrayList<Teacher>();
        listaT.add(new Teacher(1,"Brian","Guzmán","Bootcamp Java"));
        listaT.add(new Teacher(2,"Mauricio","Gutiérrez","Bootcamp Java1"));

        model.addAttribute("listaT", listaT);

        return "teachers";
    }



    @GetMapping("/{id}")
    public String getOne(@PathVariable("id") int id, Model model){

        Teacher t = new Teacher(1,"Brian","Guzmán","Bootcamp Java");
        model.addAttribute("teacher", t);
        return "teacherDetails";
    }







}
