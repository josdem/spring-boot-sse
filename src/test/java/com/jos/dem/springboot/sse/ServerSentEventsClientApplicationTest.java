package com.jos.dem.springboot.sse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Date;
import java.time.LocalTime;

import reactor.core.publisher.Flux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.jos.dem.springboot.sse.model.Command;
import com.jos.dem.springboot.sse.model.MessageCommand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServerSentEventsClientApplicationTest {

  @Autowired
  private WebTestClient webClient;

  private Logger log = LoggerFactory.getLogger(this.getClass());

	@Test
	public void shouldConsumeServerSentEvents() throws Exception {
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
