package com.mvc;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vo.BoardMasterVO;

@RestController
@RequestMapping("/board/")
public class BoardRestController {
	Logger logger = Logger.getLogger(BoardRestController.class);
	@Autowired(required=false) //false:자동주입 끔 | true:자동주입 켬
	private BoardLogic boardLogic = null;
	@GetMapping("jsonRestBoardList")
	public List<BoardMasterVO> jsonRestBoardList(@ModelAttribute BoardMasterVO bmVO, Model model) {
		logger.info("jsonBoardList 호출 성공");
		List<BoardMasterVO> jsonRestBoardList = null;
		jsonRestBoardList = boardLogic.jsonBoardList(bmVO);
		return jsonRestBoardList;
	}
}
