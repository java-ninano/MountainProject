package org.zerock.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.restaurant.LikeVO;
import org.zerock.mapper.LikeMapper;
import org.zerock.service.like.LikeService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeServiceTests {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private LikeService service;

	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testInsertLike() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(110));
		like.setUserno(new Long(1));
		
		int before = mapper.getCount(like.getResno());
		log.info("************************ before : " + before);
		service.likeInsert(like);
		int after = mapper.getCount(like.getResno());
		log.info("************************ after : " + after);
		

		assertEquals(before+1, after);
	}
	
	@Test
	public void testLikeRemove() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(110));
		like.setUserno(new Long(3));

		service.likeInsert(like);
		
		boolean val = service.likeRemove(like.getUserno(), like.getResno());
		
		assertTrue(val);
	}
	
	@Test
	public void testGetLike() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(110));
		like.setUserno(new Long(2));

		service.likeInsert(like);
		
		int cnt = service.getLike(like.getUserno(), like.getResno());
		
		log.info("********************" +cnt+ "******************");
		
		assertNotEquals(cnt, 0);
	}
	
	@Test
	public void testGetDislike() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(110));
		like.setUserno(new Long(2));

		service.likeInsert(like);
		
		int cnt = service.getDislike(like.getUserno(), like.getResno());
		
		log.info("********************" +cnt+ "******************");
		
		assertEquals(cnt, 0);
	}
}
