package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;
import write.model.vo.Write;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("noticeMapper.mainNotice",notice);
		return result;
	}

	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE_TBL SET NOTICE_SUBJECT=  ? , NOTICE_CONTENT = ? WHERE NOTICE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeSubject());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM NOTICE_TBL WHERE NOTICE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	public List<Write> selectNoticeList(Connection conn, int curruentPage) {
		PreparedStatement pstmt = null;
		List<Write> nList = new ArrayList<Write>();
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC) ROW_NUM, NOTICE_TBL.* FROM NOTICE_TBL) WHERE ROW_NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;

		int start = curruentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = curruentPage * recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rset = pstmt.executeQuery();

			while (rset.next()) {
				Notice notice = new Notice();

				notice.setNoticeNo(rset.getInt(2));
				notice.setNoticeSubject(rset.getString(3));
				notice.setNoticeContent(rset.getString(4));
				notice.setNoticeWriter(rset.getString(5));
				notice.setNoticeDate(rset.getTimestamp(6));
				notice.setNoticeUpdateDate(rset.getTimestamp(7));
				notice.setNoticeCount(rset.getInt(8));

				nList.add(notice);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nList;
	}

	public String generatePageNavi(int currentPage) {
		// 전체 게시물의 갯수 : 37
		// 1페이지 보여줄 게시물 수 :10
		// 범위의 갯수(네비게이터의 수) : ?

		// 전체 게시물의 갯수는 : 55
		// 1페이지의 보여줄 게시물 : 10
		// 범위의 갯수 ( 네비게이터의 수) : 6

		// 전체 게시물 SELECT COUNT(*) FROM NOTICE_TBL
		int totalConut = 202;
		int recordCountPerPage = 10;
		int naviTotalCount = 0;

		if (totalConut % recordCountPerPage > 0) {

			naviTotalCount = totalConut / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalConut / recordCountPerPage;

		}

		int naviCountPerPage = 5;
		// currentPage startNavi endNavi
		// 1 1 5
		// 2 6 10
		// 3 11 15

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// endNavi의 값이 총 범위의 갯수보다 커지는 것을 막아주는 코드

		if (endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;

		}
		if (endNavi == naviTotalCount) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if (needPrev) {
			result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {

			result.append("<a href= \"/notice/list.do?currentPage=" + i + "\">" + i + "    " + " </a>");

		}
		if (needNext) {
			result.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}

	public Notice selectOneByNo(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;

		String query = "SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				notice = new Notice();

				notice.setNoticeNo(rset.getInt(1));
				notice.setNoticeSubject(rset.getString(2));
				notice.setNoticeContent(rset.getString(3));
				notice.setNoticeWriter(rset.getString(4));
				notice.setNoticeDate(rset.getTimestamp(5));
				notice.setNoticeUpdateDate(rset.getTimestamp(6));
				notice.setNoticeCount(rset.getInt(7));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return notice;
	}

	public List<Notice> selectNoticeList(SqlSession session, int currentPage) {

		int limit = 10;
		int offset = (currentPage - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);

		List<Notice> nList = session.selectList("noticeMapper.mainNoticeList", null, rowBounds);

		return nList;
	}

}
