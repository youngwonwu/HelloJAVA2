package co.micol.student.dto;

import java.sql.Date;

import lombok.Data;

//lombok 사용하면 게터/세터 이렇게 쓰면 됨
//@Setter
//@Getter
@Data	//@Setter + @Getter
public class StudentVO {
	
	//Dto or VO는
	//보호객체이고
	//맴버변수와 게터/세터로 이루어짐

	private String studentId;
	private String name;
	private Date birthday;
	private String major;
	private String address;
	private String tel;
	
	
//	public String getStudentId() {
//		return studentId;
//	}
//	public void setStudentId(String studentId) {
//		this.studentId = studentId;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public Date getBirthday() {
//		return birthday;
//	}
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
//	
//	public String getMajor() {
//		return major;
//	}
//	public void setMajor(String major) {
//		this.major = major;
//	}
//	
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}

	
	@Override
	public String toString() {
		System.out.print(studentId + " | ");
		System.out.print(name + " | ");
		System.out.print(birthday + " | ");
		System.out.print(major + " | ");
		System.out.print(address + " | ");
		System.out.println(tel + " | ");
		return null;
	}

}
