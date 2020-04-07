package com.cloud.taco.JPARepository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.taco.POJO.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
