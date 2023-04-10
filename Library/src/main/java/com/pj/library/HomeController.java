package com.pj.library;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pj.library.dto.BookDto;
import com.pj.library.mapper.BookMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	 @Autowired
	    private BookMapper libraryMapper;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<BookDto> bookList = libraryMapper.booklist();
        model.addAttribute("bookList", bookList);;
		
		return "index";
	}

	    

	@GetMapping("/booklist")
	public String showBookListPage() {
	    return "booklist";
	}
}
