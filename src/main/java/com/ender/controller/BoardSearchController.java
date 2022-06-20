package com.ender.controller;

import java.io.IOException; 
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;
import com.ender.boardmodel.BoardVO;

public class BoardSearchController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String part = request.getParameter("part");
		String searchData = request.getParameter("searchData");
		BoardVO vo = new BoardVO();
		vo.setPart(part);
		vo.setSearchData("%"+searchData+"%");
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.boardSearch(vo);
		request.setAttribute("list", list);
		
		return "nboardSearchList";
	}

}
