package com.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.BoardMasterVO;

public class BoardMasterDao {
	Logger logger = Logger.getLogger(BoardMasterDao.class);
	
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("boardList 호출 성공");
		//NullPointerException의 대상이 되는 클래스이므로 인스턴스화를 완성함.
		//주의사항 : myBatis에서 자동으로 Map담아주는데 이 때 키값은 대문자가 디폴트값.
		List<Map<String, Object>> boardList = new ArrayList<Map<String, Object>>();
		try {
			boardList = sqlSessionTemplate.selectList("boardList", bmVO);
			logger.info("size: " + boardList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	public List<BoardMasterVO> jsonBoardList(BoardMasterVO bmVO) {
		logger.info("boardList 호출 성공");
		//NullPointerException의 대상이 되는 클래스이므로 인스턴스화를 완성함.
		//주의사항 : myBatis에서 자동으로 Map담아주는데 이 때 키값은 대문자가 디폴트값.
		List<BoardMasterVO> jsonBoardList = new ArrayList<BoardMasterVO>();
		try {
			jsonBoardList = sqlSessionTemplate.selectList("jsonBoardList", bmVO);
			logger.info("size: " + jsonBoardList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonBoardList;
	}
}
