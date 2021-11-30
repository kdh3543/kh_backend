package kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kh.web.dto.MemberDto;

public class MemberDao {
	private static MemberDao instance = null;
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	private MemberDao() {}

	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}

	public boolean isIdExist(String id) throws Exception{
		String sql = "select * from member where id =?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery();){
				return rs.next();
			}
		}

	}

	public int insert(MemberDto dto) throws Exception{
		String sql = "insert into member values (?, ?, ?, ?, ?,"
				+ "?, ?, ?, sysdate)";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setString(4, dto.getPhone());
			pstat.setString(5, dto.getEmail());
			pstat.setString(6, dto.getZipcode());
			pstat.setString(7, dto.getAddress1());
			pstat.setString(8, dto.getAddress2());

			int result = pstat.executeUpdate();
			return result;
		}
	}

	public boolean login(String id, String pw) throws Exception{
		String sql = "select * from member where id=? and pw=?";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, id);
			pstat.setString(2, pw);
			try(ResultSet rs =pstat.executeQuery();){
				return rs.next();
			}
		}
	}

	public int delete(Object id) throws Exception{
		String sql = "delete member where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql)){
			pstat.setString(1, (String) id);
			int result = pstat.executeUpdate();

			return result;
		}
	}

	public int update(MemberDto dto) throws Exception{
		String sql = "update member set pw=?, name=?, phone=?, email=?, zipcode=?,address1=?,address2=?"
				+ "where id = ? ";

		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){		
			pstat.setString(1, dto.getPw());
			pstat.setString(2, dto.getName());
			pstat.setString(3, dto.getPhone());
			pstat.setString(4, dto.getEmail());
			pstat.setString(5, dto.getZipcode());
			pstat.setString(6, dto.getAddress1());
			pstat.setString(7, dto.getAddress2());
			pstat.setString(8, dto.getId());

			int result = pstat.executeUpdate();
			return result;
		}
	}

	public MemberDto selectAll(String id) throws Exception{
		String sql = "select * from member where id = ?";
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, id);
			try(ResultSet rs = pstat.executeQuery();){
				MemberDto dto=null;
				if(rs.next()) {
					String dbId = rs.getString("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					String zipcode = rs.getString("zipcode");
					String address1 = rs.getString("address1");
					String address2 = rs.getString("address2");
					Date signup_date = rs.getDate("signup_date");
					
					dto = new MemberDto(dbId,pw,name,phone,email,zipcode,address1,address2,null);
					
				}
				return dto;
			}
		}
	}
}
