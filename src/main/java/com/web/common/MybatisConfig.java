package com.web.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.vo.UserInfoVO;


public class MybatisConfig {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";
	static{
		try {
			InputStream  is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}
	
	public static void main(String[] args) {
		try(SqlSession sqlSession = getSqlSessionFactory().openSession(true)){
			List<UserInfoVO> list = sqlSession.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList");
			for(UserInfoVO userInfoVO : list) {
				System.out.println(userInfoVO);
			}
			int uiNum = 12;
			UserInfoVO user = sqlSession.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);
			System.out.println("user : " + user);
			
			int result = 0 ;
//			Map<String,String> insertTest = new HashMap<>();
//			insertTest.put("uiName", "insertTest");
//			insertTest.put("uiId", "insertTestId2");
//			insertTest.put("uiPwd", "insertTestPwd");
//			insertTest.put("uiDesc", "insertTestDesc");
//			insertTest.put("uiBirth", "990226");
//			result =  sqlSession.insert("com.web.mapper.UserInfoMapper.insertUserInfo",insertTest);
//			System.out.println(result);
			
//			UserInfoVO updateTest = new UserInfoVO();
//			updateTest.setUiName("이원");
//			updateTest.setUiId("update");
//			updateTest.setUiPwd("1234");
//			updateTest.setUiDesc("updateTest");
//			updateTest.setUiBirth("990226");
//			updateTest.setUiNum(17);
//			result =  sqlSession.update("com.web.mapper.UserInfoMapper.updateUserInfo",updateTest);
//			System.out.println(result);
//			 
//			int uiNum2 = 13;
//			result = sqlSession.delete("com.web.mapper.UserInfoMapper.deleteUserInfo", uiNum2);			
//			System.out.println(result);
					}catch (Exception e) {
			// TODO: handle exception
		}
	}
}




