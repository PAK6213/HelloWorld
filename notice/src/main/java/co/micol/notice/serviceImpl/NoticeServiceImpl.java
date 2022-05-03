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
	private DataSource dao = DataSource.getInstance(); 
	private Connection conn; // = dao.getConnection(); // App과 DBMS간의 연결에 사용
	
	private PreparedStatement psmt; // sql문을 전송하고 실행시켜 결과를 받아올때 사용
	private ResultSet rs; // 결과를 받아올때 사용.
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		// 전체조회
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "SELECT * FROM NOTICE";
		
		try {
			conn = dao.getConnection(); // 커넥션 연결
			psmt = conn.prepareStatement(sql); // 쿼리문을 보내고 실행.
			rs = psmt.executeQuery(); // 결과를 받아옴.
			while(rs.next()) {// 읽을것이 있을 때 까지 반복. 
				vo = new NoticeVO(); // 결과를 받아올 noticeVO 인스턴스생성
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo); // 하나의 noticeVO를 읽어서 ArrayList에 추가.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {  // 정상적이든 비정상적이든 연결을 끊기 위해 finally에 close를 넣어줌.
			close(); // 연결된 커넥션을 끊음.  
		}
		
		return list;
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// 하나의 게시글 조회
		String sql = "SELECT * FROM NOTICE WHERE ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());  // sql문의 ?에 들어갈 값을 지정해줌.
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new NoticeVO(); // 하나를 보내야 하기 때문에 VO인스턴스 초기화
				vo.setId(rs.getInt("id"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				
				hitUpdate(vo.getId());  // 한건 조회시 조회수 증가.
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// 하나의 게시글 등록.
		String sql = "INSERT INTO NOTICE VALUES(?,?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getSubject());
			psmt.setDate(5, vo.getWdate());
			psmt.setInt(6, vo.getHit());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// 게시글 수정
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// 게시글 삭제
		return 0;
	}
	
	private void close() {
		// 연결의 반대순으로 끊어줌.
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	// 조회수
	private void hitUpdate(int id) {
		String sql = "UPDATE NOTICE SET HIT = HIT + 1 WHERE ID = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
