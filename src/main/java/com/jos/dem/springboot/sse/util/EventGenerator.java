package com.jos.dem.springboot.sse.util;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EventGenerator {

  private List<String> events = Arrays.asList(
    "Bonjour",
    "Hola",
    "Zdravstvuyte",
    "Salve",
    "Guten Tag",
    "Hello");

  private final Random random = new Random(events.size());

  public String generate() {
    return events.get(random.nextInt(events.size()));
  }

}
