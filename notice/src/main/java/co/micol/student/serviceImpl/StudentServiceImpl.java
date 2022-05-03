package co.micol.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.notice.dao.DataSource;
//import co.micol.student.dao.DataSource;
import co.micol.student.dto.StudentVO;
import co.micol.student.service.StudentService;

public class StudentServiceImpl implements StudentService {
	//구현체만들기
	
	private DataSource dataSource = DataSource.getInstance();	//Dao instance생성
	private Connection conn; //= dataSource.getConnection();	//connection
	private PreparedStatement psmt;	//sql 명령실행
	private ResultSet rs;	//select 결과를 담음

	@Override
	public List<StudentVO> selectListStudent() {
		//전체 학생 목록 가져오기
		List<StudentVO> students = new ArrayList<StudentVO>();	//ArrayList로 초기화해서 가져온다?
		StudentVO student;	//한명의 데이터를 담을 수 있는 VO객체
		String sql = "SELECT * FROM STUDENT";	//쿼리문은 대문자로 해서 구별해주기(ctrl + shift + x)
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//sql을 실행하고 결과를 담음
			while(rs.next()) {	//얼마나 왔는지 모르니까 while? 뮤신말...
				student = new StudentVO();		//값이 틀릴 수 있으니 초기화(인스턴스)
				student.setStudentId(rs.getString("studentid"));	//담는다 tel까지
				student.setName(rs.getString("name"));
				student.setBirthday(rs.getDate("birthday"));
				student.setMajor(rs.getString("major"));
				student.setAddress(rs.getString("address"));
				student.setTel(rs.getString("tel"));
				students.add(student);	//리스트추가
			}
			
	} catch (SQLException e) {
		e.printStackTrace();
		}
		return students;
	}

	@Override
	public StudentVO selectStudent(StudentVO student) {
		//한명 조회하기
		StudentVO vo = new StudentVO();
		String sql = "SELECT * FROM STUDENT WHERE STUDENTID = ?";	//? 값을 담을 때는 ?가 있는 곳이 1, 만약 중간중간에 ?가 있으면 첫 ?가 잇는 곳이 1, 그다음에 있는 곳이 2 ~~~
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setStudentId(rs.getString("studentid"));
				vo.setName(rs.getString("name"));
				vo.setBirthday(rs.getDate("birthday"));
				vo.setMajor(rs.getString("major"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int insertStudent(StudentVO student) {
		//한명 추가
		int n = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			psmt.setString(2, student.getName());
			psmt.setDate(3, student.getBirthday());
			psmt.setString(4, student.getMajor());
			psmt.setString(5, student.getAddress());
			psmt.setString(6, student.getTel());
			n = psmt.executeUpdate();	//실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int updateStudent(StudentVO student) {
		//한명 정보 변경, 업데이트
		int n = 0;
		String sql = "UPDATE STUDENT SET MAJOR = ?, ADDRESS = ?, TEL = ? WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getMajor());
			psmt.setString(2, student.getAddress());
			psmt.setString(3, student.getTel());
			psmt.setString(4, student.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int deleteStudent(StudentVO student) {
		//삭제하기
		int n = 0;
		String sql = "DELET FROM STUDENT WHERE STUDENTID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, student.getStudentId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

}
