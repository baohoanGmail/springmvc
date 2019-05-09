package com.ntatvr.springmvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ntatvr.springmvc.entity.Crawler;
import com.ntatvr.springmvc.exception.ApiData;
import com.ntatvr.springmvc.service.CrawlerService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(maxAge = 3600)
@Slf4j
@Controller
@RequestMapping("/crawler")
public class CrawlerController extends RESTController<Crawler, Integer> {

  @Autowired
  private CrawlerService crawlerService;

  public CrawlerController(JpaRepository<Crawler, Integer> repository) {
    super(repository);
  }

  @RequestMapping(value = "/news", method = RequestMethod.GET)
  public String news(Model model, @Null @RequestParam(required = false) Integer page) {
    log.debug("news()");

    long size = crawlerService.count();
    long totalPage = (size % 10 == 0) ? size / 10 : size / 10 + 1;
    model.addAttribute("totalPage", totalPage);
    int currentPage = (Objects.nonNull(page) ? page - 1 : 0);
    model.addAttribute("currentPage", currentPage + 1);
    model.addAttribute("news", crawlerService.findAll(10, currentPage));
    return "news";
  }

  /**
   * Get page links.
   *
   * @param request the {@link HttpServletRequest}
   * @param response the {@link HttpServletResponse}
   * @return the page links
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @ApiOperation(value = "Crawler to get data from webtretho and save into crawder table."
      + " URI: https://www.webtretho.com/forum/f26/", response = ApiData.class)
  @GetMapping(value = "/getNews")
  @ResponseBody
  public ResponseEntity<Object> getPageLinks(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    try {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    log.debug("Call API /crawler");
    String sourceURI = "https://www.webtretho.com/forum/f26/";
    List<Crawler> crawlers = crawlerService.getNews(sourceURI);
    crawlerService.truncate();
    crawlerService.save(crawlers);
    return new ResponseEntity<>(new ApiData(crawlers), HttpStatus.OK);
  }
}
