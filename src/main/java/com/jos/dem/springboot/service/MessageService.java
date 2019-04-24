package com.jos.dem.springboot.sse.service;

import reactor.core.publisher.Flux;

public interface MessageService {
  Flux<Command> getAll();
}
