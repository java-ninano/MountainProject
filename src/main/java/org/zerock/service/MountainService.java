package org.zerock.service;

import java.util.List;

import org.zerock.domain.Mcriteria;
import org.zerock.domain.FestivalVO;
import org.zerock.domain.MountainVO;

public interface MountainService {

	public void register(MountainVO mountain);
	
	public List<MountainVO> getList(Mcriteria mcri);
	
	public MountainVO get(Long no);
	
	public boolean remove(Long no);
	
	public boolean modify(MountainVO mountain);
	
	public int getTotal(Mcriteria mcri);

	
}
