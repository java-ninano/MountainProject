package org.zerock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.nreply.NReplyVO;
import org.zerock.service.nreply.NReplyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/nreplies/*")
public class NReplyController {// using ajax!

	private NReplyService service;
	
	@PostMapping(value = "/new",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> register(@RequestBody NReplyVO reply) {
		if(service.register(reply) == 1) {
			return new ResponseEntity<String>("newReplySuccess", HttpStatus.OK);			
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "/{no}",
				 consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> modify(@RequestBody NReplyVO reply){
		if(service.modify(reply)) {
			return new ResponseEntity<>("modReplySuccess", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
}
