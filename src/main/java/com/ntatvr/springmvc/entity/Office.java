package com.ntatvr.springmvc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table(name = "offices")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Office implements Serializable {

  private static final long serialVersionUID = -4504274612657965655L;

  @ApiModelProperty(notes = "Identity id of the Office", name = "officeCode", required = true)
  @Id
  @Column(name = "officeCode")
  @JsonProperty("office_code")
  private String officeCode;

  @ApiModelProperty(name = "city", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "city")
  @JsonProperty("city")
  private String city;

  @ApiModelProperty(name = "phone", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "phone")
  @JsonProperty("phone")
  private String phone;

  @ApiModelProperty(name = "addressLine1", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "addressLine1")
  @JsonProperty("address_line_1")
  private String addressLine1;

  @ApiModelProperty(name = "addressLine2", required = false)
  @Size(max = 50)
  @Column(name = "addressLine2")
  @JsonProperty("address_line_2")
  private String addressLine2;

  @ApiModelProperty(name = "state", required = false)
  @Size(max = 50)
  @Column(name = "state")
  @JsonProperty("state")
  private String state;

  @ApiModelProperty(name = "country", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "country")
  @JsonProperty("country")
  private String country;

  @ApiModelProperty(name = "postalCode", required = true)
  @NotNull
  @Size(max = 15)
  @Column(name = "postalCode")
  @JsonProperty("postal_code")
  private String postalCode;

  @ApiModelProperty(name = "territory", required = true)
  @NotNull
  @Size(max = 10)
  @Column(name = "territory")
  @JsonProperty("territory")
  private String territory;

}
