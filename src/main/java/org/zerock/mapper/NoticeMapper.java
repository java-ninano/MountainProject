package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.notice.NCriteria;
import org.zerock.domain.notice.NoticeVO;

public interface NoticeMapper {

	public int getTotalCount(NCriteria cri);
	
	public void insertSelectKey(NoticeVO vo);
	
	public NoticeVO read(Long no);
	
	public int updateCnt(Long no);
	
	public int update(NoticeVO vo);
	
	public int delete(Long no);
	
	public List<NoticeVO> getList();
	
	public List<NoticeVO> getListWithPaging(NCriteria cri);
}
