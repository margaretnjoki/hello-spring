package com.margaretnjoki.hello_spring;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final Map<UUID,Task> tasks=new HashMap<>();

    @GetMapping
    public List<Task>all(){
        return new ArrayList<>(tasks.values());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task>one(@PathVariable UUID id){
        Task task=tasks.get(id);
        if (task==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task>create(@RequestBody CreateTaskRequest request){
       Task task=new Task(UUID.randomUUID(), request.title(),false, Instant.now());
       tasks.put(task.id(),task);
       return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    
}
