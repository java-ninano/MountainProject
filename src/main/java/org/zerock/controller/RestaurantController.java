package org.zerock.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.restaurant.AddressVO;
import org.zerock.domain.restaurant.LikeVO;
import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;
import org.zerock.domain.restaurant.RpageDTO;
import org.zerock.service.like.LikeService;
import org.zerock.service.restaurant.RestaurantService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/restaurant/*")
@AllArgsConstructor
@Log4j
public class RestaurantController {
	private RestaurantService service;
	private LikeService likeSvc;
	
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri") Rcriteria cri, HttpServletRequest req) {
		List<RestaurantVO> list = service.getList(cri);
		// userno 세션 가져오기 
	//	int userno = (authUser) req.getSession().getAttribute("authUser").getUserno(); 
		int total = service.getTotal(cri);
		RpageDTO dto = new RpageDTO(cri, total);

		model.addAttribute("list", list);
		model.addAttribute("page", dto);
		
	}
	
	@PostMapping("/register")
	public String register(RestaurantVO restaurant, RedirectAttributes rttr, AddressVO addr) throws Exception {
		// manager == 1 세션 가져오기
		// User authUser = (User) req.getSession().getAttribute("authUser"); 
		log.info("*************** m.name ***********" + restaurant.getMname() + "******************************");

		String address = addr.getAddress1() + " " + addr.getAddress2();
		log.info("**************************" + address + "******************************");
		restaurant.setRloc(address);
		log.info("**************************" + restaurant+ "******************************");
		service.register(restaurant);
		rttr.addFlashAttribute("result", restaurant.getNo());
		rttr.addFlashAttribute("message", "상호 " + restaurant.getNo() + "번 글이 등록되었습니다");
		
		return "redirect:/restaurant/list";
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Rcriteria cri) {
		
	}
	
	@GetMapping({"/modify"})
	public void get(Long no, Model model, @ModelAttribute("cri") Rcriteria cri) {
		RestaurantVO vo = service.read(no);
		log.info("********* modify get *************" + vo.getRloc() + "*******************");
		
		model.addAttribute("restaurant", vo);
	}
	
	@PostMapping("/remove")
	// manager 세션 가져오기
	public String remove(Long no, RedirectAttributes rttr, Rcriteria cri, HttpServletRequest req) throws Exception {
		
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", no + "번 글이 삭제되었습니다");
		}
		rttr.addAttribute("pageNo", cri.getPageNo());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/restaurant/list";
	}
	
	@PostMapping("/modify")
	// manager 세션 가져오기
	public String modify(RestaurantVO restaurant, RedirectAttributes rttr, Rcriteria cri, HttpServletRequest req, AddressVO addr) throws Exception {
		String address = addr.getAddress1() + ", " + addr.getAddress2();
		log.info(restaurant);
		log.info("****************    address   **********" + address + "******************************");
		restaurant.setRloc(address);
		
		if(service.modify(restaurant)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", restaurant.getNo() + "번 글이 수정되었습니다");
		}
		rttr.addAttribute("pageNo", cri.getPageNo());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/restaurant/list";
	}
	
	@ResponseBody
	@PostMapping(value = "/like", produces = "application/json")
	public String like(LikeVO like, HttpServletRequest req, RedirectAttributes rttr) {
		log.info("********* clickLike *****************" + req.getAttribute("likeno") + "******************************");
		log.info("********* clickDislike *****************" + req.getAttribute("dislikeno") + "******************************");
		log.info("********* resno *****************" + req.getAttribute("resno") + "******************************");
		log.info("********* userno *****************" + req.getAttribute("userno") + "******************************");

		int resLike = likeSvc.getLike(like.getUserno(), like.getResno());
		int resDislike = likeSvc.getDislike(like.getUserno(), like.getResno());

	       if(resLike >= 1 || resDislike >= 1) {
	            likeSvc.likeRemove(like.getUserno(), like.getResno());
	            likeSvc.likeInsert(like);
	            likeSvc.likeUpdate(like.getResno());
	        } else {
	        	 likeSvc.likeInsert(like);
		         likeSvc.likeUpdate(like.getResno());
	        }
	       
	       
	       if(like.getLikeno() == 1) {
	    		rttr.addAttribute("clicked_like", 1);
	       } else if(like.getDislikeno() == 1) {
	    		rttr.addAttribute("clicked_dislike", 1);
	       }
		
	   	return "redirect:/restaurant/list";
	}
	


}
