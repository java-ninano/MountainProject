package org.zerock.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Mcriteria;
import org.zerock.domain.MountainVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class MountainMapperTests {

	@Setter(onMethod_ =@Autowired )
	private MountainMapper mapper;

	
	@Test
	public void testGetList() {
		List<MountainVO> list =mapper.getList();
		assertNotEquals(list.size(), 0);
		
		//mapper.getList().forEach(mountain -> log.info(mountain));
	}
	
	@Test
	public void testInsert() {
		MountainVO mountain = new MountainVO();
		mountain.setMName("새로운 산이걸랑요?. ");
		mountain.setMLoc("서울특별시입니다");
		mountain.setHeight(240);
		mountain.setStatus(0);
		
		int before =mapper.getList().size();
		
		mapper.insert(mountain);
		
		int after = mapper.getList().size();
		
		log.info(mountain);
		
		
	}

	@Test
	public void testInsertSelectKey() {
		MountainVO mountain = new MountainVO();
		mountain.setMName("새로운 산입니다2");
		mountain.setMLoc("서울시");
		mountain.setHeight(300);
		mountain.setStatus(1);

		int before = mapper.getList().size();
		
		mapper.insertSelectKey(mountain);
		
		int after=mapper.getList().size();

		log.info(mountain);
	}
	
	
	// 현재 테이블에 no값이 있는지 확인
	// 무결성 때문에 새로운값 입력
	@Test
	public void testRead() {
		MountainVO mountain = new MountainVO();
		mountain.setMName("새로운 산입니다3");
		mountain.setMLoc("서울시");
		mountain.setHeight(667);
		mountain.setStatus(0);
		
		mapper.insertSelectKey(mountain );
		
		MountainVO readMountain = mapper.read(mountain.getNo());
		
		assertEquals(readMountain.getNo(), 	mountain.getNo());
		
		log.info(mountain);
	}
	
	@Test
	public void testDelete() {
		MountainVO mountain = new MountainVO();
		mountain.setMName("새로운 산입니다3");
		mountain.setMLoc("서울시 ");
		mountain.setHeight(240);
		mountain.setStatus(0);
		
		mapper.insertSelectKey(mountain);
		
		int before = mapper.getList().size();
		
		int cnt = mapper.delete(mountain.getNo());
		
		int after = mapper.getList().size();
		
		log.info(mapper.delete(252L));
		
	}
	
	@Test
	public void testUpdate() {
	MountainVO mountain = new MountainVO();
	
	mountain.setNo(262L);
	 mountain.setMName("변경한 산이름이걸랑요");
	 mountain.setMLoc("서울시 관악구입니다");
	 mountain.setHeight(500);
	 mountain.setStatus(1);
	
	
	 mapper.insertSelectKey(mountain);
	 
	 /*mountain.setMName("새로운 산이걸랑요?");
	mountain.setMLoc("서울특별시입니다");
	mountain.setHeight(240);
	mountain.setStatus(0);
	*/
	 
	 /*
	 mountain.setMName("변경한 산이름이지요");
	 mountain.setMLoc("서울시 관악");
	 mountain.setHeight(500);
	 mountain.setStatus(1);
	 */
	 int cnt = mapper.update(mountain);
	 
	 MountainVO updateVO = mapper.read(mountain.getNo());
	
	log.info("UPDATE COUNT:" + cnt);
	

	}
	// 페이지
	@Test
	public void testPaging() {
		Mcriteria mcri = new Mcriteria(1, 5);
		
		List<MountainVO> list = mapper.getListWithPaging(mcri);
		
	
		
		mcri = new Mcriteria(1, 10);
		
		list = mapper.getListWithPaging(mcri);
		
	
		mcri = new Mcriteria(2, 5);
		
		list = mapper.getListWithPaging(mcri);
		
		list.forEach(mountain -> log.info("번호:" + mountain.getNo()));
	}
	

}
