package com.jos.dem.springboot.sse.util;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class MessageGenerator {

  private List<String> messages = Arrays.asList(
    "Bonjour",
    "Hola",
    "Zdravstvuyte",
    "Salve",
    "Guten Tag",
    "Hello");

  private final Random random = new Random(messages.size());

  public String generate() {
    return messages.get(random.nextInt(messages.size()));
  }

}
