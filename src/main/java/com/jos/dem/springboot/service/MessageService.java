package com.jos.dem.springboot.sse.service;

import reactor.core.publisher.Flux;

import com.jos.dem.springboot.sse.model.Command;

public interface MessageService {
  Flux<Command> getAll();
}
