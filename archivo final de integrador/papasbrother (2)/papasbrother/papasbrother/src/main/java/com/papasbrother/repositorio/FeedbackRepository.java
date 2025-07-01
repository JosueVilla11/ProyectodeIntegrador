package com.papasbrother.repositorio;

import com.papasbrother.modelo.Feedback;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio simulado para Feedback.
 */
public class FeedbackRepository {
    private final List<Feedback> feedbacks = new ArrayList<>();

    public List<Feedback> findAll() {
        return new ArrayList<>(feedbacks);
    }

    public Optional<Feedback> findById(Long id) {
        return feedbacks.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Feedback save(Feedback feedback) {
        feedbacks.add(feedback);
        return feedback;
    }

    public void deleteById(Long id) {
        feedbacks.removeIf(f -> f.getId().equals(id));
    }
}
