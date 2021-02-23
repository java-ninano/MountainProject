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
import org.zerock.domain.place.Pcriteria;
import org.zerock.domain.place.PlaceVO;
import org.zerock.mapper.PlaceMapper;
import org.zerock.service.place.PlaceService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PlaceSrviceTests {
	@Setter(onMethod_ = @Autowired)
	private PlaceMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private PlaceService service;
	
	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		
		int before = mapper.getList().size();
		service.register(vo);
		int after = mapper.getList().size();
		
		assertEquals(before+1, after);
	}
	
	@Test
	public void testRead() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		service.register(vo);
		
		PlaceVO pvo= service.read(vo.getNo());
		assertNotNull(pvo);
		assertEquals(pvo.getNo(), vo.getNo());
	}
	
	@Test
	public void tesDelete() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		service.register(vo);
		
		assertTrue(service.remove(vo.getNo()));
	}

	@Test
	public void tesUpdate() {
		PlaceVO vo = new PlaceVO();
		vo.setMountain_no(1L);
		vo.setPname("바위바위");
		vo.setPloc("산 중턱!");
		vo.setDescription("예쁜 바위");
		vo.setFilename("filename1");
		service.register(vo);
		
		PlaceVO upvo = new PlaceVO();
		upvo.setNo(vo.getNo());
		upvo.setMountain_no(1L);
		upvo.setPname("바위바위 수정");
		upvo.setPloc("산 중턱! 수정");
		upvo.setDescription("예쁜 바위 수정");
		upvo.setFilename("filename1 수정");
	
		assertTrue(service.modify(upvo));
		
		PlaceVO upvo2 = service.read(vo.getNo());
		assertEquals("바위바위 수정", upvo2.getPname());
		assertEquals("산 중턱! 수정", upvo2.getPloc());
		assertEquals("예쁜 바위 수정", upvo2.getDescription());
		assertEquals("filename1 수정", upvo2.getFilename());
	}
}
