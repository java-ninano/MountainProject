package org.zerock.service.mountain;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.mountain.Mcriteria;
import org.zerock.domain.mountain.MountainVO;
import org.zerock.mapper.MountainMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class MountainServiceImpl implements MountainService {
	private MountainMapper mapper;
	
	@Override
	public void register(MountainVO mountain) {
		mapper.insertSelectKey(mountain);
	}

	@Override
	public List<MountainVO> getList(Mcriteria mcri) {
		return mapper.getListWithPaging(mcri);
	}

	@Override
	public MountainVO get(Long no) {
		return mapper.read(no) ;
	}

	@Override
	public boolean remove(Long no) {
		// TODO Auto-generated method stub
		return mapper.delete(no) ==1;
	}

	@Override
	public boolean modify(MountainVO mountain) {
		return mapper.update(mountain) ==1;
	}

	@Override
	public int getTotal(Mcriteria mcri) {
		return mapper.getTotalCount(mcri);
	}
	
	

	 
}
