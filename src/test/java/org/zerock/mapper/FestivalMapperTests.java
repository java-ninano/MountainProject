package org.zerock.mapper;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.festival.FestivalVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FestivalMapperTests {

	@Setter(onMethod_ =@Autowired )
	private FestivalMapper mapper;
	
	//전체 목록 가져오기
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
		festival.setEName("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		int before=mapper.getList().size();
		
		mapper.insert(festival);
		
		int after=mapper.getList().size();
		
		log.info(festival);
		
	}
	
	//게시글 InsertSelect(seletkey -->insert)
	@Test
	public void testInsertSelectKey() {
		FestivalVO festival = new FestivalVO();
		festival.setEName("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insertSelectKey(festival);
		
		int after = mapper.getList().size();
		
	}
	
	@Test
	public void testRead() {
		FestivalVO festival = new FestivalVO();
		festival.setEName("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insertSelectKey(festival);
		
		FestivalVO readfestival = mapper.read(festival.getNo());
	
		
	}
	
	@Test
	public void testDelete() {
		FestivalVO festival = new FestivalVO();
		festival.setEName("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insertSelectKey(festival);
		
		int cnt = mapper.delete(festival.getNo());
		
		log.info(cnt);
	}
	
	@Test
	public void testUpdate() {
		FestivalVO festival = new FestivalVO();
		festival.setEName("아차산 해맞이 축제");
		festival.setDescription("아차산의 해맞이 축제는 서울에서 가장 먼저 해가 뜨는곳으로 일출을 서울에서 가장 먼저 볼 수 있으며, "
				+ "신규행사로 느린우체통 행사, 드론비행 행사 등이 있습니다. ");
		festival.setMonth(1);
		festival.setMountain_no(297);
		
		mapper.insertSelectKey(festival);
		
		festival.setEName("도봉산 산사 축제");
		festival.setDescription("도봉산의 특성을 잘 살린 솔바람 가요제, 산사음악회와 사찰음식전, "
				+ "구민등산대회 등 구민들의 참여로 다채로운 행사가 펼쳐진다");
		festival.setMonth(10);
		festival.setMountain_no(41);
		
		int cnt =mapper.update(festival);
		
		FestivalVO updateVO=mapper.read(festival.getNo());
			
	}
	
	
	
}
