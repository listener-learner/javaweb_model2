package cn.ll.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ll.domain.Product;
import cn.ll.service.ProductService;

/**   
*    
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�ProductListServlet   
* ��������  ���ӷ�ҳ��ʾ  �����Ʒ��Ϣ �ŵ�request���� ָ����ʾ��jspҳ��
* �����ˣ�LL   
* ����ʱ�䣺2017��8��23�� ����3:29:42   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��23�� ����3:29:42   
* �޸ı�ע��   
* @version    
*    
*/
public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// ����service�ķ����õ����е���Ʒ��Ϣ
		ProductService product = new ProductService();
		List<Product> productList = null;
		try {
			productList = product.findAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// ���õ���list���Ϸŵ�request����
		request.setAttribute("productList", productList);
		// ת����jspҳ�������ʾ
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}