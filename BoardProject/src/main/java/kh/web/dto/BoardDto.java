package kh.web.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDto {
	private int seq;
	private String writer;
	private String title;
	private String contents;
	private Timestamp write_date;
	private int view_count;
	
	public BoardDto() {}

    public BoardDto(int seq, String writer, String title, String contents, Timestamp write_date, int view_count) {
        this.seq = seq;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.write_date = write_date;
        this.view_count = view_count;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Timestamp getWrite_date() {
        return write_date;
    }

    public void setWrite_date(Timestamp write_date) {
        this.write_date = write_date;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

	  public String getFormedDate() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return sdf.format(write_date);
	    }
	    
	    public String getDetailDate() {
	        long current_time = System.currentTimeMillis(); // 현재 Timestamp
	        long write_time = write_date.getTime(); // 글 작성 시점의 Timestamp
	        long time_gap = (current_time - write_time) / 1000;
	        
	        if(time_gap < 60){
	            return "1분 이내";
	        } else if(time_gap < 300) {
	            return "5분 이내";
	        } else if(time_gap < 3600) {
	            return "1시간 이내";
	        } else if(time_gap < 86400) {
	            return "오늘";
	        } else {
	            return getFormedDate();            
	        }
	    }    
}
