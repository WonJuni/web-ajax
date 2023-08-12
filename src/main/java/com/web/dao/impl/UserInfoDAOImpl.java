package com.web.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.common.MybatisConfig;
import com.web.dao.UserInfoDAO;
import com.web.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfoVO> selectUserInfoList(SqlSession session, UserInfoVO user) {
		return session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList", user);
	}

	@Override
	public UserInfoVO selectUserInfo(SqlSession session, int uiNum) {
		return session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo", uiNum);
	}

	@Override
	public int insertUserInfo(SqlSession session, UserInfoVO user) {
		return session.insert("com.web.mapper.UserInfoMapper.insertUserInfo", user);
	}

	@Override
	public int deleteUserInfo(SqlSession session, int uiNum) {
		return session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo", uiNum);
	}

	@Override
	public int updateUserInfo(SqlSession session, UserInfoVO user) {
		return session.update("com.web.mapper.UserInfoMapper.updateUserInfo", user);
	}

	public static void main(String[] args) {
		try (SqlSession session = MybatisConfig.getSqlSessionFactory().openSession()) {
			UserInfoDAO userInfoDAO = new UserInfoDAOImpl();
			List<UserInfoVO> userList = userInfoDAO.selectUserInfoList(session, null);
			for (UserInfoVO user : userList) {
				System.out.println(user);
			}
			UserInfoVO user = userInfoDAO.selectUserInfo(session, 12);
			System.out.println("Select One : " + user);
			
			user.setUiName("Change");
			int result = userInfoDAO.updateUserInfo(session, user);
			
			result = userInfoDAO.deleteUserInfo(session, 17);
			
	//			user.setUiId("dao");
////			int result = userInfoDAO.insertUserinfo(session, user);
////			System.out.println("insert : " + result);
			session.commit();
			
			
		}
	}

}
