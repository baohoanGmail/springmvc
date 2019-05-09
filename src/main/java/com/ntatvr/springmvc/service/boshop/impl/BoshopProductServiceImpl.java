package com.ntatvr.springmvc.service.boshop.impl;

import java.io.IOException;
import java.util.ArrayList;
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
import com.ntatvr.springmvc.entity.boshop.BoshopProduct;
import com.ntatvr.springmvc.repository.boshop.BoshopProductRepository;
import com.ntatvr.springmvc.service.boshop.BoshopProductService;

@Service(value = "BoshopProductService")
@Transactional
public class BoshopProductServiceImpl implements BoshopProductService {

  @Autowired
  private BoshopProductRepository boshopProductRepository;

  @Override
  public List<BoshopProduct> getProducts(String url) throws IOException {


    Document document = Jsoup.connect(url).get();
    Elements lstProducts =
        document.select(".loop-products").select(".container").select(".row").select(".col-md-3");

    // Use the abs: attribute prefix to resolve an absolute URL from an attribute
    List<BoshopProduct> result = new ArrayList<>();
    lstProducts.forEach(item -> {

      BoshopProduct product = new BoshopProduct();
      Element element = item.getElementsByClass("alicenter").get(0).child(0).child(0);
      String productImage = element.attr("src");
      product.setProductImage(productImage);

      element = item.getElementsByClass("extension-pro").get(0).getElementsByClass("row-price")
          .get(0).getElementsByClass("new-pricepro").get(0);
      String productNewPrice = element.html();
      product.setProductNewPrice(productNewPrice);

      element = item.getElementsByClass("extension-pro").get(0).getElementsByClass("row-price")
          .get(0).getElementsByClass("old-pricepro").get(0);
      String productOldPrice = element.html();
      product.setProductOldPrice(productOldPrice);

      element = item.getElementsByClass("extension-pro").get(0).getElementsByClass("row-price")
          .get(0).getElementsByClass("old-pricepro").get(0).child(0);
      String productDiscount = element.html();
      product.setProductDiscount(productDiscount);

      element = item.getElementsByClass("product-title").get(0).child(0).child(0);
      String productTitle = element.html();
      product.setProductTitle(productTitle);

      element = item.getElementsByClass("product-title").get(0).child(0).child(1);
      String productDescription = element.html();
      product.setProductDescription(productDescription);
      result.add(product);
    });

    return result;
  }

  @Override
  public List<BoshopProduct> findAll() {
    return boshopProductRepository.findAll();
  }

  @Override
  public void save(BoshopProduct theObject) {
    boshopProductRepository.save(theObject);
  }

  @Override
  public BoshopProduct getOne(Integer theId) {
    return boshopProductRepository.getOne(theId);
  }

  @Override
  public Optional<BoshopProduct> findById(Integer theId) {
    return boshopProductRepository.findById(theId);
  }

  @Override
  public void deleteById(Integer theId) {
    boshopProductRepository.deleteById(theId);
  }

  @Override
  public void save(List<BoshopProduct> crawlers) {

    crawlers.forEach(crawler -> boshopProductRepository.save(crawler));
  }

  @Override
  public void deleteAll() {
    boshopProductRepository.deleteAll();
  }

  @Override
  public void truncate() {
    boshopProductRepository.truncate();
  }

  @Override
  public List<BoshopProduct> findAll(Integer limit, Integer page) {

    Pageable pageable = PageRequest.of(page, limit);
    return boshopProductRepository.findAll(pageable).getContent();
  }

  @Override
  public long count() {
    return boshopProductRepository.count();
  }

}
