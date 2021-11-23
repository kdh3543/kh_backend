package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.StudyDto;

public class StudyDao {
	
	private static StudyDao instance = null;
	public static StudyDao getInstance() {
		if(instance==null) {
			instance = new StudyDao();
		}
		return instance;
	}
	
	private StudyDao() {}
	
	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle!");
		return ds.getConnection();
	}
	
	public int insert(String name, int kor, int eng) throws Exception{
		String sql = "insert into student values(student_seq.nextval,?,?,?)";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setInt(2, kor);
			pstat.setInt(3, eng);
			
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public int delete(int id) throws Exception{
		String sql = "delete from student where id = ?";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, id);
			int result = pstat.executeUpdate();
			return result;
		}
	}
	
	public List<StudyDto> selectAll() throws Exception{
		String sql = "select * from student order by 1";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			
				List<StudyDto> list = new ArrayList();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				
				StudyDto dto = new StudyDto(id, name, kor, eng);
				list.add(dto);
			}
			return list;
		}
	}
	
	public int update(int id, String name, int kor, int eng) throws Exception{
		String sql = "update student set name=?, kor=?, eng=? where id=?";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setInt(2, kor);
			pstat.setInt(3, eng);
			pstat.setInt(4, id);
			
			int result = pstat.executeUpdate();
			return result;
		}
	}
}
