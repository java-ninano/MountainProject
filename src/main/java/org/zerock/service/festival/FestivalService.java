package org.zerock.service.festival;

import java.util.List;

import org.zerock.domain.festival.FestivalVO;

public interface FestivalService {
	
	public void register(FestivalVO festival);
	
	public FestivalVO read(int no);
	
	public List<FestivalVO> getList();

	public boolean remove(int no);
	
	public boolean modify(FestivalVO festival);

	public FestivalVO get(Long no);
	
	
	
	
}
