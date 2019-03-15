package com.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vo.BoardMasterVO;

@Service
public class BoardLogic {
	Logger logger = Logger.getLogger(BoardLogic.class);
	@Autowired
	private BoardMasterDao boardMasterDao = null;

	public List<Map<String, Object>> boardList(BoardMasterVO bmVO) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardMasterDao.boardList(bmVO);
		return boardList;
	}

	public List<BoardMasterVO> jsonBoardList(BoardMasterVO bmVO) {
		logger.info("boardList 호출 성공");
		List<BoardMasterVO> jsonBoardList = null;
		jsonBoardList = boardMasterDao.jsonBoardList(bmVO);
		return jsonBoardList;
	}
}
