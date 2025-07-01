package com.papasbrother.controlador;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; // Needed for @RequestMapping
import org.springframework.web.bind.annotation.RequestParam;

import com.papasbrother.modelo.User;
import com.papasbrother.repositorio.UserRepository;

import java.util.Optional; // Necessary for Optional<User>



@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", userRepository.findAll());
        return "administradorpanel"; // Asegúrate de que esta vista tiene la tabla con th:each
    }

    @PostMapping("/editar")
    public String editarUsuario(@RequestParam Long id,
                                @RequestParam String nombre,
                                @RequestParam String correo,
                                @RequestParam String username) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User user = optional.get();
            user.setNombre(nombre);
            user.setCorreo(correo);
            user.setUsername(username);
            userRepository.save(user);
        }
        return "redirect:/usuarios/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/usuarios/listar";
    }
}
