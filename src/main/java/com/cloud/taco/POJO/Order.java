package com.cloud.taco.POJO;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import javax.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class Order {

  @NotBlank(message="name can not be blank")
  private String name;
  
  @NotBlank(message="street name can not be blank")
  private String street;
  
  @NotBlank(message="city name can not be blank")
  private String city;
  
  @NotBlank(message="state name can not be blank")
  private String state;
  
  @NotBlank(message="zipcode can not be blank")
  private String zip;
  
  @CreditCardNumber(message="enter a credit card number")
  private String ccNumber;
  
  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
          message="Must be formatted MM/YY")
  private String ccExpiration;
  
  @Digits(integer=3,fraction=0,message="invalid cvv")
  private String ccCVV;
  private long id;
  private Date createdAt;

}
