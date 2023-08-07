package write.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;


import write.model.vo.Write;

public class writeDAO {

	public int KorFreewriteBorad(SqlSession session, Write write) {
		int result = session.insert("UserMapper.writeKorFree", write);
		return result;
	}

	public List<Write> selectNoticeList(SqlSession session, int currentPage) {
		// TODO Auto-generated method stub
		List<Write> nList = new ArrayList<Write>();
		int limit = 10;
		int offset = (currentPage - 1) * limit;

		RowBounds rowBounds = new RowBounds(offset, limit);
		nList = session.selectList("UserMapper.selectList", null, rowBounds);

		

		return nList;
	}

	public String generatePageNavi(int currentPage) {
		// TODO Auto-generated method stub
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
					result.append("<a href='/notice/KorFreelist.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
				}
				for (int i = startNavi; i <= endNavi; i++) {

					result.append("<a href= \"/notice/KorFreelist.do?currentPage=" + i + "\">" + i + "    " + " </a>");

				}
				if (needNext) {
					result.append("<a href='/notice/KorFreelist.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
				}
				return result.toString();
	}

}

	
