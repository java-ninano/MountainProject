package org.zerock.domain.freeboard;

import java.util.Date;

import lombok.Data;

@Data
public class FreeBoardVO {
	private Long no;
	private String title;
	private String content;
	private Date regdate;
	private int cnt;
	private int member_no;
	
}
