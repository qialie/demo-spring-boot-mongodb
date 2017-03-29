package com.leftso.repository;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.leftso.entity.Customer;

/**
 * 自定义数据存储方式
 * 
 * @author leftso
 *
 */
@Repository
public class CustomizeCustomerMongoRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	/**
	 * 保存一个对象
	 * 
	 * @return
	 */
	public Customer save(Customer customer) {
		mongoTemplate.save(customer);
		return customer;
	}

	/**
	 * 删除所有
	 */
	public void deleteAll() {
		mongoTemplate.dropCollection(Customer.class);
	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	public List<Customer> findAll() {
		return mongoTemplate.findAll(Customer.class);
	}

	/**
	 * 精确查询
	 * 
	 * @param firstName
	 * @return
	 */
	public List<Customer> findByFirstName(String firstName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("firstName").is(firstName));

		return mongoTemplate.find(query, Customer.class);
	}

	/**
	 * 模糊查询不区分大小写
	 * 
	 * @param lastName
	 * @return
	 */
	public List<Customer> findByLastName(String lastName) {
		Query query = new Query();
		Pattern pattern = Pattern.compile("^.*" + lastName + ".*$", Pattern.CASE_INSENSITIVE);// Pattern.CASE_INSENSITIVE不区分大小写
		query.addCriteria(Criteria.where("lastName").regex(pattern));
		return mongoTemplate.find(query, Customer.class);
	}

}
