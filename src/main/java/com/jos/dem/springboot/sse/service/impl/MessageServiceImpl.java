package com.jos.dem.springboot.sse.service.impl;

import java.time.Instant;
import java.time.Duration;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import org.springframework.stereotype.Service;

import com.jos.dem.springboot.sse.model.Event;
import com.jos.dem.springboot.sse.service.MessageService;
import com.jos.dem.springboot.sse.util.EventGenerator;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final EventGenerator eventGenerator;

  public Flux<Event> stream() {
    return Flux.interval(Duration.ofSeconds(1))
      .map(it -> new Event("josdem", eventGenerator.generate(), Instant.now()));
  }

}
