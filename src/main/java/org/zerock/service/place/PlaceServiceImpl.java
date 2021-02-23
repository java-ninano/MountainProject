package org.zerock.service.place;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.place.Pcriteria;
import org.zerock.domain.place.PlaceVO;
import org.zerock.mapper.PlaceMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class PlaceServiceImpl implements PlaceService{
	
	private PlaceMapper mapper;
	
	@Override
	public void register(PlaceVO place) {
		mapper.insertSelectKey(place);
	}

	@Override
	public PlaceVO read(Long no) {
		return mapper.read(no);
	}

	@Override
	public boolean modify(PlaceVO place) {
		return mapper.update(place) == 1;
	}

	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1;
	}

	@Override
	public List<PlaceVO> getList(Pcriteria cri) {
		return mapper.getListPaging(cri);
	}

	@Override
	public int getTotal(Pcriteria cri) {
		return mapper.getTotalCnt(cri);
	}

}
