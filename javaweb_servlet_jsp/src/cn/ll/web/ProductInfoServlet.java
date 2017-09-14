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
* 项目名称：javaweb_servlet_jsp   
* 类名称：ProductInfoServlet   
* 类描述：  接收从前台传入的商品ID号，准备数据， 显示商品的详细信息
* 创建人：LL   
* 创建时间：2017年8月27日 上午9:19:37   
* 修改人：LL   
* 修改时间：2017年8月27日 上午9:19:37   
* 修改备注：   
* @version    
*    
*/
public class ProductInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//得到商品的ID号
		String pid = request.getParameter("pid");
		
		//调用service的方法查询商品的信息
		ProductService productService = new ProductService();
		Product product = productService.selectProductById(pid);
		
		//将得到的商品信息放到request域中
		request.setAttribute("productInfo", product);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}