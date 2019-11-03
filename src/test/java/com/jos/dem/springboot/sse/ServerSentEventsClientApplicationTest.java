package com.jos.dem.springboot.sse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Date;
import java.time.LocalTime;

import reactor.core.publisher.Flux;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.jos.dem.springboot.sse.model.MessageCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ServerSentEventsClientApplicationTest {

  @Autowired
  private WebTestClient webClient;

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Test
  @DisplayName("Should get five events")
  void shouldConsumeServerSentEvents() {
    log.info("Running: Consume server sent events: {}", new Date());

    List<MessageCommand> commands = webClient.get().uri("/")
      .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
      .exchange()
      .expectStatus().isOk()
      .returnResult(MessageCommand.class)
      .getResponseBody()
      .take(5)
      .collectList()
      .block();

    commands.forEach(command -> log.info("command: {}", command));
    assertEquals(5, commands.size());
  }

}
