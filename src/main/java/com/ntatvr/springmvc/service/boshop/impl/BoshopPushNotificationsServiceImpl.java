package com.ntatvr.springmvc.service.boshop.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ntatvr.springmvc.entity.boshop.BoshopPushNotifications;
import com.ntatvr.springmvc.repository.boshop.BoshopPushNotificationsRepository;
import com.ntatvr.springmvc.service.boshop.BoshopPushNotificationsService;

@Service(value = "BoshopPushNotificationsService")
@Transactional
public class BoshopPushNotificationsServiceImpl implements BoshopPushNotificationsService {

  @Autowired
  private BoshopPushNotificationsRepository boshopPushNotificationsRepository;
  
  @Override
  public List<BoshopPushNotifications> findAll() {
    return boshopPushNotificationsRepository.findAll();
  }

  @Override
  public List<BoshopPushNotifications> findAll(Integer limit, Integer page) {
    Pageable pageable = PageRequest.of(page, limit);
    return boshopPushNotificationsRepository.findAll(pageable).getContent();
  }

  @Override
  public void save(BoshopPushNotifications theObject) {
    boshopPushNotificationsRepository.save(theObject);
  }

  @Override
  public BoshopPushNotifications getOne(Integer theId) {
    return boshopPushNotificationsRepository.getOne(theId);
  }

  @Override
  public Optional<BoshopPushNotifications> findById(Integer theId) {
    return boshopPushNotificationsRepository.findById(theId);
  }

  @Override
  public void deleteById(Integer theId) {
    boshopPushNotificationsRepository.deleteById(theId);
  }

  @Override
  public void deleteAll() {
    boshopPushNotificationsRepository.deleteAll();
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void truncate() {
    
  }

}
