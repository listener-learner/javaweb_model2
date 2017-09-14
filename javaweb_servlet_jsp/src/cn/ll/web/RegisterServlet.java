package cn.ll.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.ll.domain.User;
import cn.ll.service.RegisterService;

/**   
*    
* 项目名称：javaweb_servlet_jsp   
* 类名称：RegisterServlet   
* 类描述：  用户注册功能，对前台传入的用户注册信息进行封装，传递到service层 
* 创建人：LL   
* 创建时间：2017年8月27日 上午9:21:48   
* 修改人：LL   
* 修改时间：2017年8月27日 上午9:21:48   
* 修改备注：   
* @version    
*    
*/
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//处理post提交的乱码问题
		request.setCharacterEncoding("utf-8");
		
		//获取表单提交的数据
		
		Map<String, String[]> userMap = request.getParameterMap();
		
		User user = new User();
		
		//采用BeanUtils的方式进行获取和封装
		//将jsp中的name值与user中的属性名一致的进行封装
		try {
			BeanUtils.populate(user, userMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		//现在user对象已经封装好了，接下来手动封装主键uid
		//使用UUID随机生成字符串，UUID随机生成不重复的32位字符串，Java代码生成后是36位的，中间多了四个"-"
		user.setUid(UUID.randomUUID().toString());
		
		//调用业务层的方法对数据进行处理
		RegisterService register = new RegisterService();
		int i = register.insertUser(user);
		
		//判断是否注册成功
		if(i==1){
			//注册成功，重定向到登录页面
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			request.setAttribute("registerInfo", "注册不成功，请稍后再试！");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}