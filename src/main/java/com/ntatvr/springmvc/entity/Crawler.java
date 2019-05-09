package com.ntatvr.springmvc.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "crawler")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Crawler implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 2590185890978563588L;

  @ApiModelProperty(name = "id", required = true)
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id")
  private Integer id;

  @ApiModelProperty(name = "uri", required = true)
  @NotNull
  @Column(name = "uri")
  @JsonProperty("uri")
  private String uri;

  @ApiModelProperty(name = "title", required = true)
  @NotNull
  @Column(name = "title")
  @JsonProperty("title")
  private String title;

  @ApiModelProperty(name = "image", required = false)
  @Column(name = "image")
  @JsonProperty("image")
  private String image;

  @ApiModelProperty(name = "reader", required = true)
  @NotNull
  @Column(name = "reader")
  @JsonProperty("reader")
  private String reader;

  @ApiModelProperty(name = "reply", required = false)
  @Column(name = "reply")
  @JsonProperty("reply")
  private String reply;

  @ApiModelProperty(name = "createdDate", required = false)
  @Column(name = "createdDate")
  @JsonProperty("created_date")
  private Date createdDate;

  @ApiModelProperty(name = "updatedDate", required = false)
  @Column(name = "updatedDate")
  @JsonProperty("updated_date")
  private Date updatedDate;

  @ApiModelProperty(name = "isActive", required = true)
  @NotNull
  @Column(name = "isActive")
  @JsonProperty("is_active")
  private Integer isActive = 1;
}
