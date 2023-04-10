package com.pj.library.service;

import java.util.List;

import com.pj.library.dto.BookDto;
import com.pj.library.mapper.BookMapper;

public class BookServiceImpl {
	private BookMapper mapper;
	
	public  List<BookDto> booklist(){
		return mapper.booklist();
	}

}
