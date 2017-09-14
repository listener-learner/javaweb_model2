package cn.ll.service;

import java.sql.SQLException;

import cn.ll.dao.UserDao;
import cn.ll.domain.User;

public class LoginService {
	
	private String username1;
	private String password1;

	/**
	 * У���û���¼���������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public User validateInfo(String username, String password)  {
		this.username1 = username;
		this.password1 = password;
		
		UserDao userDao = new UserDao();
		User user = null;
		try {
			user = userDao.selectUserByInfo(username1,password1);
		} catch (SQLException e) {
			
			e.printStackTrace();
			//throw new RuntimeException(e);
		}
		return user;
		
	}

}
