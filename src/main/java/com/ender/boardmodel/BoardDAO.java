package com.ender.boardmodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/ender/mybatis/config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sqlsessionfactory exception");
		}
	}

//	전체 목록 검색
	public List<BoardVO> boardSearchAll(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("nboardSearchAll",vo);
		session.close();
		return list;

	}

//	작성한 글 등록
	public int boardInsert(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("nboardInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}

//	상세보기
	public BoardVO boardDetail(int bo_num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVO dto = session.selectOne("nboardDetail", bo_num);
		session.close();
		return dto;
	}

//	조회수 증가
	public void boardCount(int bo_num) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("nboardCount", bo_num);
		session.commit();
		session.close();
	}

//	글 삭제
	public int boardDelete(int bo_num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("nboardDelete", bo_num);
		session.commit();
		session.close();
		return cnt;
	}

//	글 수정
	public int boardUpdate(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("nboardUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}

//	조건 검색
	public List<BoardVO> boardSearch(BoardVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVO> list = session.selectList("nboardSearch", vo);
		session.close();
		return list;
	}
	
	//게시판 테이블 개수
	public int boardPageCount() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("nboardPageCount");
		session.close();
		return cnt;
	}
	

}
