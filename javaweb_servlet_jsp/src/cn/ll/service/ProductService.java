package cn.ll.service;

import java.sql.SQLException;
import java.util.List;

import cn.ll.dao.ProductDao;
import cn.ll.domain.Product;
import cn.ll.vo.PageBean;

public class ProductService {

	public List<Product> findAll() throws SQLException {

		// service中没有业务逻辑处理调用dao中的方法得到所有的商品信息并返回
		ProductDao product = new ProductDao();
		List<Product> productList = product.findAll();
		return productList;
	}

	public Product selectProductById(String pid) {
		
		ProductDao productDao = new ProductDao();
		Product product = null;
		try {
			product = productDao.selectProductById(pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product;
	}

	/**
	 * 封装分页查询的pageBean
	 * @param currentPage
	 * @param currentCount
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao productDao = new ProductDao();
		
		PageBean<Product> pageBean = new PageBean<Product>();
		//1、封装当前页
		pageBean.setCurrentPage(currentPage);
		//2、封装当前页显示的条数
		pageBean.setCurrentCount(currentCount);
		//3、封装总条数
		int totalCount = productDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//4、封装总页数
		//公式为：总页数=Math.ceil(总条数/当前显示的条数) 向上取整;
		//注意"/"为整除符号，需要将其中一个转换为double类型
		int totalPage = (int) Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);
		//5、封装当前页显示的数据列表
		//分页查询的索引index = (当前页数-1)*currentCount;
		int index = (currentPage-1)*currentCount;
		
		List<Product> currentList = productDao.getCurrentList(index,currentCount); 
		pageBean.setCurrentList(currentList);
		
		return pageBean;
	}

	
}
