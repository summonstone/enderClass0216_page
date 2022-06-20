package com.ender.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;
import com.ender.boardmodel.BoardVO;

public class BoardInsertController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String bo_writer = request.getParameter("bo_writer");
		String bo_subject = request.getParameter("bo_subject");
		String bo_content = request.getParameter("bo_content");
		String bo_id = request.getParameter("bo_id");

		BoardVO vo = new BoardVO(bo_subject, bo_id, bo_content, bo_writer);
		vo.setBo_subject(bo_subject);
		vo.setBo_id(bo_id);
		vo.setBo_content(bo_content);
		vo.setBo_writer(bo_writer);

		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardInsert(vo);

		String nextPage = null;
		if (cnt > 0) {
			nextPage = "redirect:/boardList.do";
		} else {
			throw new ServletException("Not Insert");
		}

		return nextPage;

	}

}
