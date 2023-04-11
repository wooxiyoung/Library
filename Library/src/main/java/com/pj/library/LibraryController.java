package com.pj.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.library.dto.BookDto;
import com.pj.library.mapper.BookMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
@Controller
@Log4j
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {
	 @Autowired
	    private BookMapper libraryMapper;

	    @GetMapping("/booklist")
	    public String getBookList(Model model) {
	        List<BookDto> bookList = libraryMapper.booklist();
	        model.addAttribute("bookList", bookList);
	        return "booklist";
	    }
	    
	    @GetMapping("/list")
	    public String getData(@RequestParam int page, @RequestParam int perPage, Model model) {
	    XmlParsingInfo xml = new XmlParsingInfo();
	    List<BookDto> booklist = xml.getData(page, perPage);
	    model.addAttribute("list", booklist);
	    return "list";
	    }
	    
	    }
