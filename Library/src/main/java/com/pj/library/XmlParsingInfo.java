package com.pj.library;


import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.pj.library.dto.BookDto;
import com.pj.library.service.BookService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Log4j
public class XmlParsingInfo {
	@Setter(onMethod_ = @Autowired)
	private BookService service;

	// tag값 정보 가져오는 메서드
	private static String getTagValue(String tag, Element eElement) { // tag: 추출하고자 하는 값의 태그명 eElement: 값을 추출하고자 하는 XML
																		// 객체
		NodeList nList = null; // XML문서에서 지정된 태그를 가진 모든 요소를 담는 객체
		Node nValue = null; // 추출된 값을 나타내는 객체
		try {
			// eElement.getElementsByTagName(tag): 지정된 태그명을 가진 요소 가져오기 item(0): 첫 번째 요소
			// getChildNodes();: 해당 요소의 모든 자식 노드(childnode)를 NodeList로 가져오기
			nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
			// 첫 번째 값 가져오기
			nValue = nList.item(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	public List<BookDto> getData(int page, int perPage) {
		 List<BookDto> list = new ArrayList<>();

		    try {
		        String url = "https://api.odcloud.kr/api/15112642/v1/uddi:253ba864-742b-4ee3-8a8a-bb8662eacd02?page=" + page + "&perPage=" + perPage + "&returnType=XML&serviceKey=wOrpV%2BvcpiMB64exxi3DKh0bX0cyBJFRLolt8baWBWEl%2FdbADWrfKNEMi%2B1UoP8PNOTEf6QlBVy8bEHkC%2BQKLQ%3D%3D";
		        // Url를 xml 문서로 파싱하여 DOM document Object로 리턴한다.
		        DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance(); // DocumentBuilderFactory와
				// DocumentBuilder 클래스를 사용해서
				// URL에서 XML문서 가져오기
		        DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
		        Document doc = dBuilder.parse(url); // dom 객체로 파싱하기
				// DOM Tree가 XML 문서의 구조대로 완성될 수 있게 한다.
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				// 파싱할 tag
				// "perforInfo"의 노드를 모두 찾아 배열로 돌려준다.
				NodeList nList = doc.getElementsByTagName("perforList"); // perforInfo라는 태그를 파싱하여 nList에 저장하기
				System.out.println("파싱할 리스트 수 : " + nList.getLength());

		        for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		                // 노드 종류에는 대표적으로 Element, text가 있음
		                Element eElement = (Element) nNode;
		                BookDto dto = new BookDto();
						
						dto.setCategory(getTagValue("대분류", eElement)); // title이라는 태그 이름을 가진 eElement에서 값을 가져와서 dto객체의
						dto.setLibraryCode(Integer.parseInt(getTagValue("도서관구분코드", eElement)));
						dto.setLibraryName(getTagValue("도서관명", eElement));
						dto.setLibraryHomepageUrl(getTagValue("도서관홈페이지url", eElement));
						dto.setNumber(Integer.parseInt(getTagValue("번호", eElement)));
						dto.setTitle(getTagValue("제목", eElement));
						dto.setSubCategory(getTagValue("중분류", eElement));
						dto.setPublisher(getTagValue("출판사", eElement));
						dto.setFormat(getTagValue("형식", eElement));
						list.add(dto);
					}
				} // for end

		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		return list;
//        return dto;

	} // getData method end
}

