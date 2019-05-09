package com.ntatvr.springmvc.service.boshop;

import com.ntatvr.springmvc.entity.boshop.BoshopPushNotifications;
import com.ntatvr.springmvc.service.GenericService;

public interface BoshopPushNotificationsService extends GenericService<BoshopPushNotifications> {

  void truncate();
}
