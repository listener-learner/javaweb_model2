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
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�LoginServlet   
* ��������  ��ȡ�û���¼��Ϣ���ж���֤���Ƿ���ȷ �����õ����û��������봫�ݵ�service����д���ָ����ʾ��jspҳ��
* �����ˣ�LL   
* ����ʱ�䣺2017��8��23�� ����3:31:48   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��23�� ����3:31:48   
* �޸ı�ע��   
* @version    
*    
*/
public class LoginServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע����������post�ύ��ʽ���������������
		request.setCharacterEncoding("utf-8");
		
		//��ȡ������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkcode = request.getParameter("checkcode");
		
		HttpSession session = request.getSession();
		//������ɵ���֤�����Ϣ	ע������л�õ�ֵ��object������Ҫ����ǿ������ת��
		String checkcode_session = (String) session.getAttribute("checkcode_session");
		//System.out.println(checkcode_session);
		if(checkcode!=""&&checkcode!=null){
			if(checkcode_session.equals(checkcode)){
				
				LoginService login = new LoginService();
				//����service�ķ��������û���¼��Ϣ
				User user = login.validateInfo(username,password);
				
				if(user!=null){
					session.setAttribute("user", user);
					//����¼�ɹ������ض���ķ�ʽת����ӭҳ�棬��ַ����ַ�����仯
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else{
					request.setAttribute("loginInfo","�û������������");
					//����¼ʧ��ת������ǰҳ�棬���д�����Ϣ����
					request.getRequestDispatcher("/login.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("loginInfo","��֤�����");
				//����¼ʧ��ת������ǰҳ�棬���д�����Ϣ����
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}	
		}else{
			request.setAttribute("loginInfo","��֤��Ϊ��");
			//����¼ʧ��ת������ǰҳ�棬���д�����Ϣ����
			request.getRequestDispatcher("/login.jsp").forward(request,response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}