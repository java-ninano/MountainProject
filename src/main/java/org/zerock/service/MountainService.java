package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.MountainVO;

public interface MountainService {

	public List<MountainVO> getList(Criteria cri);

	public int getTotal(Criteria cri);

	public void register(MountainVO mountain);

	public MountainVO get(Long no);

	public boolean modify(MountainVO mountain);

	public boolean remove(Long no);

}
