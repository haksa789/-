package com.pongdong.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.pongdong.web.entity.Notice;
import com.pongdong.web.service.NoticeService;
import com.pongdong.web.service.jdbc.JDBCNoticeService;

public class ListController implements Controller {

	private NoticeService noticeService;
	
	public void setNoticeService(JDBCNoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ModelAndView mv = new ModelAndView("notice.list");
		//mv.setViewName("/WEB-INF/view/notice/list.jsp");
		List<Notice> list = noticeService.getList(0, "TITLE", "");
		mv.addObject("list",list);
		
		return mv;
	}

}
