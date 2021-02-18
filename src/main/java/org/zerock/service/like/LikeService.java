package org.zerock.service.like;

import org.zerock.domain.restaurant.LikeVO;

public interface LikeService {
	public void likeInsert(LikeVO like);
	public boolean likeRemove(Long userno, Long resno);
	public boolean likeUpdate(Long resno);
	public int getLike(Long userno, Long resno);
	public int getDislike(Long userno, Long resno);
}
