package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.mountain.MountainVO;
import org.zerock.service.mountain.MountainService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MountainServiceTests {

	@Setter(onMethod_ = {@Autowired })
	private MountainService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegiter() {
		MountainVO mountain = new MountainVO();
	    mountain.setMName("도봉산");
	    mountain.setMLoc("서울시 도봉구에서 경기도 의정부시, 양주시 장흥면까지 걸쳐있는 산");
	    mountain.setHeight(740);
	    mountain.setStatus(0);
	    
	    service.register(mountain);
	    
	    log.info("새로 등록된 산 정보는: "+ mountain.getNo());
		
	}
	
	@Test
	public void testGetList() {
		service.getList();
	}
	
	@Test
	public void testGet() {
		
		log.info(service.get(3L));
	}
   
	@Test
	public void testDelete() {
		log.info(service.remove(3L));
	}
    @Test
    public void testUpdate() {
    	MountainVO mountain = new MountainVO();
    	mountain.setMName("산 이름 수정.");
    	mountain.setMLoc("산 수정된 위치입니다.");
    	mountain.setHeight(350);
    	mountain.setStatus(0);
    	
    	service.register(mountain);
    	
    	MountainVO update = new MountainVO();
    	update.setNo(mountain.getNo());
    	update.setMName("수락산 입니다");
    	update.setMLoc("서울시 노원구에서 경기도 의정부시, 남양주시까지 걸쳐있는 산");
    	update.setHeight(683);
    	update.setStatus(0);
    	
    	assumeTrue(service.modify(update));
    	
    	MountainVO update2 = service.get(mountain.getNo());
    	
    	log.info("MODIFY RESULT: "+ service.modify(mountain));
    	
    	
    }
}
