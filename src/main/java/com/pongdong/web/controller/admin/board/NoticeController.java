package com.pongdong.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list() {
	
		return "admin.board.notice.list";
	}

	@GetMapping("reg")
	public String reg() throws IllegalStateException, IOException {
	
		return "admin.board.notice.reg";
	}
		
	
	@PostMapping("reg")
	public String reg(String title, String content, String category, MultipartFile[] files, String[] sobongs,
			String sobong, HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		
		for (MultipartFile file : files) {
			long size = file.getSize();
			String fileName = file.getOriginalFilename();
			System.out.printf("filename : %s, filesize : %d\n", fileName, size);

			String webPath = "/static/upload";
			String realPath = ctx.getRealPath(webPath);
			System.out.printf("realPath : %s\n", realPath);
			File savePath = new File(realPath);

			if (!savePath.exists())
				savePath.mkdirs();
			realPath += File.separator + fileName;
			File savefile = new File("realPath");
			file.transferTo(savefile);

		}
		System.out.println(category);
		for (String s : sobongs)

			System.out.println(s);
		
		return "redirect:list";
		//return String.format("title:%s<br>content:%s<br>category:%s<br>", title, content, category);

	}
		
	@RequestMapping("edit")
	public String edit() {

		return "admin.board.notice.edit";
	}

	@RequestMapping("del")
	public String del() {

		return "admin.board.notice.del";
	}


}
