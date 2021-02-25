package org.zerock.service.mountain;

import java.util.List;

import org.zerock.domain.festival.Fcriteria;
import org.zerock.domain.festival.FestivalVO;
import org.zerock.domain.mountain.ConqStickerVO;
import org.zerock.domain.mountain.MCriteria;
import org.zerock.domain.mountain.MnameVO;
import org.zerock.domain.mountain.MountainVO;

public interface MountainService {

	public int getTotal(MCriteria mcri);
	
	public void register(MountainVO mountain);
	
	public MountainVO get(Long no);
	
	public boolean modify(MountainVO mountain);

	public boolean remove(Long no);

	public List<MountainVO> getList(MCriteria mcri);
	
	public boolean existMname(String mname);

	// for CONQUEST table
	public List<MnameVO> getMnameList();
	
	public List<ConqStickerVO> getConqListbyMem(Long user_no);

}
