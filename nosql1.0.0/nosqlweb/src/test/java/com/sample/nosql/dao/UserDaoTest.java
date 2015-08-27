package com.sample.nosql.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.sample.nosql.dao.UserDao;
import com.sample.nosql.pojo.UserBO;

@ContextConfiguration(locations = "classpath:cxf-spring.xml")
public class UserDaoTest extends AbstractTestNGSpringContextTests {

	static final Logger LOG = LoggerFactory.getLogger(UserDaoTest.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	CassandraTemplate cassandraTemplate;
	
	@Test()
	public void testGetUser() throws Exception  {
		List<UserBO> userList=userDao.getUsers();
		System.out.println("Size of the user list :: "+ userList.size());
	}
	
	@Test()
	public void testGetUserByUserId() throws Exception  {
		UserBO userBo=userDao.getUser("jsmith");
		System.out.println("The details of the user :: "+ userBo.getFirstName()+" "+userBo.getLastName());
	}
	
	@Test()
	public void testUpdate() throws Exception  {
		UserBO userBo=new UserBO();
		userBo.setAge(121);
		userBo.setUser_Id("jsmith");
		userBo.setFirstName("Jane");
		userBo=userDao.updateUser(userBo);
		System.out.println("The details of the user :: "+ userBo.getFirstName()+" "+userBo.getLastName());
	}
	@Test()
	public void testInsertUsers() throws Exception  {
		UserBO userBo=new UserBO();
		userBo.setAge(10);
		userBo.setFirstName("Jack");
		userBo.setLastName("Doe");
		userBo.setUser_Id("jDoe");
		userBo=userDao.insertUsers(userBo);
		System.out.println("The details of the user :: "+ userBo.getFirstName()+" "+userBo.getLastName());
	}
	
	@Test()
	public void testDeleteUsers() throws Exception  {
		UserBO userBo=new UserBO();
		userBo.setUser_Id("jDoe");
		userDao.deleteUsers(userBo);
		System.out.println("The details of the user :: "+ userBo.getFirstName()+" "+userBo.getLastName());
	}
}