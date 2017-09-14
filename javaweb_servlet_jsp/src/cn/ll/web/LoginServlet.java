package cn.ll.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ll.domain.User;
import cn.ll.service.LoginService;

/**   
*    
* 项目名称：javaweb_servlet_jsp   
* 类名称：LoginServlet   
* 类描述：  获取用户登录信息，判断验证码是否正确 ，将得到的用户名和密码传递到service层进行处理，指定显示的jsp页面
* 创建人：LL   
* 创建时间：2017年8月23日 下午3:31:48   
* 修改人：LL   
* 修改时间：2017年8月23日 下午3:31:48   
* 修改备注：   
* @version    
*    
*/
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注意乱码问题post提交方式解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		//获取表单数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		
		HttpSession session = request.getSession();
		//获得生成的验证码的信息	注意从域中获得的值是object类型需要进行强制类型转换
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		//System.out.println(checkcode_session);
		if(checkcode!=""&&checkcode!=null){
			if(checkcode_session.equals(checkcode)){
				
				LoginService login = new LoginService();
				//调用service的方法传递用户登录信息
				User user = login.validateInfo(username,password);
				
				if(user!=null){
					session.setAttribute("user", user);
					//若登录成功采用重定向的方式转到欢迎页面，地址栏地址发生变化
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else{
					request.setAttribute("loginInfo","用户名或密码错误");
					//若登录失败转发到当前页面，进行错误信息回显
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("loginInfo","验证码错误");
				//若登录失败转发到当前页面，进行错误信息回显
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}	
		}else{
			request.setAttribute("loginInfo","验证码为空");
			//若登录失败转发到当前页面，进行错误信息回显
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}