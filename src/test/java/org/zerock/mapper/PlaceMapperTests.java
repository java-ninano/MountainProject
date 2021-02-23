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
import org.zerock.domain.place.PlaceVO;
import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PlaceMapperTests {
	@Setter(onMethod_ = @Autowired)
	private PlaceMapper mapper;
	
	@Test // 성공
	public void test() {
		assertNotNull(mapper);
	}
	
	@Test // 성공
	public void testGetList() {
		List<PlaceVO> list = mapper.getList();
		assertNotEquals(list.size(), 0);
	}
	
	@Test // 성공
	public void testInsertSelectKey() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		int before = mapper.getList().size();
		mapper.insertSelectKey(vo);
		int after = mapper.getList().size();
		
		assertEquals(before+1, after);
		assertNotEquals(vo.getNo(), new Long(0));
	}

	@Test // 성공
	public void testDelete() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		
		mapper.insertSelectKey(vo);
		int before = mapper.getList().size();
		
		int cnt = mapper.delete(vo.getNo());
		log.info("**********  cnt : " + cnt + "*****************");
		assertEquals(1, cnt);
		int after = mapper.getList().size();
		assertEquals(before - 1, after);
	}
	
	@Test // 성공
	public void testRead() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		
		mapper.insertSelectKey(vo);
		PlaceVO pvo = mapper.read(vo.getNo());
		
		assertNotNull(pvo);
		assertEquals(pvo.getNo(), vo.getNo());
	}
	
	@Test // 성공
	public void testUpdate() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		
		mapper.insertSelectKey(vo);
		
		vo.setMountain_no(2L);
		vo.setPname("바위바위 수정");
		vo.setPloc("산 중턱! 수정");
		vo.setDescription("예쁜 바위 수정");
		vo.setFilename("filename1 수정");
		int cnt = mapper.update(vo);
		assertEquals(1, cnt);
		
		PlaceVO upVO = mapper.read(vo.getNo());
		assertEquals("바위바위 수정", upVO.getPname());
		assertEquals("산 중턱! 수정", upVO.getPloc());
		assertEquals("예쁜 바위 수정", upVO.getDescription());
		assertEquals("filename1 수정", upVO.getFilename());
	}
	
}
