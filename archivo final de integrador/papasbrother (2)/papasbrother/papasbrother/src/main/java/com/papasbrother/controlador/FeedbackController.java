package com.papasbrother.controlador;

import com.papasbrother.modelo.Feedback;
import com.papasbrother.servicio.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para feedback de usuarios.
 */
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public List<Feedback> listarFeedback() {
        return feedbackService.getAllFeedback();
    }

    @PostMapping
    public Feedback crearFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @DeleteMapping("/{id}")
    public void eliminarFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
}