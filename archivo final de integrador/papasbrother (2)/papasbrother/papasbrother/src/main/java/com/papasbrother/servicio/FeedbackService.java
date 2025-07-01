package com.papasbrother.servicio;

import com.papasbrother.modelo.Feedback;
import com.papasbrother.repositorio.FeedbackRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar feedback de usuarios.
 */
@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository = new FeedbackRepository();

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}