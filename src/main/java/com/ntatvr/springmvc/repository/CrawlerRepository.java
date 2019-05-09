package com.ntatvr.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ntatvr.springmvc.entity.Crawler;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface CrawlerRepository extends JpaRepository<Crawler, Integer> {

  @Modifying
  @Query(value = "TRUNCATE TABLE crawler", nativeQuery = true)
  void truncate();
}
