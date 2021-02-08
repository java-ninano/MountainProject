package org.zerock.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.MountainVO;
import org.zerock.domain.PageDTO;
import org.zerock.service.MountainService;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@RequestMapping("/*")
@Log4j
public class MountainController {

	private MountainService service;
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri")Criteria cri, Model model) {
		List<MountainVO> list = service.getList(cri);
		
		int total = service.getTotal(cri);
		
        PageDTO dto = new PageDTO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", dto);
		
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri")Criteria cri) {
		
	}
	
	@PostMapping("/register")
	public void register(MountainVO mountain, RedirectAttributes rttr) {
		
		service.register(mountain);
		
		rttr.addFlashAttribute("result", mountain.getNo());
		rttr.addFlashAttribute("message", mountain.getNo() + "번 산 정보가 등록되었습니다.");
		
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(Long no, 
			@ModelAttribute("cri")Criteria cri, Model model) {
		
		log.info("get method - no: " + no);
		log.info(cri);
		 MountainVO vo = service.get(no);
		 model.addAttribute("mountain", vo);
	}
	
	@PostMapping("/modify")
	public void modify(MountainVO mountain, Criteria cri, RedirectAttributes rttr) {
		if(service.modify(mountain)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", mountain.getNo() + "번 산 정보가 수정되었습니다.");
			
		}
		log.info(cri);
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		
	}
	
	@PostMapping("/modify2")
	public void modify2(MountainVO mountain, RedirectAttributes rttr) {
		if(service.modify(mountain)) {
			rttr.addFlashAttribute("result","success");
			rttr.addAttribute("no", mountain.getNo());
			rttr.addAttribute("a", "a");
			rttr.addFlashAttribute("b", "b");
		}
		
	}
	
	@PostMapping("/remove")
	public void remove(Long no,
			Criteria cri, RedirectAttributes rttr) {
		
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", no +"번 산 정보가 삭제되었습니다.");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());

		
	}
	
	
}
