package com.jos.dem.springboot.sse.service;

import reactor.core.publisher.Flux;

import org.springframework.http.codec.ServerSentEvent;

import com.jos.dem.springboot.sse.model.Command;

public interface MessageService {
  Flux<ServerSentEvent<Command>> getAll();
}
