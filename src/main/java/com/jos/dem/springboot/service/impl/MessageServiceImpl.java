package com.jos.dem.springboot.sse.service.impl;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Arrays;
import java.time.Instant;
import java.time.Duration;

import com.jos.dem.springboot.sse.model.Command;
import com.jos.dem.springboot.sse.model.MessageCommand;
import com.jos.dem.springboot.sse.service.MessageService;

public class MessageServiceImpl implements MessageService {

  public Flux<Command> getAll() {
    return Flux.interval(Duration.ofSeconds(1))
      .onBackpressureDrop()
      .map(this::generateComment)
      .flatMapIterable(x -> x);
  }

  private List<Command> generateComment(long interval) {
    Command command = new MessageCommand(
      "josdem",
      "Hello World!",
      Instant.now());
    return Arrays.asList(command);
  }

}
