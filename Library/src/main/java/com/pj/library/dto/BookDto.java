package com.pj.library.dto;


import lombok.Data;

@Data
public class BookDto {

	private String 대분류;
	private Integer 도서관구분코드;
	private String 도서관명;
	private String 도서관홈페이지url;
	private Integer 번호;
	private String 제목;
	private String 중분류;
	private String 출판사;
	private String 형식;
}
