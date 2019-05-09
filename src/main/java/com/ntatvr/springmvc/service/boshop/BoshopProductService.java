package com.ntatvr.springmvc.service.boshop;

import java.io.IOException;
import java.util.List;
import com.ntatvr.springmvc.entity.boshop.BoshopProduct;
import com.ntatvr.springmvc.service.GenericService;

public interface BoshopProductService extends GenericService<BoshopProduct> {

  List<BoshopProduct> getProducts(String url) throws IOException;

  void save(List<BoshopProduct> products);

  void truncate();
}
