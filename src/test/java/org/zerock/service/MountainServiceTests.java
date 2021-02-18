package org.zerock.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Mountain.Mcriteria;
import org.zerock.domain.Mountain.MountainVO;
import org.zerock.mapper.MountainMapper;
import org.zerock.service.mountain.MountainService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MountainServiceTests {

	@Setter(onMethod_ = {@Autowired })
	private MountainService service;
	
	@Setter(onMethod_ = @Autowired )
	private MountainMapper mapper;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegiter() {
		MountainVO mountain = new MountainVO();
	    mountain.setMName("서울에 있는 산인뎁쇼");
	    mountain.setMLoc("서울시 도봉구에서 시작되어있는 산");
	    mountain.setHeight(640);
	    mountain.setStatus(0);
	    
	    int before = mapper.getList().size();
	    
	    service.register(mountain);
	    
	    int after = mapper.getList().size();
	    
	    log.info("새로 등록된 산 정보는: "+ mountain.getNo());
		
	}
	
	@Test
	public void testGetList() {
		Mcriteria mcri = new Mcriteria(2,10);
		List<MountainVO> list = service.getList(mcri);
		
	
		assertNotNull(service);
		
		log.info(mcri);
	}
	
	@Test
	public void testGet() {
		MountainVO mountain = new MountainVO();
		mountain.setMName("새로 입력하는 산");
		mountain.setMLoc("seoul");
		mountain.setHeight(180);
		mountain.setStatus(0);
		
		service.register(mountain);
		
		MountainVO m = service.get(mountain.getNo());
		
		log.info(m);
	}
     
	@Test
	public void testDelete() {
	/*
		MountainVO mountain = new MountainVO();
	    mountain.setMName("서울에 있는 산인뎁쇼");
	    mountain.setMLoc("서울시 도봉구에서 시작되어있는 산");
	    mountain.setHeight(640);
	    mountain.setStatus(0);
	   
	    
	    service.register(mountain);
	    
		assertTrue(service.remove(mountain.getNo()));
		*/
		
		log.info("remove result: "+ service.remove(181L));
	}
	
	
	
    @Test
    public void testUpdate() {
    	MountainVO mountain = new MountainVO();
    	mountain.setMName("헤벨레산입니다요");
    	mountain.setMLoc("서울시 마포구");
    	mountain.setHeight(903);
    	mountain.setStatus(0);
    	
    	service.register(mountain);
    	
    	MountainVO update = new MountainVO();
    	update.setNo(mountain.getNo());
    	update.setMName("헤벌레벌쭉산");
    	update.setMLoc("서울시 마포구에서 시작되는 산");
    	update.setHeight(833);
    	update.setStatus(0);
    	
    	assumeTrue(service.modify(update));
    	
    	MountainVO update2 = service.get(mountain.getNo());
    	
    	log.info("MODIFY RESULT: "+ service.modify(mountain));
    	
    	
    }
 
}
