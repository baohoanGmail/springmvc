package com.ntatvr.springmvc.schedule;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ntatvr.springmvc.entity.Crawler;
import com.ntatvr.springmvc.service.CrawlerService;

@Component
public class EventCreator {

  @Autowired
  private CrawlerService crawlerService;

  /**
   * Format of cron: [second minute hour day-of-month month day(s)-of-week]
   * 
   * Cron job will be executed every day
   * 
   * @throws IOException
   */
  @Scheduled(cron = "0 0 0 * * ?")
  public void crawler() throws IOException {
    System.out.println("Call API /crawler");
    //String sourceURI = "https://www.webtretho.com/forum/f26/";
    //List<Crawler> crawlers = crawlerService.getNews(sourceURI);
    //crawlerService.truncate();
    //crawlerService.save(crawlers);
  }
}
