package cn.ll.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.ll.domain.Product;
import cn.ll.utils.C3P0Utils;

public class ProductDao {
	
	/**
	 * 查询所有商品信息
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product";

		List<Product> productList = runner.query(sql, new BeanListHandler<Product>(Product.class));

		return productList;
	}

	/**
	 * 根据主键查询商品信息
	 * @param pid
	 * @return
	 * @throws SQLException
	 */
	public Product selectProductById(String pid) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select * from product where pid=?";
		
		Product product = runner.query(sql, new BeanHandler<Product>(Product.class), pid);
		
		return product;
	}

	
	/**
	 * 查询所有的商品总数
	 * @return
	 * @throws SQLException
	 */
	public int getTotalCount() throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select count(*) from product";
		//注意这里返回的是Long长整型的数
		Long query = (Long) runner.query(sql, new ScalarHandler());
		//返回的类型为int型，需要进行类型转换
		return query.intValue();
	}

	/**
	 * 分页查询当前页的所有商品信息
	 * @param index
	 * @param currentCount
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getCurrentList(int index, int currentCount) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//分页查询
		String sql = "select * from product limit ?,?";
		
		List<Product> currentList = runner.query(sql, new BeanListHandler<Product>(Product.class), index,currentCount);
		
		return currentList;
	}

}
