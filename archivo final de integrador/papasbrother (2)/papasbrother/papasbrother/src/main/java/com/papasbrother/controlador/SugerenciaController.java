package com.papasbrother.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.papasbrother.modelo.Sugerencia;
import com.papasbrother.servicio.SugerenciaService;

import org.springframework.http.ResponseEntity;
import com.papasbrother.repositorio.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@RequestMapping("/sugerencias")
public class SugerenciaController {
    @Autowired
    private SugerenciaService sugerenciaService;

    @Autowired
    private UserRepository userRepository;


    
    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean autenticado = auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser");
        String correoUsuario = "";
        if (autenticado) {
            String username = auth.getName();
            correoUsuario = userRepository.findByUsername(username).map(u -> u.getCorreo()).orElse("");
        }
        Sugerencia sugerencia = new Sugerencia();
        sugerencia.setEmail(correoUsuario);
        model.addAttribute("sugerencia", sugerencia);
        model.addAttribute("autenticado", autenticado);
        model.addAttribute("correoUsuario", correoUsuario);
        return "administradorpanel/formulario";
    }

    // 2. Para poder enviar las sugerencias 
    @PostMapping("/enviar")
    public String enviarSugerencia(@ModelAttribute Sugerencia sugerencia, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean autenticado = auth != null && auth.isAuthenticated() && !auth.getPrincipal().equals("anonymousUser");
        if (!autenticado) {
            model.addAttribute("error", "Debe iniciar sesión o crear una cuenta para enviar la sugerencia.");
            model.addAttribute("sugerencia", sugerencia);
            model.addAttribute("autenticado", false);
            return "redirect:/login?mensaje=Debe iniciar sesión o crear una cuenta para enviar la sugerencia.";
        }
        // Forzar el correo del usuario autenticado
        String username = auth.getName();
        String correoUsuario = userRepository.findByUsername(username).map(u -> u.getCorreo()).orElse("");
        sugerencia.setEmail(correoUsuario);
        sugerencia.setFechaCreacion(new java.util.Date());
        sugerenciaService.saveSugerencia(sugerencia);
        return "redirect:/inicio"; // O bien mantener /inicio si ese es tu flujo
    }


    // 3. Para poder listar
    @GetMapping("/list")
    public String listarSugerencias(Model model) {
        model.addAttribute("sugerencias", sugerenciaService.getAllSugerencias());
        return "redirect:/administradorpanel";
    }


    // 4. Para poder actualizar
    @PostMapping("/actualizar")
    @ResponseBody
    public ResponseEntity<?> actualizarSugerencia(@RequestBody Sugerencia sugerencia) {
        Sugerencia sugerenciaExistente = sugerenciaService.getSugerenciaById(sugerencia.getId());
        if (sugerenciaExistente != null) {
            sugerenciaExistente.setNombre(sugerencia.getNombre());
            sugerenciaExistente.setEmail(sugerencia.getEmail());
            sugerenciaExistente.setDescripcion(sugerencia.getDescripcion());
            sugerenciaService.saveSugerencia(sugerenciaExistente);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // 5. Para poder eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarSugerencia(@PathVariable Long id, Model model) {
        sugerenciaService.deleteSugerencia(id);
        model.addAttribute("sugerencias", sugerenciaService.getAllSugerencias());
        return "redirect:/inicio";
    }

}
