package co.micol.student.service;

import java.util.List;

import co.micol.student.dto.StudentVO;

public interface StudentService {
	
	List<StudentVO> selectListStudent();	//전체학생목록을 리스트에 담아서 가지고 온다
	StudentVO selectStudent(StudentVO student);	//한명학생목록의 정보를 조회한다, VO객체로 주고 받고 해야한다
	int insertStudent(StudentVO student);	//한명 추가
	int updateStudent(StudentVO student);	//한명 갱신
	int deleteStudent(StudentVO student);	//한명 삭제
	

}
