package org.zerock.service.nreply;

import java.util.List;

import org.zerock.domain.nreply.NReplyVO;

public interface NReplyService {
	
	public int getTotal();
	
	public int register(NReplyVO reply);
	
	public NReplyVO get(Long no);
	
	public boolean modify(NReplyVO reply);
	
	public boolean remove(Long no);
	
	public List<NReplyVO> getList();
}
