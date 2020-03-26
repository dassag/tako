package com.cloud.taco;


import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import lombok.Data;

@SuppressWarnings({ "unused", "deprecation" })
@Data
public class Order {

  private String name;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String ccNumber;
  private String ccExpiration;
  private String ccCVV;
  private long id;
  private Date createdAt;

}
