package co.micol.notice;

import java.util.ArrayList;
import java.util.List;

import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;
import co.micol.notice.serviceImpl.NoticeServiceImpl;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	////5
    	//NoticeService notice = new NoticeServiceImpl();	//전체 조회
//    	List<NoticeVO> list = new ArrayList<>();
//    	list = dao.noticeSelectList();
//    	
//    	for(NoticeVO vo : list) {
//    		vo.toString();
//    	}
//    	
//    	//한 건 조회........안돼ㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜㅜ
//    	Notice..
    	
    	///7
    	//학생리스트 불러오기
//    	StudentService studentDao = new StudentServiceImpl();
//    	List<StudentVO> list = new ArrayList<StudentVO>();
//    	list = studentDao.selectListStudent();
//    	for(StudentVO vo :list) {
//    		vo.toString();
//    	}
    	
    	
//    	NoticeService noticeDao = new NoticeServiceImpl();
//    	List<NoticeVO> nlist = new ArrayList<NoticeVO>();
//    	nlist = noticeDao.noticeSelectList();
//    	for(NoticeVO vo :nlist) {
//    		vo.toString();
//    	}
    	NoticeService noticeDao = new NoticeServiceImpl();
    	NoticeVO vo4 =new NoticeVO();
    	vo4.setId(1);
    	noticeDao.noticeSelect(vo4);
    	List<NoticeVO> nlist = new ArrayList<NoticeVO>();
    	nlist = noticeDao.noticeSelectList();
    	for(NoticeVO vo :nlist) {
    		vo.toString();
    	}
    }
}
