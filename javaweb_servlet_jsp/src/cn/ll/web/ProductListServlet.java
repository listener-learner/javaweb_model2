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
* 项目名称：javaweb_servlet_jsp   
* 类名称：ProductListServlet   
* 类描述：  不加分页显示  获得商品信息 放到request域中 指定显示的jsp页面
* 创建人：LL   
* 创建时间：2017年8月23日 下午3:29:42   
* 修改人：LL   
* 修改时间：2017年8月23日 下午3:29:42   
* 修改备注：   
* @version    
*    
*/
public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 调用service的方法得到所有的商品信息
		ProductService product = new ProductService();
		List<Product> productList = null;
		try {
			productList = product.findAll();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		// 将得到的list集合放到request域中
		request.setAttribute("productList", productList);
		// 转发的jsp页面进行显示
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}