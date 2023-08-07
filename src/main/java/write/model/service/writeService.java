package write.model.service;

import java.sql.Connection;
import java.util.List;


import org.apache.ibatis.session.SqlSession;


import common.JDBCTemplate;
import common.SqlSessionTemplate;
import notice.model.vo.Notice;
import write.model.dao.writeDAO;
import write.model.vo.PageData;
import write.model.vo.Write;

public class writeService {
	private writeDAO wDao;
	private JDBCTemplate jdbcTemplate;
	
	public writeService() {
		wDao = new writeDAO();
		jdbcTemplate = JDBCTemplate.getInstance();
	}

	public int KorFreewriteBorad(Write write) {
			SqlSession session = SqlSessionTemplate.getSqlSession();
			int result = wDao.KorFreewriteBorad(session,write);
			if ( result > 0) {
				session.commit();
			}
			else {
				session.rollback();
			}
			session.close();
			
		
			
		return result;
	}

//	public List<Write> selectNoticeList1(int currentPage) {
//		SqlSession session = SqlSessionTemplate.getSqlSession();
//		List<Write> nList = wDao.selectNoticeList(session, currentPage);
//		String pageNavi = wDao.generatePageNavi(currentPage);
//		// 두개 값을 리런하기 위한 방법
//		// 1. Map 이용
//		// 2. VO클래스 이용
//		PageData pd = new PageData(nList, pageNavi);
//
//		return pd;
//	}

	public PageData selectNoticeList(int currentPage) {
		
		SqlSession session = SqlSessionTemplate.getSqlSession();
//		Connection conn = jdbcTemplate.createConnection();
		List<Write> write = wDao.selectNoticeList(session, currentPage);
		String pageNavi = wDao.generatePageNavi(currentPage);
		// 두개 값을 리런하기 위한 방법
		// 1. Map 이용
		// 2. VO클래스 이용
		PageData pd = new PageData(write, pageNavi);

		return pd;
	}
	
	
}
