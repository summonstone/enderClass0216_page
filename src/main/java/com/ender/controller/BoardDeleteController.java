package com.ender.controller;

import java.io.IOException;  

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;

public class BoardDeleteController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bo_num = Integer.parseInt(request.getParameter("bo_num"));
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardDelete(bo_num);

		String nextPage = null;

 		if(cnt>0) {
 			nextPage= "redirect:/boardList.do";
 		} else {
 			throw new ServletException("not delete");
 		}
		return nextPage;
	}

}
