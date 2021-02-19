package org.zerock.service.festival;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.festival.FestivalVO;
import org.zerock.mapper.FestivalMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class FestivalServiceImpl implements FestivalService{

	private FestivalMapper mapper;

	@Override
	public void register(FestivalVO festival) {
		mapper.insertSelectKey(festival);
	}


	@Override
	public boolean modify(FestivalVO vo) {
		
		return mapper.update(vo) ==1 ;
	}

	@Override
	public List<FestivalVO> getList() {
		
		return mapper.getList();
	}


	@Override
	public boolean remove(int no) {
		
		return mapper.delete(no);
	}


	

	
	
	
	
}
