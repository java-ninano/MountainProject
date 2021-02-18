package org.zerock.service.mountain;

import java.util.List;

import org.zerock.domain.festival.FestivalVO;
import org.zerock.domain.mountain.Mcriteria;
import org.zerock.domain.mountain.MountainVO;

public interface MountainService {

	public void register(MountainVO mountain);
	
	public List<MountainVO> getList(Mcriteria mcri);
	
	public MountainVO get(Long no);
	
	public boolean remove(Long no);
	
	public boolean modify(MountainVO mountain);
	
	public int getTotal(Mcriteria mcri);

	
}
