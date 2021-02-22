package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/file")
@Log4j
public class FileUpController {

	@GetMapping("/ex1")
	public void form() {
		
	}
	@PostMapping("ex1")
	public String fileup(
			@RequestParam("name")String name, 
			@RequestParam("file")MultipartFile file) {
		
		log.info(name);
		log.info(file.getOriginalFilename());
		
		return "/file/ex1";
		
	}
}
