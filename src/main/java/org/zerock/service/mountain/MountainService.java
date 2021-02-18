package org.zerock.service.mountain;

import java.util.List;

import org.zerock.domain.Mountain.Mcriteria;
import org.zerock.domain.Mountain.MountainVO;
import org.zerock.domain.festival.FestivalVO;

public interface MountainService {

	public void register(MountainVO mountain);
	
	public List<MountainVO> getList(Mcriteria mcri);
	
	public MountainVO get(Long no);
	
	public boolean remove(Long no);
	
	public boolean modify(MountainVO mountain);
	
	public int getTotal(Mcriteria mcri);

	
}
