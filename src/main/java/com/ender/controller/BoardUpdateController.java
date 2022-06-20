package com.ender.controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;
import com.ender.boardmodel.BoardVO;

public class BoardUpdateController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String ctp=request.getContextPath();
		
		BoardVO vo = new BoardVO();
		vo.setBo_num(Integer.parseInt(request.getParameter("bo_num")));
		vo.setBo_writer(request.getParameter("bo_writer"));
		vo.setBo_subject(request.getParameter("bo_subject"));
		vo.setBo_content(request.getParameter("bo_content"));
		vo.setBo_id(request.getParameter("bo_id"));
		
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardUpdate(vo);
		
		String nextPage = null;
		
		if(cnt>0) {
			nextPage="redirect:/boardList.do";
		} else {
			throw new ServletException("not update");
		}

		return nextPage;
	}

}
