package prueba.com.mich.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import prueba.com.mich.materia.Materia;
import prueba.com.mich.materia.MateriaRepository;

@Controller
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping({"/", "/listaMaterias"})
    public String inicio(Model model) {
        model.addAttribute("listaMaterias", materiaRepository.findAll());
        return "listaMaterias";
    }

    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("materia", new Materia());
        return "Materia";
    }

    @PostMapping("/guardar")
    public String guardarMateria(@ModelAttribute Materia materia) {
        materiaRepository.save(materia);
        return "redirect:/listaMaterias";
    }

    @GetMapping("/buscar")
    public String buscarMaterias(@RequestParam("criterio") String criterio, Model model) {

        if (criterio == null || criterio.trim().isEmpty()) {
            model.addAttribute("listaMaterias", materiaRepository.findAll());
        } else {
            model.addAttribute("listaMaterias",
                    materiaRepository.buscarPorTodo(criterio));
        }

        return "listaMaterias";
    }

    @GetMapping("/editar/{id}")
    public String editarMateria(@PathVariable Long id, Model model) {

        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));

        model.addAttribute("materia", materia);
        return "Materia";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id) {
        materiaRepository.deleteById(id);
        return "redirect:/listaMaterias";
    }
}
