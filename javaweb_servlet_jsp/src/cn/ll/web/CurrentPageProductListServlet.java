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
* 项目名称：javaweb_servlet_jsp   
* 类名称：CurrentPageProductListServlet   
* 类描述： 分页查询中 显示当前页所有商品的信息 
* 创建人：LL   
* 创建时间：2017年8月27日 上午9:10:58   
* 修改人：LL   
* 修改时间：2017年8月27日 上午9:10:58   
* 修改备注：   
* @version    
*    
*/
public class CurrentPageProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获得当前页
		String currentPageStr = request.getParameter("currentPage");
		//判断是否为null，默认设置为1，即第一页
		if(currentPageStr==null) currentPageStr="1";
		//将其转为int类型
		int currentPage = Integer.parseInt(currentPageStr);
		//获得当前页显示的信息条数
		//设置为默认12条数据
		int currentCount = 12;
		 		
		PageBean<Product> pageBean = null;
		
		//调用service层的方法封装pageBean
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