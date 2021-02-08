package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.MountainVO;
import org.zerock.mapper.MountainMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MountainServiceImpl implements MountainService {
	
	private MountainMapper mapper;

	@Override
	public List<MountainVO> getList(Criteria cri) {
	  return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public void register(MountainVO mountain) {
		mapper.insertSelectKey(mountain);
		
	}

	@Override
	public MountainVO get(Long no) {
	return mapper.read(no);
	}

	@Override
	public boolean modify(MountainVO mountain) {
		return mapper.update(mountain) == 1;
	}

	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) ==1;
	}

}
