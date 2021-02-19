package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.festival.FestivalVO;
import org.zerock.domain.mountain.MountainVO;


public interface FestivalMapper {
	// 게시물 작성
	public void insert(FestivalVO festival);
	
    // 게시물 전체 목록
	public List<FestivalVO> getList();
	
	// 게시글 상세보기
	public FestivalVO read(int no);
	
	// 게시글 수정 
	public int update(FestivalVO festival);
	
	// 게시글 삭제
	public boolean delete(long no);
	
	// insertkey
	public void insertSelectKey(FestivalVO festival);
	
	// 산별 축제조회
    public void search(int mountain_no);

	

	

	
}
