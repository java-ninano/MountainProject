package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.MountainVO;

public interface MountainMapper {

	public List<MountainVO> getList();
	
	public void insert(MountainVO mountain);
	
	public void insertSelectKey(MountainVO mountain);
	
	public MountainVO read(Long no);
	
	public int delete(Long no);
	
	public int update(MountainVO mountain);

	
	
}
