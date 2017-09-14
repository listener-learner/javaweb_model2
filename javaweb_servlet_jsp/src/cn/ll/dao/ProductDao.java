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
	 * ��ѯ������Ʒ��Ϣ
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
	 * ����������ѯ��Ʒ��Ϣ
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
	 * ��ѯ���е���Ʒ����
	 * @return
	 * @throws SQLException
	 */
	public int getTotalCount() throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		
		String sql = "select count(*) from product";
		//ע�����ﷵ�ص���Long�����͵���
		Long query = (Long) runner.query(sql, new ScalarHandler());
		//���ص�����Ϊint�ͣ���Ҫ��������ת��
		return query.intValue();
	}

	/**
	 * ��ҳ��ѯ��ǰҳ��������Ʒ��Ϣ
	 * @param index
	 * @param currentCount
	 * @return
	 * @throws SQLException
	 */
	public List<Product> getCurrentList(int index, int currentCount) throws SQLException {
		
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		//��ҳ��ѯ
		String sql = "select * from product limit ?,?";
		
		List<Product> currentList = runner.query(sql, new BeanListHandler<Product>(Product.class), index,currentCount);
		
		return currentList;
	}

}
