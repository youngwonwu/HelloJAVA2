package co.micol.student;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import co.micol.student.dao.DataSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;
import co.micol.student.serviceImpl.StudentServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
      	StudentService dao = new StudentServiceImpl();
    	List<StudentVO> list = new ArrayList<StudentVO>();
    	
    	list = dao.selectListStudent();
    	for(StudentVO vo : list) {
    		vo.toString();
    	}
//    	
//    	System.out.println("============================================");
//    	
//    	//한명조회
//    	StudentVO student = new StudentVO();
//    	student.setStudentId("park@abc.com");
//    	student = dao.selectStudent(student);	//수행
//    	student.toString();
    	
    	
//    	StudentVO vo = new StudentVO();
//    	vo.setStudentId("lee@abc.com");
//    	vo.setName("이승리");
//    	vo.setBirthday(Date.valueOf("2000-02-01"));
//    	vo.setMajor("경영학과");
//    	vo.setAddress("대구광역시 중구 중앙대로");
//    	vo.setTel("010-3333-1234");
//    	int n = dao.insertStudent(vo);
//    	if(n != 0) {
//    		System.out.println("정상적으로 입력이 되었습니다.");
//    	} else {
//    		System.out.println("입력이 실패 했습니다.");
//    	}
    	
//    	StudentVO vo1 = new StudentVO();
//    	vo1.setStudentId("leeto@abc.com");
//    	vo1.setName("이기자");
//    	vo1.setBirthday(Date.valueOf("2000-04-08"));
//    	vo1.setMajor("경영학과");
//    	vo1.setAddress("대구광역시 중구 중앙대로");
//    	vo1.setTel("010-4444-1234");
//    	int n1 = dao.insertStudent(vo1);
//    	if(n1 != 0) {
//    		System.out.println("정상적으로 입력이 되었습니다.");
//    	} else {
//    		System.out.println("입력이 실패 했습니다.");
//    	}
    	
    }
}
