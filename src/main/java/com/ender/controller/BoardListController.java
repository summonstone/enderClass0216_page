package com.ender.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ender.boardmodel.BoardDAO;
import com.ender.boardmodel.BoardVO;
import com.ender.boardmodel.PageVO;

public class BoardListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<BoardVO> list = new ArrayList<BoardVO>();
//		int page =  Integer.parseInt(request.getParameter("page"));
		int page =  1;
		int limit = 10;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardVO vo = new BoardVO(page, limit);

//		if (request.getParameter("page") != null) {
//			page = Integer.parseInt(request.getParameter("page"));
//		}
		
		BoardDAO dao = new BoardDAO();
		int listCount = dao.boardPageCount();
		list = dao.boardSearchAll(vo);

		int maxPage = (int) ((double) listCount / limit + 0.95);

//		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int startPage = (((int) ((double) (page -1)/ 10))) * 10 + 1;

		int endPage = startPage + 10 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageVO pvo = new PageVO();
		pvo.setEndPage(endPage);
		pvo.setListCount(listCount);
		pvo.setMaxPage(maxPage);
		pvo.setPage(page);
		pvo.setStartPage(startPage);

		request.setAttribute("pvo", pvo);
		request.setAttribute("list", list);

		return "nboardList";
	}

}
