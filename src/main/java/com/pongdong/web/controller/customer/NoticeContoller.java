package com.pongdong.web.controller.customer;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pongdong.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")

public class NoticeContoller {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("list")
	public String list(@RequestParam(name = "p",defaultValue ="1") int page) throws ClassNotFoundException, SQLException {

		//String p = request.getParameter("p");
		System.out.println("page : " + page);
		
		//List<Notice> list = noticeService.getList(0, "TITLE", "");

		return "notice.list";
	}

	@RequestMapping("detail")
	public String Detail() {

		return "notice.detail";
	}
}
