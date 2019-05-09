package com.ntatvr.springmvc.repository.boshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ntatvr.springmvc.entity.boshop.BoshopProduct;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface BoshopProductRepository extends JpaRepository<BoshopProduct, Integer> {

  @Modifying
  @Query(value = "TRUNCATE TABLE boshop_product", nativeQuery = true)
  void truncate();
}
