package MemberService;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import common.JDBCTemplate;
import common.SqlSessionTemplate;
import member.model.dao.MemberDAO;
import member.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private MemberDAO mDao;

	public MemberService() {
		jdbcTemplate = JDBCTemplate.getInstance();
		mDao = new MemberDAO();
		// TODO Auto-generated constructor stub
	}

	public int insertMember(Member member) {
		// 연결 생성 해야야아아아아아아함

		Connection conn = jdbcTemplate.createConnection();

		// dao 호출 해야하하하하아아아아아아아아아아아아함
		int result = mDao.insertMember(conn, member);

		// 커밋,롤백 해야아아아아아아아아아아아아아아아아함
		if (result > 0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		} else { // 실패 - 롤백!!
			jdbcTemplate.rollback(conn);
		}

		return result;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		// 연결 생성 해야야아아아아아아함

				Connection conn = jdbcTemplate.createConnection();

				// dao 호출 해야하하하하아아아아아아아아아아아아함
				int result = mDao.updateMember(conn, member);

				// 커밋,롤백 해야아아아아아아아아아아아아아아아아함
				if (result > 0) {
					// 성공 - 커밋
					jdbcTemplate.commit(conn);
				} else { // 실패 - 롤백!!
					jdbcTemplate.rollback(conn);
				}

				return result;
	}

	public int nicupdateMember(String memberId,String memberNic) {
		Connection conn = jdbcTemplate.createConnection();

		// dao 호출 해야하하하하아아아아아아아아아아아아함
		int result = mDao.nicupdateMember(conn, memberId,memberNic);

		// 커밋,롤백 해야아아아아아아아아아아아아아아아아함
		if (result > 0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		} else { // 실패 - 롤백!!
			jdbcTemplate.rollback(conn);
		}

		return result;
	}

	public int phoneUpdate(String memberId, String memberPhone) {
		// TODO Auto-generated method stub
		Connection conn = jdbcTemplate.createConnection();

		// dao 호출 해야하하하하아아아아아아아아아아아아함
		int result = mDao.phoneUpdate(conn, memberId,memberPhone);

		// 커밋,롤백 해야아아아아아아아아아아아아아아아아함
		if (result > 0) {
			// 성공 - 커밋
			jdbcTemplate.commit(conn);
		} else { // 실패 - 롤백!!
			jdbcTemplate.rollback(conn);
		}

		return result;
	}

	public Member selectCheckLogin(Member member) {

		// 연결 생성

		Connection conn = jdbcTemplate.createConnection();

		// DAO 호출(연결도 넘겨줘야함 conn)

		Member mOne = mDao.selectCheckLogin(conn, member);

		return mOne;
	}

	public Member selectOneById(String memberId) {
		
		// 연결 생성
		Connection conn = jdbcTemplate.createConnection();
		
		
		// DAO 호출(연결도 넘겨줘야함)
		Member member = mDao.selectOneById(conn,memberId);
		jdbcTemplate.close(conn);
		
		
		
		return member;
	}

	public int deleteMember(String memberId) {
		
		//연결 생성
		SqlSession session = SqlSessionTemplate.getSqlSession();
		//DAO 호출(연결 넘겨주기)
		int result = mDao.deleteMember(session,memberId);
		
		if (result > 0) {
			// 성공 - 커밋
			session.commit();
		} else { // 실패 - 롤백!!
			session.rollback();
		}

		return result;
	}


}
