package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.festival.FestivalVO;
import org.zerock.domain.mountain.MountainVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FestivalMapperTests {

	@Setter(onMethod_ =@Autowired )
	private FestivalMapper mapper;
	
	//게시글 list 가져오기
	@Test
	public void testGetList() {
		List<FestivalVO> list =mapper.getList();
		//values should be different actual 0
		assertNotEquals(list.size(), 1);
	}
	
	//게시글 작성
	@Test
	public void testInsert() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insert(festival);
		
	
		log.info(festival);
		
	}
	
	//게시글 InsertSelect(seletkey -->insert)
	@Test
	public void testInsertSelectKey() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		int before = mapper.getList().size();
		
		mapper.insertSelectKey(festival);
		
		int after = mapper.getList().size();
		
		assertEquals(before+1,after);
		
	}
	
	@Test
	public void testRead() {
		/*
		FestivalVO festival = new FestivalVO();
		festival.setEname("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		
		mapper.insertSelectKey(festival);
		
		FestivalVO readfestival = mapper.read(festival.getNo());
	*/
		
		FestivalVO festival = mapper.read(71);
		
		log.info(festival);
	}
	
	@Test
	public void testDelete() {
		/*
		FestivalVO festival = new FestivalVO();
		festival.setEname("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insertSelectKey(festival);
		
		//int cnt = mapper.delete(festival.getNo());
		Long no =297L;
		mapper.delete(no);
		*/
		
	log.info("delete count: " +mapper.delete(11));
	}
	
	@Test
	public void testUpdate() {
		FestivalVO festival = new FestivalVO();
		festival.setEname("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		FestivalVO update = new FestivalVO();
		update.setNo(13);
		update.setDescription("새로고침");
		update.setMonth(8);
		update.setMountain_no(61);
	
	}
	
	
}
