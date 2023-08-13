package com.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.web.common.CommonView;
import com.web.dao.impl.UserInfoDAOImpl;
import com.web.service.UserInfoService;
import com.web.service.impl.UserInfoServiceImpl;
import com.web.vo.UserInfoVO;


@WebServlet("/user-info/*")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private Gson gson = new Gson();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String cmd = CommonView.getCmd(request);
		String json = "";
		
		if("list".equals(cmd)) {
			json = gson.toJson(userInfoService.selectUserInfoList(null));
			out.print(json);
		}else if("view".equals(cmd)||"update".equals(cmd)){
			json = gson.toJson(userInfoService.selectUserInfo(Integer.parseInt(request.getParameter("uiNum"))));
			out.print(json);
		}
		
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		BufferedReader bufferedReader = request.getReader();
		StringBuffer stringBuffer = new StringBuffer();
		String str = null;
		
		while((str = bufferedReader.readLine())!=null) {
			stringBuffer.append(str);
		}
		
		UserInfoVO map = gson.fromJson(stringBuffer.toString(), UserInfoVO.class);
		
		
		String json = "0";
		
		if("update".equals(cmd)) {
			if(map != null) {
				System.out.println(map);
				json = userInfoService.updateUserInfo(map) + "";
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		out.print(json);
	}

}
