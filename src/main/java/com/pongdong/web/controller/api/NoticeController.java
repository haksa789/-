package com.pongdong.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pongdong.web.entity.Notice;
import com.pongdong.web.service.NoticeService;

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public Notice list() throws ClassNotFoundException, SQLException{
		
		List<Notice> list = service.getList(1, "title" , "");
		
		return list.get(0);
	}
}
