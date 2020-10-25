package com.jos.dem.springboot.sse.service;

import reactor.core.publisher.Flux;

import com.jos.dem.springboot.sse.model.Event;

public interface MessageService {
  Flux<Event> stream();
}
