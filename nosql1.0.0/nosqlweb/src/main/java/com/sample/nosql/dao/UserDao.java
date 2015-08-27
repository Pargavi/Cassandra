package com.sample.nosql.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.sample.nosql.pojo.UserBO;

@Repository
public class UserDao {
	
	@Autowired
	CassandraTemplate cassandraTemplate;

	static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

	public List<UserBO> getUsers() throws Exception {
		Select query = QueryBuilder.select().from("users");
		return cassandraTemplate.select(query, UserBO.class);
	}

	public UserBO getUser(String userId) throws Exception {
		Select query = QueryBuilder.select().from("users");
		query.where(QueryBuilder.eq("user_id", userId));
		//query.where(QueryBuilder.eq("user_id",userId)).and(QueryBuilder.eq("isActive", String.valueOf('Y')));
		UserBO userBo = cassandraTemplate.selectOne(query, UserBO.class);
		return userBo;
	}

	public UserBO insertUsers(UserBO userBo) throws Exception {
		try {
			userBo = cassandraTemplate.insert(userBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBo;
	}

	public UserBO updateUser(UserBO userBo) throws Exception {
		try {
			return cassandraTemplate.update(userBo);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteUsers(UserBO userBo) {
		try {
			cassandraTemplate.delete(userBo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
