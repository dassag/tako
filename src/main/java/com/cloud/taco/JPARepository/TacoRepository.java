package com.cloud.taco.JPARepository;

import org.springframework.data.repository.CrudRepository;

import com.cloud.taco.POJO.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {

}
