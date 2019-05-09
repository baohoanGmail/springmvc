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
@Table(name = "boshop_push_notifications")
@Proxy(lazy = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class BoshopPushNotifications implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 2590185890978563588L;

  @ApiModelProperty(name = "id_push_notifications", required = true)
  @NotNull
  @Id
  @Column(name = "id_push_notifications")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("id_push_notifications")
  private Integer id;

  @ApiModelProperty(name = "push_notifications_token", required = true)
  @NotNull
  @Column(name = "push_notifications_token")
  @JsonProperty("push_notifications_token")
  private String token;
}
