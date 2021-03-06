package co.micol.notice.service;

import java.sql.Date;

import lombok.Data;

@Data
public class NoticeVO {
	
	////1
	private int id;
	private String writer;
	private String title;
	private String subject;
	private Date wdate;
	private int hit;
	
	public String toString() {
		System.out.print(id + " | ");
		System.out.print(writer + " | ");
		System.out.print(title + " | ");
		System.out.print(wdate + " | ");
		System.out.println(hit);
		return null;
	}

}
