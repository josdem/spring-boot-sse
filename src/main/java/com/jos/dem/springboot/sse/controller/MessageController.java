package com.jos.dem.springboot.sse.controller;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jos.dem.springboot.sse.model.Event;
import com.jos.dem.springboot.sse.service.MessageService;

@RestController
@RequiredArgsConstructor
public class MessageController {

  private final MessageService messageService;

  @GetMapping(path = "/",  produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Event> index() {
    return messageService.stream();
  }

}