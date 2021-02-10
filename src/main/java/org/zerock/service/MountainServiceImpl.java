package org.zerock.service;


import org.springframework.stereotype.Service;
import org.zerock.domain.MountainVO;
import org.zerock.mapper.MountainMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class MountainServiceImpl implements MountainService {
	
	private MountainMapper mapper;

	@Override
	public void register(MountainVO mountain) {
	   mapper.insertSelectKey(mountain);
	}

	
}
