package org.zerock.service.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.restaurant.LikeVO;
import org.zerock.mapper.LikeMapper;
import org.zerock.mapper.RestaurantMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class LikeServiceImpl implements LikeService {
	@Setter(onMethod_ = @Autowired)
	private LikeMapper mapper;

	@Override
	public void likeInsert(LikeVO like) {
		mapper.insertLike(like);
	}

	@Override
	public boolean likeRemove(Long userno, Long resno) {
		 return mapper.deleteLike(userno, resno) == 1;
	}

	@Override
	public int getLike(Long userno, Long resno) {
		return mapper.getLike(userno, resno);
	}

	@Override
	public int getDislike(Long userno, Long resno) {
		return mapper.getDislike(userno, resno);
	}
	 @Override
	public boolean likeUpdate(Long resno) {
		return mapper.updateLike(resno) == 1;
	}
}
