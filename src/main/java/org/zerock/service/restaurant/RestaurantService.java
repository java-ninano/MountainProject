package org.zerock.service.restaurant;

import java.util.List;

import org.zerock.domain.restaurant.Rcriteria;
import org.zerock.domain.restaurant.RestaurantVO;

public interface RestaurantService {
	public void register(RestaurantVO restaurant);

	public RestaurantVO read(Long no); 

	public boolean modify(RestaurantVO restaurant);

	public boolean remove(Long no);
	
	public List<RestaurantVO> getList(Rcriteria cri);
	
	public int getTotal(Rcriteria cri);

}
