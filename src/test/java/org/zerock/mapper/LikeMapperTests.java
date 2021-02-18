package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.restaurant.LikeVO;
import org.zerock.domain.restaurant.RestaurantVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LikeMapperTests {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private RestaurantMapper resMapper;
	//성공
	@Test
	public void testExist() {
		assertNotNull(mapper);
	}
	//성공
	@Test
	public void testInsert() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(109));
		like.setUserno(new Long(1));
		
		int before = mapper.getCount(new Long(109));
		log.info("************************ before : " + before);
		mapper.insertLike(like);
		int after = mapper.getCount(new Long(109));
		log.info("************************ after : " + after);
		

		assertEquals(before+1, after);
	}
	
	@Test
	public void testGetLike() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(109));
		like.setUserno(new Long(3));
		int val1 = mapper.getLike(like.getUserno(), like.getResno());
		mapper.insertLike(like);
		int val2 = mapper.getLike(like.getUserno(), like.getResno());
		
		assertEquals(val1+1, val2);
	}
	
	@Test
	public void testGetDislike() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(0));
		like.setDislikeno(new Long(1));
		like.setResno(new Long(109));
		like.setUserno(new Long(3));
		int val1 = mapper.getDislike(like.getUserno(), like.getResno());
		mapper.insertLike(like);
		int val2 = mapper.getDislike(like.getUserno(), like.getResno());
		assertEquals(val1+1, val2);
	}
	
	@Test
	public void testDelete() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(109));
		like.setUserno(new Long(5));
		mapper.insertLike(like);
		int before = mapper.getCount(like.getResno());
		log.info("************************ before : " + before);
		log.info("************************ like.getResno() : " + like.getResno());
		log.info("************************ like.getUserno() : " + like.getUserno());
		 mapper.deleteLike(like.getUserno(), like.getResno());
		int after = mapper.getCount(like.getResno());
		log.info("************************ after : " + after);
		
		assertEquals(before-1, after);
	}
	
	@Test
	public void testUpdate() {
		LikeVO like = new LikeVO();
		like.setLikeno(new Long(1));
		like.setDislikeno(new Long(0));
		like.setResno(new Long(109));
		like.setUserno(new Long(5));
		mapper.insertLike(like);
		
		mapper.updateLike(like.getResno());
		resMapper.read(like.getResno());
		
	}
}
