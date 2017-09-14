package cn.ll.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.ll.domain.User;
import cn.ll.utils.C3P0Utils;

public class UserDao {
	private static QueryRunner runner = null;
	static{
		runner = new QueryRunner(C3P0Utils.getDataSource());
	}

	public User selectUserByInfo(String username, String password) throws SQLException {
		
		
		
		String sql = "select * from user where username=? and password=?";
		
		User user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
		
		return user;
	}

	public int insertUser(User user) throws SQLException {
		
		String sql = "insert into user(uid,username,password,name,birthday,sex) values(?,?,?,?,?,?)";
		
		int i = runner.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),user.getSex());
		
		
		return i;
	}

}
