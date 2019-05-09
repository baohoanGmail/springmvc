package com.ntatvr.springmvc.service;

import java.io.IOException;
import java.util.List;
import com.ntatvr.springmvc.entity.Crawler;

public interface CrawlerService extends GenericService<Crawler> {

  /**
   * Gets news.
   *
   * @param url the URL
   * @return the page links
   * @throws IOException Signals that an I/O exception has occurred.
   */
  List<Crawler> getNews(String url) throws IOException;

  void save(List<Crawler> crawlers);
  
  void truncate();
}
