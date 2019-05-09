package com.ntatvr.springmvc.controller.boshop;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ntatvr.springmvc.controller.RESTController;
import com.ntatvr.springmvc.entity.boshop.BoshopProduct;
import com.ntatvr.springmvc.exception.ApiData;
import com.ntatvr.springmvc.service.boshop.BoshopProductService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/boshop/product")
public class BoshopProductController extends RESTController<BoshopProduct, Integer> {

  @Autowired
  private BoshopProductService boshopProductService;

  public BoshopProductController(JpaRepository<BoshopProduct, Integer> repository) {
    super(repository);
  }


  @ApiOperation(value = "Crawler to get data from boshop and save into boshop_product table."
      + " URI: https://www.boshop.vn/nuoc-hoa.html", response = ApiData.class)
  @GetMapping(value = "/all")
  @ResponseBody
  public ResponseEntity<Object> getProducts(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    try {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String sourceURI = "https://www.boshop.vn/nuoc-hoa.html";
    List<BoshopProduct> products = boshopProductService.getProducts(sourceURI);
    boshopProductService.truncate();
    // boshopProductService.save(products);
    return new ResponseEntity<>(new ApiData(products), HttpStatus.OK);
  }
}
