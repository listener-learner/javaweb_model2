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
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�RegisterServlet   
* ��������  �û�ע�Ṧ�ܣ���ǰ̨������û�ע����Ϣ���з�װ�����ݵ�service�� 
* �����ˣ�LL   
* ����ʱ�䣺2017��8��27�� ����9:21:48   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��27�� ����9:21:48   
* �޸ı�ע��   
* @version    
*    
*/
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����post�ύ����������
		request.setCharacterEncoding("utf-8");
		
		//��ȡ���ύ������
		
		Map<String, String[]> userMap = request.getParameterMap();
		
		User user = new User();
		
		//����BeanUtils�ķ�ʽ���л�ȡ�ͷ�װ
		//��jsp�е�nameֵ��user�е�������һ�µĽ��з�װ
		try {
			BeanUtils.populate(user, userMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		//����user�����Ѿ���װ���ˣ��������ֶ���װ����uid
		//ʹ��UUID��������ַ�����UUID������ɲ��ظ���32λ�ַ�����Java�������ɺ���36λ�ģ��м�����ĸ�"-"
		user.setUid(UUID.randomUUID().toString());
		
		//����ҵ���ķ��������ݽ��д���
		RegisterService register = new RegisterService();
		int i = register.insertUser(user);
		
		//�ж��Ƿ�ע��ɹ�
		if(i==1){
			//ע��ɹ����ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			request.setAttribute("registerInfo", "ע�᲻�ɹ������Ժ����ԣ�");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}