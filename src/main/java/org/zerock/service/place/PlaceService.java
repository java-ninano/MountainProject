package org.zerock.service.place;

import java.util.List;

import org.zerock.domain.place.Pcriteria;
import org.zerock.domain.place.PlaceVO;


public interface PlaceService {
	public void register(PlaceVO place);

	public PlaceVO read(Long no); 

	public boolean modify(PlaceVO place);

	public boolean remove(Long no);
	
	public List<PlaceVO> getList(Pcriteria cri);
	
	public int getTotal(Pcriteria cri);

}
