package oit.is.z0813.kaizi.janken.service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z0813.kaizi.janken.model.Match;
import oit.is.z0813.kaizi.janken.model.MatchMapper;

@Service
public class AsyncKekka{
  int wait = 0;
  @Autowired
  MatchMapper matchMapper;
  private final Logger logger = LoggerFactory.getLogger(AsyncKekka.class);
@Async
  public void asyncWait(SseEmitter emitter) {
    try {
      while (true) {
        TimeUnit.MILLISECONDS.sleep(500);
        wait = matchMapper.selectactive();
        if (wait == 0) {
            continue;
        }
        emitter.send(wait);
        wait = 0;
      }
    } catch (Exception e) {
      logger.warn("Exception:" + e.getClass().getName() + ":" + e.getMessage());
    } finally {
      emitter.complete();
    }
    System.out.println("asyncWait complete");
  }
}
