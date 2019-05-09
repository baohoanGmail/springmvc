CREATE TABLE `classicmodels`.`crawler` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `uri` LONGTEXT NOT NULL,
  `title` LONGTEXT NOT NULL,
  `image` LONGTEXT NULL,
  `reader` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reply` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdDate` DATETIME NOT NULL,
  `updatedDate` DATETIME NULL,
  `isActive` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `classicmodels`.`boshop_product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_title` VARCHAR(255) NOT NULL,
  `product_description` VARCHAR(255) NOT NULL,
  `product_old_price` VARCHAR(45) NULL,
  `product_new_price` VARCHAR(45) NOT NULL,
  `product_discount` VARCHAR(10) NULL,
  `product_image` VARCHAR(255) NOT NULL,
  `product_is_active` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE `classicmodels`.`boshop_push_notifications` (
  `id_push_notifications` INT NOT NULL,
  `push_notifications_token` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_push_notifications`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;



