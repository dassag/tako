package com.cloud.taco.Repository;

import com.cloud.taco.POJO.Order;

public interface OrderRepository {
	
	Order save(Order order);
}

