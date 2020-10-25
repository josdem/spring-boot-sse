package com.jos.dem.springboot.sse.model;

import java.time.Instant;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
  private String nickname;
  private String text;
  private Instant timestamp;
}

