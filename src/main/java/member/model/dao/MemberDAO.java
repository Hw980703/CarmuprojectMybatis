package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import member.vo.Member;

public class MemberDAO {

	public int insertMember(Connection conn, Member member) {
		String query = "INSERT INTO CARMU VALUES(?,?,?,?,?,?,DEFAULT)";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberNicName());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberPhone());

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

	public int updateMember(Connection conn, Member member) {
		// TODO Auto-generated method stub
		String query = " UPDATE CARMU SET MEMBER_PW = ? ,MEMBER_NICNAME = ? ,MEMBER_EMAIL =?,MEMBER_PHONE = ? ,UPDATE_DATE = DEFAULT   WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberNicName());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberId());


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

	public int nicupdateMember(Connection conn, String memberId, String memberNic) {
		String query = " UPDATE CARMU SET MEMBER_NICNAME = ? WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberNic);
			pstmt.setString(2,memberId );


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

	public int phoneUpdate(Connection conn, String memberId, String memberPhone) {
		String query = " UPDATE CARMU SET MEMBER_PHONE = ? WHERE MEMBER_ID = ?";
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberPhone);
			pstmt.setString(2,memberId );


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

	public int deleteMember(SqlSession session, String memberId) {
		int reuslt = session.delete("memberMappers.memberDelete",memberId);
		return reuslt;

	}

//	public int deleteMember(Connection conn, String memberId) {
//
//		String query = "DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ? ";
//		PreparedStatement pstmt = null;
//		int result = 0;
//
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, memberId);
//			result = pstmt.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//		return result;
//	}

	public Member selectCheckLogin(Connection conn, Member member) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CARMU WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
//		String query = "SELECT COUNT(*) FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		Member mOne = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			rset = pstmt.executeQuery(); // 실행문 누락주의 , 결과값 받기
			if (rset.next()) {
				mOne = rsetToMember(rset);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return mOne;
	}

	public Member selectOneById(Connection conn, String memberId) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CARMU WHERE MEMBER_ID = ?";
		Member mOne = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery(); // 실행문 누락주의 , 결과값 받기
			if (rset.next()) {
				mOne = rsetToMember(rset);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return mOne;
	}

	private Member rsetToMember(ResultSet rset) throws SQLException {
		Member member = new Member();

		member.setMemberId(rset.getString(1));
		member.setMemberPw(rset.getString(2));
		member.setMemberName(rset.getString(3));
		member.setMemberNicName(rset.getString(4));
		member.setMemberEmail(rset.getString(5));
		member.setMemberPhone(rset.getString(6));
		member.setMemberDate(rset.getTimestamp(7));

		return member;
	}

	public Member selectIdInfo(SqlSession session, String memberId) {
		
		
		Member member = session.selectOne("memberMappers.selectMember",memberId);

		return member;
	}


}
