package cn.ll.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**   
*    
* 项目名称：jdbc_dbutils   
* 类名称：C3P0Utils   
* 类描述： C3P0连接池工具类
* 创建人：LL   
* 创建时间：2017年7月9日 上午9:42:14   
* 修改人：LL   
* 修改时间：2017年7月9日 上午9:42:14   
* 修改备注：   
* @version    
*    
*/
public class C3P0Utils {
	//定义静态对象
	private static ComboPooledDataSource datasource = new ComboPooledDataSource();
	//提供连接方法
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
			//若采用这种处理异常的方式则会造成该函数没有返回值的情况(若出现异常)
			//e.printStackTrace();
		}
	}
	//提供数据源
	public static DataSource getDataSource(){
		return datasource;
	}

}
