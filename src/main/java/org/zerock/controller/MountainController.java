package org.zerock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.mountain.MCriteria;
import org.zerock.domain.mountain.MPageDTO;
import org.zerock.domain.mountain.MountainVO;
import org.zerock.service.mountain.MountainService;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Controller
@AllArgsConstructor
@RequestMapping("/*")
public class MountainController {

	@Setter(onMethod_ = @Autowired)
	private MountainService service;
	
	
	@GetMapping("/register")
	public void register() {// 주소 api
		// /views/register.jsp
	}
	
	@PostMapping("/register")
	public String register(MountainVO mountain, RedirectAttributes rttr) {
		service.register(mountain);
		rttr.addFlashAttribute("result", "regSuccess");
		
		return "redirect:/list";
	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("no") Long no, Model model) {// @RequestParam("no") 매개변수 매핑
		MountainVO mountain = service.get(no);
		model.addAttribute("mountain", mountain);
		// /views/get.jsp | // /views/modify.jsp
	}
	
	@PostMapping("/modify")
	public ResponseEntity<String> modify(MountainVO mountain, HttpSession session){
		if (service.modify(mountain)) {
			session.setAttribute("result", "modSuccess");
			return new ResponseEntity<>("modSuccess", HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> remove(@RequestParam Long no, HttpSession session){
		if (service.remove(no)) {
			session.setAttribute("result", "delSuccess");
			return new ResponseEntity<>("delSuccess", HttpStatus.OK);
		} 
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("cri") MCriteria cri, Model model) {
		int total = service.getTotal(cri);
		model.addAttribute("pages", new MPageDTO(total, cri));
		
		List<MountainVO> list = service.getList(cri);
		model.addAttribute("list", list);
		// /views/list.jsp
	}
	
}
