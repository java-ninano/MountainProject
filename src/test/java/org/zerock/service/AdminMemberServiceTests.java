package org.zerock.service;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.admin.Acriteria;
import org.zerock.domain.admin.AdminMemberVO;
import org.zerock.service.admin.AdminMemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminMemberServiceTests {

	@Setter(onMethod_ = @Autowired)
	private AdminMemberService memberSvc;
	
	@Test
	public void test() {
		assertNotNull(memberSvc);
	}

	@Test
	public void getList() {
		Acriteria cri = new Acriteria(1, 10);
		List<AdminMemberVO> list = memberSvc.getList(cri);
		assertNotEquals(list.size(), 0);
	}
	
	@Test
	public void getTotal() {
		Acriteria cri = new Acriteria(1, 5);
		List<AdminMemberVO> list = memberSvc.getList(cri);
		assertNotEquals(list.size(), 0);
	}
}
