package com.drapala.jpademo.repository;

import com.drapala.jpademo.JpaDemoApplication;
import com.drapala.jpademo.entity.Course;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaDemoApplication.class)
public class CourseRepositoryTest {


	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;


	@Test
	public void findById_basic() {
		Course course = repository.findById(10002L);
		assertEquals("Spring in 50 Steps", course.getName());
	}

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void save_basic() {

		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		course.setName("JPA in 50 Steps - Updated");

		repository.save(course);


		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {

		repository.playWithEntityManager();


	}


}
