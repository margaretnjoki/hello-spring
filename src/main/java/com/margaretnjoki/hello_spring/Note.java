package com.margaretnjoki.hello_spring;

import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

public record Note(UUID id, String text, Instant createdAT) {

}
