package org.zerock.domain.mountain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long no;
	private Long board_no;


	private String reply;
	private String replyer;
	private Date regdate;	
	

}
