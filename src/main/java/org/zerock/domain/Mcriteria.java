package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Mcriteria {

	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	
	public Mcriteria() {
		//기본값으로 설정
		this(1, 10);
	}

	public Mcriteria(int pageNum, int amount) {
	    this.pageNum = pageNum;
	    this.amount =amount;
	}
	
	 public String[] getTypeArr() {
		   if(this.type == null) {
			  return  new String[] {};
		   }else {
			   return type.split("");
		   }
	   }
}
