package co.micol.notice.service;

import java.util.List;

public interface NoticeService {
	
	////2
	List<NoticeVO> noticeSelectList();	//전체조회
	NoticeVO noticeSelect(NoticeVO vo);	//하나의 글조회
	int noticeInsert(NoticeVO vo);	//추가
	int noticeUpdate(NoticeVO vo);	//변경
	int noticeDelete(NoticeVO vo);	//삭제

}
