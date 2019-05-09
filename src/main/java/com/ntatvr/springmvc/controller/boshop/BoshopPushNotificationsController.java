package com.ntatvr.springmvc.controller.boshop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ntatvr.springmvc.controller.RESTController;
import com.ntatvr.springmvc.entity.boshop.BoshopPushNotifications;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/boshop/pushNotifications")
public class BoshopPushNotificationsController
    extends RESTController<BoshopPushNotifications, Integer> {

  public BoshopPushNotificationsController(
      JpaRepository<BoshopPushNotifications, Integer> repository) {
    super(repository);
  }

}
