package org.zerock.service.nreply;

import java.util.List;

import org.zerock.domain.notice.NReplyVO;

public interface NReplyService {
	
	public int getTotal();
	
	public void register(NReplyVO reply);
	
	public NReplyVO get(Long no);
	
	public boolean modify(NReplyVO reply);
	
	public boolean delete(Long no);
	
	public List<NReplyVO> getList();
}
