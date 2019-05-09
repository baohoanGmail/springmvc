package com.ntatvr.springmvc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ntatvr.springmvc.entity.Crawler;
import com.ntatvr.springmvc.repository.CrawlerRepository;
import com.ntatvr.springmvc.service.CrawlerService;


/**
 * Crawler Service is used to determine some methods to crawler from the specific web sites.
 * 
 * Library: https://jsoup.org
 * 
 * @author AnhNT
 *
 */
@Service(value = "CrawlerService")
@Transactional
public class CrawlerServiceImpl implements CrawlerService {

  @Autowired
  private CrawlerRepository crawlerRepository;

  @Override
  public List<Crawler> getNews(String url) throws IOException {

    HashSet<String> pageLinks = new HashSet<String>();
    Document document = Jsoup.connect(url).get();
    Elements lstPost = document.select(".ctn_mainCates_sb").select(".lst_typPost")
        .select(".threadbit_nam_fix_select");

    // Use the abs: attribute prefix to resolve an absolute URL from an attribute
    List<Crawler> result = new ArrayList<>();
    lstPost.forEach(post -> {

      Element element = post.getElementsByClass("ico_cateTp").get(0).child(0);
      String image = element.attr("src");

      element = post.getElementsByClass("titleTypPost").get(0).getElementsByClass("title").get(0);
      String uri = element.attr("href");

      element = post.getElementsByClass("titleTypPost").get(0).getElementsByClass("title").get(0)
          .child(0);
      String title = element.html();

      element = post.getElementsByClass("folTypPost").get(0).child(0).child(0).child(0);
      String reader = element.html().trim();

      element = post.getElementsByClass("folTypPost").get(0).child(0).child(1).child(0).child(0);
      String reply = element.html();

      Crawler crawler = new Crawler();
      crawler.setUri(uri);
      crawler.setImage(image);
      crawler.setTitle(title);
      crawler.setReader(reader);
      crawler.setReply(reply);
      result.add(crawler);

      Elements links = element.select("a[href]");
      links.forEach(link -> pageLinks.add(link.children().html()));
    });

    return result;
  }

  @Override
  public List<Crawler> findAll() {
    return crawlerRepository.findAll();
  }

  @Override
  public void save(Crawler theObject) {
    crawlerRepository.save(theObject);
  }

  @Override
  public Crawler getOne(Integer theId) {
    return crawlerRepository.getOne(theId);
  }

  @Override
  public Optional<Crawler> findById(Integer theId) {
    return crawlerRepository.findById(theId);
  }

  @Override
  public void deleteById(Integer theId) {
    crawlerRepository.deleteById(theId);
  }

  @Override
  public void save(List<Crawler> crawlers) {

    crawlers.forEach(crawler -> crawlerRepository.save(crawler));
  }

  @Override
  public void deleteAll() {
    crawlerRepository.deleteAll();
  }

  @Override
  public void truncate() {
    crawlerRepository.truncate();
  }

  @Override
  public List<Crawler> findAll(Integer limit, Integer page) {

    Pageable pageable = PageRequest.of(page, limit);
    return crawlerRepository.findAll(pageable).getContent();
  }

  @Override
  public long count() {
    return crawlerRepository.count();
  }

}
