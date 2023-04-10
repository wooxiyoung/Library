package com.pj.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pj.library.dto.BookDto;
@Service
public interface BookService {
	public List<BookDto> booklist();
}
