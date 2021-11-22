package dto;

public class StudyDto {
	private int id;
	private String name;
	private int kor;
	private int eng;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public StudyDto(int id, String name, int kor, int eng) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
	}
	
	public StudyDto() {
		super();
	}
}
