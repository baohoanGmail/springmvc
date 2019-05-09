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
@Table(name = "employees")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Employee implements Serializable {

  private static final long serialVersionUID = 6449055073139115679L;

  @ApiModelProperty(notes = "Identity id of the Employee", name = "employeeNumber", required = true)
  @Id
  @Column(name = "employeeNumber")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("employee_number")
  private Integer employeeNumber;

  @ApiModelProperty(name = "lastName", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "lastName")
  @JsonProperty("last_name")
  private String lastName;

  @ApiModelProperty(name = "firstName", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "firstName")
  @JsonProperty("first_name")
  private String firstName;

  @ApiModelProperty(name = "extension", required = true)
  @NotNull
  @Size(max = 10)
  @Column(name = "extension")
  @JsonProperty("extension")
  private String extension;

  @ApiModelProperty(name = "email", required = true)
  @NotNull
  @Size(max = 100)
  @Column(name = "email")
  @JsonProperty("email")
  private String email;

  @ApiModelProperty(name = "officeCode", required = true)
  @NotNull
  @Size(max = 10)
  @Column(name = "office_code")
  @JsonProperty("officeCode")
  private String officeCode;

  @ApiModelProperty(name = "reportsTo", required = false)
  @Size(max = 10)
  @Column(name = "reportsTo")
  @JsonProperty("reports_to")
  private Integer reportsTo;

  @ApiModelProperty(name = "jobTitle", required = true)
  @NotNull
  @Size(max = 50)
  @Column(name = "jobTitle")
  @JsonProperty("job_title")
  private String jobTitle;

}
