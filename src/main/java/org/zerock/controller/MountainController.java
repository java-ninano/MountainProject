
package org.zerock.controller;




import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Mountain.Mcriteria;
import org.zerock.domain.Mountain.MountainVO;
import org.zerock.service.mountain.MountainService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class MountainController {

	private MountainService service;
	
	// 산 등록
	@PostMapping("/register")
	public String register(MountainVO mountain,RedirectAttributes rttr) {
		
		service.register(mountain);
		
		log.info("register POST...");
	    
		//등록 성공시 
		rttr.addFlashAttribute("result",mountain.getNo());
		rttr.addFlashAttribute("message", mountain.getNo() + "글 등록 성공!");
		
		/*
		//등록 실패시
		 // redirect --> 사용자가 한번 더 요청 -->request 공유X 
		// string --> 같은 요청으로 request 안에 든 객체 공유
			
		boolean result = false;
		
	   if(result) {
		  
		  return "/board/register";
	    }
		
			
		
		*/
		
	
		//등록이 끝난 후 목록으로
		return "redirect:/board/list";
	}
	
	// 산등록
	@GetMapping("/register")
	public void register(@ModelAttribute("mcri") Mcriteria mcri) {
		
	}

	// 산 리스트
	@GetMapping("/list")
	public void list(Mcriteria mcri, Model model) {
		List<MountainVO> list = service.getList(mcri);
		
		log.info("list");
		
		model.addAttribute("list", list);
		
		
	}
	
	// 산 조회 
	@GetMapping("/get")
	public void get(Long no, Model model) {
		log.info("/get");
		model.addAttribute("mountain", service.get(no));
	}
	/*
	// 산 수정
	@GetMapping("/modify")
		public void modify(Long no, Model model) {
		    MountainVO vo = service.get(no);
		    model.addAttribute("mountain", vo);
		
		}
	
	
	// 수정& 삭제 같이
	@GetMapping({"/get", "/modify"})
	public void get(Long no, Mcriteria mcri,  Model model) {
		
		log.info("/get or modify");
		
		MountainVO vo =service.get(no);
		//service.get(no)
		model.addAttribute("board", vo );
	}
	
	// 산 수정(post)
	@PostMapping("/modify")
	public String modify(MountainVO mountain, Mcriteria mcri,  RedirectAttributes rttr) {
		log.info("modify:" + mountain);
		
		if(service.modify(mountain)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", mountain.getNo() +"수정 완료");
		}
		
		rttr.addAttribute("pageNum", mcri.getPageNum());
		rttr.addAttribute("amount", mcri.getAmount());
		rttr.addAttribute("type", mcri.getType());
		rttr.addAttribute("keyword", mcri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify2")
	public String modify2(MountainVO mountain, RedirectAttributes rttr) {
		
		if (service.modify(mountain)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("no", mountain.getNo());
			rttr.addAttribute("a", "a");
			rttr.addFlashAttribute("b", "b");
		}
		
		return "redirect:/board/get";
	}
	
	
	
	// 산 삭제
	@PostMapping("/remove")
	public String remove(Long no,Mcriteria mcri, RedirectAttributes rttr) {
		
		if(service.remove(no) ) {
			rttr.addAttribute("result", "success");
			rttr.addFlashAttribute("message", no+ "삭제 완료");
			
		}
		
		rttr.addAttribute("pageNum", mcri.getPageNum());
		rttr.addAttribute("amount", mcri.getAmount());
		rttr.addAttribute("type", mcri.getType());
		rttr.addAttribute("keyword", mcri.getKeyword());
		
		return "redirect:/board/list ";
	}
*/
	
}
