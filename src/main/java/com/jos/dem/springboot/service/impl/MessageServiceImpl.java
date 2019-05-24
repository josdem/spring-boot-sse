package com.jos.dem.springboot.sse.service.impl;

import java.util.List;
import java.util.Arrays;
import java.time.Instant;
import java.time.Duration;

import reactor.core.publisher.Flux;

import org.springframework.stereotype.Service;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.springboot.sse.model.Command;
import com.jos.dem.springboot.sse.model.MessageCommand;
import com.jos.dem.springboot.sse.service.MessageService;
import com.jos.dem.springboot.sse.util.MessageGenerator;

@Service
public class MessageServiceImpl implements MessageService {

  @Autowired
  private MessageGenerator messageGenerator;

  public Flux<ServerSentEvent<Command>> getAll() {
    return Flux.interval(Duration.ofSeconds(1))
      .map(event -> ServerSentEvent.<Command> builder()
          .id(String.valueOf(event))
          .event("event")
          .data(new MessageCommand("josdem", messageGenerator.generate(), Instant.now()))
          .build());
  }

}
