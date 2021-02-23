package org.zerock.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class VisitMapperTests {
		@Setter(onMethod_ = @Autowired)
		private VisitMapper mapper;
		
	@Test
	public void test() {
		assertNotNull(mapper);
	}

	@Test
	public void insert() {
		int cnt = mapper.insert();
		assertEquals(cnt, 1);
	}
	
	@Test
	public void getTotal() {
		int cnt = mapper.getTotal();
		assertNotEquals(cnt, 0);
	}
	
	@Test
	public void getToday() {
		int cnt = mapper.getToday();
		assertNotEquals(cnt, 0);
	}
}
