package com.ntatvr.springmvc.entity.boshop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Proxy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * [@ApiModelProperty] This annotation is used in the Model property to add some description to the
 * Swagger output for that model attribute.
 * 
 * @author AnhNT
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "boshop_product")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class BoshopProduct implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 2590185890978563588L;

  @ApiModelProperty(name = "product_id", required = true)
  @Id
  @Column(name = "product_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("product_id")
  private Integer productId;

  @ApiModelProperty(name = "product_title", required = true)
  @NotNull
  @Column(name = "product_title")
  @JsonProperty("product_title")
  private String productTitle;

  @ApiModelProperty(name = "title", required = true)
  @NotNull
  @Column(name = "title")
  @JsonProperty("title")
  private String title;

  @ApiModelProperty(name = "product_description", required = true)
  @NotNull
  @Column(name = "product_description")
  @JsonProperty("product_description")
  private String productDescription;

  @ApiModelProperty(name = "product_old_price", required = false)
  @Column(name = "product_old_price")
  @JsonProperty("product_old_price")
  private String productOldPrice;

  @ApiModelProperty(name = "product_new_price", required = true)
  @NotNull
  @Column(name = "product_new_price")
  @JsonProperty("product_new_price")
  private String productNewPrice;

  @ApiModelProperty(name = "product_discount", required = false)
  @Column(name = "product_discount")
  @JsonProperty("product_discount")
  private String productDiscount;

  @ApiModelProperty(name = "product_image", required = true)
  @NotNull
  @Column(name = "product_image")
  @JsonProperty("product_image")
  private String productImage;

  @ApiModelProperty(name = "product_is_active", required = true)
  @NotNull
  @Column(name = "product_is_active")
  @JsonProperty("product_is_active")
  private Integer productIsActive = 1;
}

