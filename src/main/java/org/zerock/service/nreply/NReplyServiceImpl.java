package org.zerock.service.nreply;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.nreply.NReplyVO;
import org.zerock.mapper.NReplyMapper;
import org.zerock.mapper.NoticeMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NReplyServiceImpl implements NReplyService {
	
	private NReplyMapper mapper;
	private NoticeMapper noticeMapper;
	
	@Override
	public int getTotal(Long notice_no) {
		return mapper.getTotalCount(notice_no);
	}
	
	@Override
	@Transactional
	public int register(NReplyVO reply) {// 댓글 등록 시 notice.replycnt+1
// 곱해서 리턴 - 트랜잭셔널한 처리가 안 되는지?
		noticeMapper.updateReplyCnt(reply.getNotice_no(), 1);
		return mapper.insertSelectKey(reply);
	}
	
	@Override
	public NReplyVO get(Long no) {
		return mapper.read(no);
	}
	
	@Override
	public boolean modify(NReplyVO reply) {
		return mapper.update(reply) == 1;
	}
	
	@Override
	@Transactional
	public boolean remove(Long no) {// 댓글 삭제 시 notice.replycnt-1
		// 어느 게시물에 달린 댓글인지?
		NReplyVO reply = mapper.read(no);
		noticeMapper.updateReplyCnt(reply.getNotice_no(), -1);
		return mapper.delete(no) == 1;
	}
	
	@Override
	public List<NReplyVO> getList(Long notice_no) {
		return mapper.getList(notice_no);
	}
}
