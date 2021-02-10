package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantMapperTests {
	@Setter(onMethod_ = @Autowired)
	private RestaurantMapper mapper;
	
	@Test // 성공
	public void testGetList() {
		List<RestaurantVO> list = mapper.getList();
		assertNotEquals(list.size(), 0);
	}
	
	@Test // 성공
	public void testInsertSelectKey() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(2L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다!!!!!!!");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 종로구");
		int before = mapper.getList().size();
		mapper.insertSelectKey(res);
		int after = mapper.getList().size();
		
		assertEquals(before+1, after);
		assertNotEquals(res.getNo(), new Long(0));
	}

	@Test // 성공
	public void testDelete() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(2L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 종로구");
		
		mapper.insertSelectKey(res);
		int before = mapper.getList().size();
		
		int cnt = mapper.delete(res.getNo());
		log.info("**********  cnt : " + cnt + "*****************");
		assertEquals(1, cnt);
		int after = mapper.getList().size();
		assertEquals(before - 1, after);
	}
	
	@Test // 성공
	public void testRead() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(2L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 종로구");
		
		mapper.insertSelectKey(res);
		RestaurantVO readRes = mapper.read(res.getNo());
		
		assertNotNull(readRes);
		assertEquals(readRes.getNo(), res.getNo());
	}
	
	@Test // 성공
	public void testUpdate() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(3L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 종로구");
		
		mapper.insertSelectKey(res);
		log.info("*******************" +res +"*****************");
		
		res.setContact("02-987-0000");
		res.setDescription("수정 맛집입니다");
		res.setMenu("수정 닭볶음탕");
		res.setRname("수정 도리도리");
		res.setRloc("서울시 종로구 수정");
		int cnt = mapper.update(res);
		assertEquals(1, cnt);
		
		RestaurantVO upRes = mapper.read(res.getNo());
		assertEquals("02-987-0000", upRes.getContact());
		assertEquals("수정 맛집입니다", upRes.getDescription());
		assertEquals("수정 닭볶음탕", upRes.getMenu());
		assertEquals("수정 도리도리", upRes.getRname());
		assertEquals("서울시 종로구 수정", upRes.getRloc());
	}

	@Test // 성공
	public void testPaging() {
		Rcriteria cri = new Rcriteria(1, 5);
		List<RestaurantVO> list = mapper.getListPaging(cri);
		
		assertEquals(5, list.size());
		
		cri = new Rcriteria(1, 10);
		list = mapper.getListPaging(cri);
		
		assertEquals(10, list.size());
		list.forEach(restaurant -> log.info("NUMBER : " + restaurant.getNo()));
	}
	
}
