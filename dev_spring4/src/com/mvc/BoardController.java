package com.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vo.BoardMasterVO;

@Controller
@RequestMapping(value="/board/")
public class BoardController {
	Logger logger = Logger.getLogger(BoardController.class);
	@Autowired
	private BoardLogic boardLogic = null;
	/**************************************************************
	 * 글 목록 조회 구현
	 * @param bmVO : 조건절에 들어갈 정보
	 * @param model : 응답페이지에 값을 전달할 때 
	 **************************************************************/
	@GetMapping("boardList")
	public String boardList(@ModelAttribute BoardMasterVO bmVO, Model model) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(bmVO);
		model.addAttribute("boardList", boardList);
		//jsonBoardList.jsp페이지의 생성 위치는 어디인가요?
		//WebContent이면 반환타입은 String
		//WEB-INF이면 반환타입은 void, ModelAndView
		//return "forward:./jsonBoardList.jsp";
		return "board/jsonBoardList";
		/*
		 * 정리포인트
		 * String을 리턴 타입으로 결정했다 하더라도 접두어에 forward 혹은 redirect가 붙지 않을 경우
		 * ViewResolver의 개입으로 WEB-INF아래 경로에서 해당 화면이름을 찾음.
		 * 주의사항 : 따라서 화면이름만 작성해야지 슬래쉬, 확장자를 붙이면 절대 안됨.(404에러 발생)
		 */
	}
	@GetMapping("jsonBoardList")
	@ResponseBody
	public List<BoardMasterVO> jsonBoardList(@ModelAttribute BoardMasterVO bmVO, Model model) {
		logger.info("jsonBoardList 호출 성공");
		List<BoardMasterVO> jsonBoardList = null;
		jsonBoardList = boardLogic.jsonBoardList(bmVO);
		return jsonBoardList;
	}
	
	//ModelAndView를 사용하는 경우
	@GetMapping("ModelboardList")
	public void boardList(@ModelAttribute BoardMasterVO bmVO) {
		logger.info("ModelAndView boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = new ArrayList<Map<String,Object>>();
		Map<String, Object> rmap = new HashMap<String,Object>();
		rmap.put("bm_writer", "김유신");
		boardList.add(rmap);
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("/board/boardList");
	}
	//String을 사용하는 경우
	@GetMapping("StringboardList")
	public String boardList(Model model) {
		logger.info("String boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = new ArrayList<Map<String,Object>>();
		Map<String, Object> rmap = new HashMap<String,Object>();
		rmap.put("bm_writer", "하하하");
		boardList.add(rmap);
		model.addAttribute("boardList", boardList);
		return "forward:boardList.jsp";
	}
}
