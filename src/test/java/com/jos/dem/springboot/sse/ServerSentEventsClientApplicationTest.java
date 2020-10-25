package com.jos.dem.springboot.sse;

import com.jos.dem.springboot.sse.model.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ServerSentEventsClientApplicationTest {

  private final WebTestClient webClient;

  @Test
  @DisplayName("Should get five events")
  void shouldConsumeServerSentEvents() {
    log.info("Running: Consume server sent events: {}", new Date());

    List<Event> commands = webClient.get().uri("/")
            .accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE))
            .exchange()
            .expectStatus().isOk()
            .returnResult(Event.class)
            .getResponseBody()
            .take(5)
            .collectList()
            .block();

    commands.forEach(command -> log.info("command: {}", command));
    assertEquals(5, commands.size());
  }

}
