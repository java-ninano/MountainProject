package org.zerock.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.restaurant.RestaurantVO;
import org.zerock.mapper.RestaurantMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class RestaurantControllerTests {
	@Setter(onMethod_ = @Autowired)
	private RestaurantMapper mapper;
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void test() {
		assertNotNull(ctx);
		assertNotNull(mockMvc);
	}

	@Test
	public void testList() throws Exception {
		ResultActions res = mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/list"));
		MvcResult rs = res.andReturn();
		ModelAndView mv = rs.getModelAndView();

		log.info("*************" + mv.getView() + "**************");
		log.info("*************" + mv.getModel().get("list") + "**************");

		Object o = mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/list")).andReturn().getModelAndView()
				.getModel().get("list");

		assertNotNull(o);
		assertTrue(o instanceof List);
		assertNotEquals(((List) o).size(), 0);
	}

	@Test
	public void testRegister() throws Exception {
		int before = mapper.getList().size();

		MvcResult rs = mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/register").param("rName", "이삭토스트")
				.param("mountain_no", "5").param("rLoc", "서울시 금천구").param("contact", "02-3333-5555")
				.param("menu", "햄치즈토스트").param("description", "든든하고 맛있어요!!!")).andReturn();
		ModelAndView mv = rs.getModelAndView();
		FlashMap map = rs.getFlashMap();

		int after = mapper.getList().size();

		assertEquals(before + 1, after);
		assertEquals("redirect:/restaurant/list", mv.getViewName());
		assertNotNull(map.get("result"));
		log.info("*************" + map.get("result") + "*************");
	}
	
	@Test
	public void testListPaging() throws Exception {
		MvcResult rs = mockMvc.perform(MockMvcRequestBuilders.get("/restaurant/list").param("pageNo", "3").param("amount", "5")).andReturn();
		Map<String, Object> model = rs.getModelAndView().getModel();
		List list = (List) model.get("list");
		
		assertEquals(5, list.size());
	}
	
	@Test
	public void testRemove() throws Exception {
		RestaurantVO vo = new RestaurantVO();
		vo.setContact("02-3333-4444");
		vo.setDescription("맛있습니다!!!!!!!!!!");
		vo.setMenu("순대국");
		vo.setMountain_no(6L);
		vo.setRloc("서울시 마포구");
		vo.setRname("원조 순대국집");
		
		mapper.insertSelectKey(vo);
		Long key = vo.getNo();
		
		int before = mapper.getList().size();
		MvcResult rs = mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/remove").param("no", key+"")).andReturn();
		int after = mapper.getList().size();
		
		FlashMap map = rs.getFlashMap();
		String viewName = rs.getModelAndView().getViewName();
		
		assertEquals(before-1, after);
		assertEquals("success", map.get("result"));
		assertEquals("redirect:/restaurant/list", viewName);
	}
	
	@Test
	public void testModify() throws Exception {
		RestaurantVO vo = new RestaurantVO();
		vo.setContact("02-3333-4444");
		vo.setDescription("맛있습니다!!!!!!!!!!");
		vo.setMenu("순대국");
		vo.setMountain_no(6L);
		vo.setRloc("서울시 마포구");
		vo.setRname("원조 순대국집");
		
		mapper.insertSelectKey(vo);
		Long key = vo.getNo();
		MvcResult rs = mockMvc.perform(MockMvcRequestBuilders.post("/restaurant/modify").param("no", key+"").param("rName", "이삭토스트")
				.param("mountain_no", "5").param("rLoc", "서울시 금천구").param("contact", "02-3333-5555")
				.param("menu", "햄치즈토스트").param("description", "든든하고 맛있어요!!!")).andReturn();
		FlashMap map = rs.getFlashMap();
		String viewName = rs.getModelAndView().getViewName();
		RestaurantVO up = mapper.read(key);
		
		
		assertEquals("이삭토스트", up.getRname());
		// assertEquals("5", up.getMountain_no());
		assertEquals("서울시 금천구", up.getRloc());
		assertEquals("02-3333-5555", up.getContact());
		assertEquals("햄치즈토스트", up.getMenu());
		assertEquals("든든하고 맛있어요!!!", up.getDescription());
		assertEquals("success", map.get("result"));
		assertEquals("redirect:/restaurant/list", viewName);
	}
}
