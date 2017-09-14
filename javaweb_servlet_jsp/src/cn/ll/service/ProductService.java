package cn.ll.service;

import java.sql.SQLException;
import java.util.List;

import cn.ll.dao.ProductDao;
import cn.ll.domain.Product;
import cn.ll.vo.PageBean;

public class ProductService {

	public List<Product> findAll() throws SQLException {

		// service��û��ҵ���߼��������dao�еķ����õ����е���Ʒ��Ϣ������
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
	 * ��װ��ҳ��ѯ��pageBean
	 * @param currentPage
	 * @param currentCount
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Product> findPageBean(int currentPage, int currentCount) throws SQLException {
		ProductDao productDao = new ProductDao();
		
		PageBean<Product> pageBean = new PageBean<Product>();
		//1����װ��ǰҳ
		pageBean.setCurrentPage(currentPage);
		//2����װ��ǰҳ��ʾ������
		pageBean.setCurrentCount(currentCount);
		//3����װ������
		int totalCount = productDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		//4����װ��ҳ��
		//��ʽΪ����ҳ��=Math.ceil(������/��ǰ��ʾ������) ����ȡ��;
		//ע��"/"Ϊ�������ţ���Ҫ������һ��ת��Ϊdouble����
		int totalPage = (int) Math.ceil(totalCount*1.0/currentCount);
		pageBean.setTotalPage(totalPage);
		//5����װ��ǰҳ��ʾ�������б�
		//��ҳ��ѯ������index = (��ǰҳ��-1)*currentCount;
		int index = (currentPage-1)*currentCount;
		
		List<Product> currentList = productDao.getCurrentList(index,currentCount); 
		pageBean.setCurrentList(currentList);
		
		return pageBean;
	}

	
}
