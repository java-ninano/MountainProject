package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.festival.Fcriteria;
import org.zerock.domain.festival.FestivalVO;
import org.zerock.domain.festival.FpageDTO;
import org.zerock.service.festival.FestivalService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/festival/*")
@AllArgsConstructor
@Log4j
public class FestivalController {

	private FestivalService service;
	
	// 등록
	@PostMapping("/register")
	public String register(FestivalVO festival, RedirectAttributes rttr, Model model,MultipartFile file) {
		//  RedirectAttributes에서 제공하는 메소드: addFlashAttribute() -> 리다이렉트 이후 소멸
		service.register(festival);
		/*
		//FileUpload
        if(file !=null) {
		   festival.setFilename(festival.getNo() +"_" +file.getOriginalFilename());
		   service.modify(festival);
		   fileUpSvc.write(file, festival.getFilename());
        }
		*/
		rttr.addFlashAttribute("result", festival.getNo());
		rttr.addFlashAttribute("message", festival.getNo() + "등록 완료!");
		
		return "redirect:/festival/list";
	}
	
	@GetMapping("/register")
	public void register(@ModelAttribute("cri") Fcriteria cri) {
		
	}
	
	// 리스트
	// 목록으로 돌아올 때 404 오류 뜰때
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri")Fcriteria cri) {
		//FpageDTO dto = new FpageDTO(cri, total);
		
	List<FestivalVO> list = service.getList(cri);
		
		int total = service.getTotal(cri);
		
		FpageDTO dto = new FpageDTO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", dto);
				
		/*
		 * model.addAttribute("list", service.getList());
		 * 
		 * log.info("list");
		 */
	}
	
	// get => no/ modify
		@GetMapping({"/get", "/modify"})
		public void get(@RequestParam("no")int no, Model model,@ModelAttribute("cri")Fcriteria cri) {
			log.info("/get or modify");
			
			FestivalVO vo =service.get(no);	
			//service.get(no)
			model.addAttribute("festival",vo);
		}
	
	// 수정
	@PostMapping("/modify")
	public String modify(FestivalVO festival, @ModelAttribute("cri")Fcriteria cri, RedirectAttributes rttr) {
		//servicel.modify() 수정여부 ==>boolean으로 처리?
		log.info("modify: " + festival);
		
		if(service.modify(festival)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
        
		boolean count = service.modify(festival);
		
		if(count) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/festival/list";
	
	}
	
	
	
	// 삭제
	// 삭제는 반드시 post 방식
	@PostMapping("/remove")
	public String remove(@RequestParam("no")int no, @ModelAttribute("cri")Fcriteria cri,RedirectAttributes rttr) {
		
		log.info("remove: " +no);
		
		
		if(service.remove(no)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addFlashAttribute("message", "글 삭제");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		
		return "redirect:/festival/list";
	}
	
	
	
}
