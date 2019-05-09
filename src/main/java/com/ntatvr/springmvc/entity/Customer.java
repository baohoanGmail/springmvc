package com.ntatvr.springmvc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Proxy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@Table(name = "customers")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Customer implements Serializable {

  private static final long serialVersionUID = -1910468634969245768L;

  @ApiModelProperty(notes = "Identity id of the Customer", name = "customerNumber", required = true)
  @Id
  @NotNull
  @Size(max = 11)
  @Column(name = "customerNumber")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("customer_number")
  private Integer customerNumber;

  @ApiModelProperty(notes = "Full name of the Customer", name = "customerName", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "customerName")
  @JsonProperty("customer_name")
  private String customerName;

  @ApiModelProperty(name = "contactLastName", required = true)
  @NotNull
  @Column(name = "contactLastName")
  @JsonProperty("contact_last_name")
  private String contactLastName;

  @ApiModelProperty(name = "contactFirstName", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "contactFirstName")
  @JsonProperty("contact_first_name")
  private String contactFirstName;

  @JsonProperty("phone")
  @ApiModelProperty(name = "phone", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "phone")
  private String phone;

  @JsonProperty("address_line_1")
  @ApiModelProperty(name = "addressLine1", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "addressLine1")
  private String addressLine1;

  @JsonProperty("address_line_2")
  @ApiModelProperty(name = "addressLine2", required = false)
  @Size(max = 50)
  @Column(name = "addressLine2")
  private String addressLine2;

  @JsonProperty("city")
  @ApiModelProperty(name = "city", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "city")
  private String city;

  @JsonProperty("state")
  @ApiModelProperty(name = "state", required = false)
  @Size(max = 50)
  @Column(name = "state")
  private String state;

  @JsonProperty("postal_code")
  @ApiModelProperty(name = "postalCode", required = false)
  @Size(max = 15)
  @Column(name = "postalCode")
  private String postalCode;

  @JsonProperty("country")
  @ApiModelProperty(name = "country", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "country")
  private String country;

  @JsonProperty("sales_rep_employee_number")
  @ApiModelProperty(name = "salesRepEmployeeNumber", required = false)
  @Size(max = 11)
  @Column(name = "salesRepEmployeeNumber")
  private Integer salesRepEmployeeNumber;

  @JsonProperty("credit_limit")
  @ApiModelProperty(name = "creditLimit", required = false)
  @Size(max = 50)
  @Column(name = "creditLimit")
  private Double creditLimit;
}
