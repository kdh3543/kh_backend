package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.EmployeeDto;

public class EmployeeDao {
	private static EmployeeDao instance = null;
	
	public static EmployeeDao getInstance() {
		if(instance==null) {
			instance = new EmployeeDao();
		}
		return instance;
	}
	private EmployeeDao() {}
	
	private Connection getConnection() throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
	}
	
	public List<EmployeeDto> selectAll() throws Exception{
		String sql = "select e.emp_id,e.emp_name,d.dept_title,e.email from employee e "
				+ "join department d on (e.dept_code = d.dept_id) order by 1";
		
		try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
			
				List<EmployeeDto> list = new ArrayList<>();
			while(rs.next()) {
				int emp_id = rs.getInt("emp_id");
				String emp_name = rs.getString("emp_name");
				String dept_title = rs.getString("dept_title");
				String email = rs.getString("email");
				EmployeeDto dto = new EmployeeDto(emp_id,emp_name,dept_title,email);
				list.add(dto);
			}
			return list;
		}
	}
}
