package org.zerock.service.visit;

import org.springframework.stereotype.Service;
import org.zerock.mapper.VisitMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class VisitServiceImpl implements VisitService {
	
	private VisitMapper mapper;
	
	@Override
		public boolean insert() {
			return mapper.insert() == 1;
		}
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}
	@Override
	public int getToday() {
		return mapper.getToday();
	}

}
