package cn.ll.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ll.domain.Product;
import cn.ll.service.ProductService;

/**   
*    
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�ProductInfoServlet   
* ��������  ���մ�ǰ̨�������ƷID�ţ�׼�����ݣ� ��ʾ��Ʒ����ϸ��Ϣ
* �����ˣ�LL   
* ����ʱ�䣺2017��8��27�� ����9:19:37   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��27�� ����9:19:37   
* �޸ı�ע��   
* @version    
*    
*/
public class ProductInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�õ���Ʒ��ID��
		String pid = request.getParameter("pid");
		
		//����service�ķ�����ѯ��Ʒ����Ϣ
		ProductService productService = new ProductService();
		Product product = productService.selectProductById(pid);
		
		//���õ�����Ʒ��Ϣ�ŵ�request����
		request.setAttribute("productInfo", product);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}