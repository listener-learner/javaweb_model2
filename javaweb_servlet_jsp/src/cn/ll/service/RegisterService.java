package cn.ll.service;

import java.sql.SQLException;

import cn.ll.dao.UserDao;
import cn.ll.domain.User;

public class RegisterService {

	public int insertUser(User user) {

		UserDao userDao = new UserDao();
		int i = 0;
		try {
			i = userDao.insertUser(user);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return i;
	}

}
