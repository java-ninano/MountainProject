package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.MountainVO;

public interface MountainMapper {

	public List<MountainVO> getListWithPaging(Criteria cri);
	
	public List<MountainVO> getList();

	public int getTotalCount(Criteria cri);

	public void insertSelectKey(MountainVO mountain);

	public MountainVO read(Long no);

	public int update(MountainVO mountain);

	public int delete(Long no);
	
	public void updateReplyCnt(Long no, int amount);

}
