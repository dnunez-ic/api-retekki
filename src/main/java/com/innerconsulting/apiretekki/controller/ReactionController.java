package com.innerconsulting.apiretekki.controller;


import com.innerconsulting.apiretekki.exception.ResourceNotFoundException;
import com.innerconsulting.apiretekki.model.Reaction;
import com.innerconsulting.apiretekki.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReactionController {
    @Autowired
    ReactionRepository reactionRepository;

    @PostMapping("/reactions")
    public Reaction addReaction(@RequestBody Reaction reaction){
        reactionRepository.save(reaction);
        return reaction;
    }

    @GetMapping("/reactions")
    public List<Reaction> getReactions(){
        return reactionRepository.findAll();
    }

    @GetMapping("/reactions/{id}")
    public ResponseEntity<Reaction> findById(@PathVariable("id") String reactionId){
        Reaction reaction =reactionRepository.findById(reactionId).orElseThrow(
                () -> new ResourceNotFoundException("Reaction not found" + reactionId));
        return ResponseEntity.ok().body(reaction);
    }

    @PutMapping("/reactions/{id}")
    public ResponseEntity<Reaction> updateReaction(@PathVariable(value = "id") String reactionId,
                                                 @RequestBody Reaction reactionDetails) {
        Reaction reaction = reactionRepository.findById(reactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Reaction not found for this id :: " + reactionId));
        reaction.setUbicacion(reactionDetails.getUbicacion());
        reaction.setFechaHora(reactionDetails.getFechaHora());
        reaction.setEmocion(reactionDetails.getEmocion());
        final Reaction updatedReaction = reactionRepository.save(reaction);
        return ResponseEntity.ok(updatedReaction);

    }

    @DeleteMapping("/reactions/{id}")
    public ResponseEntity<Void> deleteReaction(@PathVariable(value = "id") String reactionId) {
        Reaction reaction = reactionRepository.findById(reactionId).orElseThrow(
                () -> new ResourceNotFoundException("Reaction not found::: " + reactionId));
        reactionRepository.delete(reaction);
        return ResponseEntity.ok().build();
    }
}
