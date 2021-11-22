package dto;

public class ContactDto {
	private int seq;
	private String name;
	private String contact;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public ContactDto(int seq, String name, String contact) {
		super();
		this.seq = seq;
		this.name = name;
		this.contact = contact;
	}
	public ContactDto() {
		super();
	}
	
}
