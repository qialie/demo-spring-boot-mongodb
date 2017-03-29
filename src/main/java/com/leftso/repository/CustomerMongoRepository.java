package com.leftso.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.leftso.entity.Customer;

/**
 * spring data提供接口方式实现简单的操作,通常适合简单的或者测试用
 * 
 * @author leftso
 *
 */
@Repository
public interface CustomerMongoRepository extends MongoRepository<Customer, String> {

	public Customer findByFirstName(String firstName);

	public List<Customer> findByLastName(String lastName);
}
