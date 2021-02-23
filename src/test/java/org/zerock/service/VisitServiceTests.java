package org.zerock.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.service.visit.VisitService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class VisitServiceTests {
		@Setter(onMethod_ = @Autowired)
		private VisitService service;
		
	@Test
	public void test() {
		assertNotNull(service);
	}

	@Test
	public void insert() {
		assertTrue(service.insert());
	}
	
	@Test
	public void getTotal() {
		int cnt = service.getTotal();
		log.info("******** total******"+cnt);
		assertNotEquals(cnt, 0);
	}
	
	@Test
	public void getToday() {
		int cnt = service.getToday();
		log.info("******** today******"+cnt);
		assertNotEquals(cnt, 0);
	}
}
