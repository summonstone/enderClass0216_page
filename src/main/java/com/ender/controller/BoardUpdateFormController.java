package com.ender.controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;
import com.ender.boardmodel.BoardVO;

public class BoardUpdateFormController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bo_num = Integer.parseInt(request.getParameter("bo_num"));

		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.boardDetail(bo_num);
		request.setAttribute("vo", vo);

//		String nextPage = null;
//
//		nextPage = "redirect:/bookUpdate.do";

		return "nboardUpdate";
	}

}
