package com.margaretnjoki.hello_spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/notes")
public class NoteController {
   private final Map<UUID, Note>notes=new HashMap<>();
   @GetMapping
   public List<Note>all(){
       return new ArrayList<>(notes.values());
   }
   @GetMapping("/{id}")
   public ResponseEntity <Note> one(UUID id){
       Note note=notes.get(id);
       if (note==null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(note);
   }
@PostMapping
   public ResponseEntity<Note> createNote(@RequestBody CreateNoteRequest request){
       Note note=new Note(UUID.randomUUID(), request.text(), Instant.now());
       notes.put(note.id(),note);
       return ResponseEntity.status(HttpStatus.CREATED).body(note);
   }
@DeleteMapping("/{id}")
public ResponseEntity<Void>delete(@PathVariable UUID id){
       if (!notes.containsKey(id)){
          return ResponseEntity.notFound().build();
       }
       notes.remove(id);
       return ResponseEntity.noContent().build();
}
@PutMapping("/{id}")
public ResponseEntity<Note> update(UUID id){
       Note old=notes.get(id);
       if (old==null){
           return ResponseEntity.noContent().build();
       }
       Note updated=new Note(old.id(), old.text(), old.createdAT());
       notes.put(old.id(), updated);
       return ResponseEntity.ok(updated);
}








}
