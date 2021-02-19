package org.zerock.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.festival.FestivalVO;
import org.zerock.mapper.FestivalMapper;
import org.zerock.service.festival.FestivalService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FestivalServiceTests {

	@Setter(onMethod_ = @Autowired )
	private FestivalService service;
	
	@Setter(onMethod_ =@Autowired )
	private FestivalMapper mapper;
	
	@Test
	public void testExist() {
		log.info(service);
	}
	
	@Test
	public void testRegister() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("북한산 효 축제");
		festival.setDescription("북한산과 아웃도어를 테마로 시작된 축제로 한옥마을과 북한산성 마을 일대에서 "
				+ "북한산 한문화를 체험할 수 있는 축제이다.    ");
		festival.setMonth(9);
		festival.setMountain_no(291);
		
		service.register(festival);
		
		log.info("새로 등록된 산 축제는: " + festival.getNo());
	}
	
	@Test
	public void testGetList() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("북한산 효 축제");
		festival.setDescription("북한산과 아웃도어를 테마로 시작된 축제로 한옥마을과 북한산성 마을 일대에서 "
				+ "북한산 한문화를 체험할 수 있는 축제이다.    ");
		festival.setMonth(9);
		festival.setMountain_no(291);
		
		service.register(festival);
		
		List<FestivalVO> list = service.getList();
	}
	
	@Test
	public void testDelete() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("북한산 효 축제");
		festival.setDescription("북한산과 아웃도어를 테마로 시작된 축제로 한옥마을과 북한산성 마을 일대에서 "
				+ "북한산 한문화를 체험할 수 있는 축제이다.    ");
		festival.setMonth(9);
		festival.setMountain_no(291);
		
		service.register(festival);
		
		assertTrue(service.remove(festival.getNo()));
		
		log.info(festival);
		
	}
	
	@Test
	public void testUpdate() {
		FestivalVO vo = new FestivalVO();
		vo.setEname("북한산 효 축제");
		vo.setDescription("북한산과 아웃도어를 테마로 시작된 축제로 한옥마을과 북한산성 마을 일대에서 "
				+ "북한산 한문화를 체험할 수 있는 축제이다");
		vo.setMonth(9);
		vo.setMountain_no(291);
		service.register(vo);
		
		FestivalVO update = mapper.read(vo.getNo());
		assertEquals("관악산 철쭉제", update.getEname());
		assertEquals("강감찬 장군의 역사 속 업적을 기리는 관악구 축제", update.getDescription());
		assertEquals(5, update.setMonth());
		update.setMountain_no(61);
		update.setNo(11);
		
		assertTrue(service.modify(update));
		
		log.info("MODIFY RESULT: "+ service.modify(vo));
	
		
	}
}
