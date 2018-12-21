package com.drapala.jpademo.repository;

import com.drapala.jpademo.JpaDemoApplication;
import com.drapala.jpademo.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class JPQLTest {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;


	@Test
	public void jpql_basic() {
		List resultList = em.createQuery("SELECT c FROM Course c").getResultList();
		logger.info("SELECT c FROM Course c -> {}", resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query =
				em.createQuery("SELECT c FROM Course c", Course.class);
		List <Course> resultList = query.getResultList();
		logger.info("SELECT c FROM Course c -> {}", resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query =
				em.createQuery("SELECT c FROM Course c WHERE name like '%100 Steps'", Course.class);
		List <Course> resultList = query.getResultList();
		logger.info("SELECT c FROM Course c WHERE name like '%100 Steps'-> {}", resultList);
	}





}
