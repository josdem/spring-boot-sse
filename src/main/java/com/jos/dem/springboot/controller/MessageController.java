package com.jos.dem.springboot.sse.controller;

import reactor.core.publisher.Flux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.jos.dem.springboot.sse.model.MessageCommand;
import com.jos.dem.springboot.sse.service.MessageService;

@RestController
public class MessageController {

  @Autowired
  private MessageService messageService;

  @GetMapping("/")
  public Flux<MessageCommand> index() {
    return messageService.stream();
  }

}


