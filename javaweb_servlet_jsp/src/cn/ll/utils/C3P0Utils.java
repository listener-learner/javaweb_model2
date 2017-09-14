package cn.ll.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**   
*    
* ��Ŀ���ƣ�jdbc_dbutils   
* �����ƣ�C3P0Utils   
* �������� C3P0���ӳع�����
* �����ˣ�LL   
* ����ʱ�䣺2017��7��9�� ����9:42:14   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��7��9�� ����9:42:14   
* �޸ı�ע��   
* @version    
*    
*/
public class C3P0Utils {
	//���徲̬����
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();
	//�ṩ���ӷ���
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			//���������ִ����쳣�ķ�ʽ�����ɸú���û�з���ֵ�����(�������쳣)
			//e.printStackTrace();
		}
	}
	//�ṩ����Դ
	public static DataSource getDataSource(){
		return datasource;
	}

}
