package org.zerock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;
import org.zerock.mapper.RestaurantMapper;
import org.zerock.service.restaurant.RestaurantService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RestaurantSrviceTests {
	@Setter(onMethod_ = @Autowired)
	private RestaurantMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private RestaurantService service;
	
	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(4L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 중랑구");
		
		int before = mapper.getList().size();
		service.register(res);
		int after = mapper.getList().size();
		
		assertEquals(before+1, after);
	}
	
	@Test
	public void testGetList() {
		Rcriteria cri = new Rcriteria();
		List<RestaurantVO> list = service.getList(cri);
		
		assertNotNull(list);
		assertNotEquals(list.size(), 0);
		assertEquals(list.size(), 5);
	}
	
	@Test
	public void testRead() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(4L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 중랑구");
		service.register(res);
		
		RestaurantVO readRes = service.read(res.getNo());
		assertNotNull(readRes);
		assertEquals(readRes.getNo(), res.getNo());
	}
	
	@Test
	public void tesDelete() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(4L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 중랑구");
		service.register(res);
		
		assertTrue(service.remove(res.getNo()));
	}

	@Test
	public void tesUpdate() {
		RestaurantVO res = new RestaurantVO();
		res.setMountain_no(4L);
		res.setContact("02-987-6543");
		res.setDescription("맛집입니다");
		res.setMenu("닭볶음탕");
		res.setRname("도리도리");
		res.setRloc("서울시 중랑구");
		service.register(res);
		
		RestaurantVO updateRes = new RestaurantVO();
		updateRes.setNo(res.getNo());
		updateRes.setContact("02-987-0000");
		updateRes.setDescription("수-맛집입니다-정");
		updateRes.setMenu("수-닭볶음탕-정");
		updateRes.setRname("수-도리도리-정");
		updateRes.setRloc("서울시 구로구");
	
		assertTrue(service.modify(updateRes));
		
		RestaurantVO up2 = service.read(res.getNo());
		assertEquals("02-987-0000", up2.getContact());
		assertEquals("수-맛집입니다-정", up2.getDescription());
		assertEquals("수-닭볶음탕-정", up2.getMenu());
		assertEquals("수-도리도리-정", up2.getRname());
		assertEquals("서울시 구로구", up2.getRloc());
	}
}
