package co.micol.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.notice.dao.DataSource;
import co.micol.notice.service.NoticeService;
import co.micol.notice.service.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	//// 4
	private DataSource dao = DataSource.getInstance(); // 데이터 소스 객체
	private Connection conn; // = dao.getConnection();
	private PreparedStatement psmt; // PreparedStatement 객체 뭔지 알아보기~~
	private ResultSet rs;

	@Override
	public List<NoticeVO> noticeSelectList() {
		// 전체조회
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		try {
			conn = dao.getConnection(); // conn 객체 연결
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new NoticeVO();// Notice 보호객체 초기화 다시 새로운 데이터를 넣어야하니까?
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 연결된 Connection객체 끊기, finally를 했을때 정상적으로 처리했든 Exception이 나타나도 close하고 나온다
		}
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 글 세부 조회(한 개의 공자사항 읽음)
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new NoticeVO(); // Notice 보호객체 초기화
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));

				hitUpdate(vo.getId()); // 조회수 증가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 연결된 Connection객체 끊기
		}
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// 추가
		int n = 0;
		String sql = "INSERT INTO NOTICE VALUES(B_ID.NEXTVAL,?,?,?,SYSDATE,0)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getWriter());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getSubject());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// 한명 정보 변경, 업데이트
		int n = 0;
		String sql = "UPDATE NOTICE SET writer = ?, title = ?, subject = ? WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getWriter());
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getSubject());
			psmt.setInt(4, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		//삭제
		int n = 0;
		String sql = "DELET FROM NOTICE WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//// 6
	// 조회수 증가 메소드 만들기
	private void hitUpdate(int id) {
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE ID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} // 내부에서 불러서 써서 finally안 해도 됨
	}

}
