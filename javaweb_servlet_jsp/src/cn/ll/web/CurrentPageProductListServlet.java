package cn.ll.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ll.domain.Product;
import cn.ll.service.ProductService;
import cn.ll.vo.PageBean;

/**   
*    
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�CurrentPageProductListServlet   
* �������� ��ҳ��ѯ�� ��ʾ��ǰҳ������Ʒ����Ϣ 
* �����ˣ�LL   
* ����ʱ�䣺2017��8��27�� ����9:10:58   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��27�� ����9:10:58   
* �޸ı�ע��   
* @version    
*    
*/
public class CurrentPageProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��õ�ǰҳ
		String currentPageStr = request.getParameter("currentPage");
		//�ж��Ƿ�Ϊnull��Ĭ������Ϊ1������һҳ
		if(currentPageStr==null) currentPageStr="1";
		//����תΪint����
		int currentPage = Integer.parseInt(currentPageStr);
		//��õ�ǰҳ��ʾ����Ϣ����
		//����ΪĬ��12������
		int currentCount = 12;
		 		
		PageBean<Product> pageBean = null;
		
		//����service��ķ�����װpageBean
		ProductService productService = new ProductService();
		try {
			pageBean = (PageBean<Product>) productService.findPageBean(currentPage,currentCount);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("pageBean", pageBean);
		
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}