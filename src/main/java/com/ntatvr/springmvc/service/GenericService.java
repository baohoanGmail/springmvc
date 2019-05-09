package com.ntatvr.springmvc.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

  List<T> findAll();

  List<T> findAll(Integer limit, Integer page);

  void save(T theObject);

  T getOne(Integer theId);

  Optional<T> findById(Integer theId);

  void deleteById(Integer theId);

  void deleteAll();

  long count();
}
