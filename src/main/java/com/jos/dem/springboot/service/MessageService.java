package com.jos.dem.springboot.sse.service;

import reactor.core.publisher.Flux;

import com.jos.dem.springboot.sse.model.MessageCommand;

public interface MessageService {
  Flux<MessageCommand> stream();
}
