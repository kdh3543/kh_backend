package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ContactDto;


public class ContactDao {
	
	
	private static ContactDao instance = null;
	public static ContactDao getInstance() {
		if(instance==null) {
			instance=new ContactDao();
		}
		return instance;
	}
	// Singleton 관련 코드
	
	private ContactDao() {}	
	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		//									찾기위한resource/찾으려는 이름
		return ds.getConnection();
	}
	// JNDI 관련 코드
	
//	private Connection getConnection() throws Exception{
//		String userName = "kh";
//		String password = "kh";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		Connection con = DriverManager.getConnection(url,userName,password);
//		return con;
//	}
	
	public int insert(String name, String contact) throws Exception{
		String sql = "insert into contact values(contact_seq.nextval,?,?)";
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
				pstat.setString(1, name);
				pstat.setString(2, contact);
				int result = pstat.executeUpdate();
				return result;
			}
	}
	
	public List<ContactDto> selectAll() throws Exception{
		String sql = "select * from contact order by 1";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			
			List<ContactDto> list = new ArrayList();
			
			while(rs.next()) {
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				ContactDto dto = new ContactDto(seq,name,contact);
				list.add(dto);
			}
			return list;
		}
	}
	
	public int delete(int delSeq) throws Exception{
		String sql = "delete from contact where seq=?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, delSeq);
			int result = pstat.executeUpdate();
			return result;
		}
		
	}
	
	public int update(int id, String name, String contact) throws Exception{
		String sql = "update contact set name = ?, contact = ? where seq = ?";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, name);
			pstat.setString(2, contact);
			pstat.setInt(3, id);
			
			int result = pstat.executeUpdate();
			return result;
		}
	}
}
