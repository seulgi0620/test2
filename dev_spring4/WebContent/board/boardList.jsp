<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map"%>
<%
	List<Map<String, Object>> boardList = (List<Map<String, Object>>) request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/easyui_common.jsp"%>
</head>
<body>
	<script type="text/javascript">
	//기본 날짜 포맷을 재 정의
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?"0"+m:m)+'-'+(d<10?"0"+d:d);
	}
//날짜 포맷을 적용	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}
		$(document).ready(function() {//이름이 없는 함수 선언
			$('#tb_search').textbox({
				icons: [{
					iconCls:'icon-search',
					handler: function(e){
						/* var userInput = $("#cb_search option:selected").getText();
						$('#cb_search').change(function(){
						}); */
						
						$('#dg_board').datagird({
							method:"get",
							url:'./jsonRestBoardList?cb_search=bm_title&tb_search=테스트'
						});
					}
				}]
			});
			$('#linkBtnSearch').bind('click', function(){
		        alert('작성일조회버튼');
		    });
			/*================= CRUD버튼 시작 ==================*/
			$('#crudSel').bind('click', function(){
		        alert('조회버튼');

		        $('#dg_board').datagrid({
			        method:'get',
		            url:'./jsonBoardList'
		        });
		    });
			$('#crudIns').bind('click', function(){
		        alert('입력버튼');

		    });
			$('#crudUpd').bind('click', function(){
		        alert('수정버튼');
		    });
			$('#crudDel').bind('click', function(){
		        alert('삭제버튼');
		    });
			/*================= CRUD버튼 끝 ==================*/
			$('#pn_board').pagination({
				pageList: [5,10,15,20],
				pageSize : 5,
				total:<%=10%>
			});
			
			/*================= 글 목록 화면 관련 시작 ==================*/
			$('#dg_board').datagrid({
				url : '/board/boardList',
				columns : [ [ {
					field : 'bm_no',
					title : '글 번호',
					width : 60,
					align : 'center'
				}, {
					field : 'bm_title',
					title : '제목',
					width : 180,
					align : 'center'
				}, {
					field : 'bm_writer',
					title : '작성자',
					width : 80,
					align : 'center'
				}, {
					field : 'bm_date',
					title : '작성일',
					width : 80,
					align : 'center'
				}, {
					field : 'bs_fname',
					title : '첨부파일',
					width : 140,
					align : 'center'
				}, {
					field : 'bm_hit',
					title : '조회수',
					width : 60,
					align : 'center'
				} ] ]
			});
			/*================= 글 목록 화면 관련 끝 ==================*/
		});////////////////end of ready 이벤트 종료
	</script>
	<table align="center" width="700px">

		<!-- ToolBar 화면 시작 -->
		<tr>
			<td>
				<div id="tbar_board">
					<table width="100%" height="100px">
						<!-- 검색 조건 화면 시작 -->
						<tr>
							<td>
								<!-- 툴바 추가 중 조건검색 화면 시작 -->
								<div id="tb" style="padding: 2px 5px;">
									<!-- req.getParameter("cb_search"):String 
    									 select * from board_master_t
    									 where ?(컬럼) like %||?||% -->
									<select class="easyui-combobox" name="cb_search"
										panelHeight="auto" style="width: 100px">
										<option value="bm_title">제목</option>
										<option value="bm_content">내용</option>
										<option value="bm_writer">작성자</option>
									</select> 
									<input id="tb_search" name="tb_search" class="easyui-textbox" style="width: 300px"> 
										작성일: <input class="easyui-datebox" name="bm_date" style="width: 110px">
									<!-- 태그내에서 속성(width, align, href)이나  -->
									<a id="linkBtnSearch" class="easyui-linkbutton"
										iconCls="icon-search">Search</a>
									<!--         <a id="linkBtnSearch" href="javascript:btnSearch()" class="easyui-linkbutton" iconCls="icon-search">Search</a> -->

								</div> 
								<!-- 툴바 추가 중 조건검색 화면 끝 -->
							</td>
						</tr>
						<!-- 검색 조건 화면 끝 -->
						<!-- 버튼 추가 시작 -->
						<tr>
							<td align="left">
								<a id="crudSel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">조회</a> 
								<a id="crudIns" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">입력</a>
								<a id="crudUpd" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">수정</a> 
								<a id="crudDel" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">삭제</a>
							</td>
						</tr>
						<!-- 버튼 추가 끝 -->
					</table>
				</div>
			</td>
			<!-- ToolBar 화면 끝 -->
			<!-- 글 목록 화면 시작 -->
		<tr>
			<td>
				<table id="dg_board" class="easyui-datagrid" toolbar="#tbar_board"
					data-options="footer:pn_board" title="계층형 게시판"
					style="width: 700px; height: 400px">
				</table>

			</td>
		</tr>
	</table>
	<!-- 글 목록 화면 끝 -->
	<!-- 페이지 네이션 추가 시작 -->
	<div id="pn_board" class="easyui-pagination"
		style="background: #efefef; border: 1px solid #ccc;"></div>
	<!-- 페이지 네이션 추가 끝 -->

</body>
</html>