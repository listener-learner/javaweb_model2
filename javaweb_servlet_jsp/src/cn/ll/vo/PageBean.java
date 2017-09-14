package cn.ll.vo;

import java.util.List;

/**   
*    
* ��Ŀ���ƣ�javaweb_servlet_jsp   
* �����ƣ�PageBean   
* ��������  ��ҳ��ѯ��װ�����Է�װ����
* �����ˣ�LL   
* ����ʱ�䣺2017��8��26�� ����8:51:16   
* �޸��ˣ�LL   
* �޸�ʱ�䣺2017��8��26�� ����8:51:16   
* �޸ı�ע��   
* @version    
*    
*/

public class PageBean<T> {
	//��ǰҳ
	private int currentPage;
	//��ǰҳ��ʾ������
	private int currentCount;
	//������
	private int totalCount;
	//��ҳ��
	private int totalPage;
	//��ǰҳ��ʾ�������б�
	private List<T> currentList;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getCurrentList() {
		return currentList;
	}

	public void setCurrentList(List<T> currentList) {
		this.currentList = currentList;
	}

}
