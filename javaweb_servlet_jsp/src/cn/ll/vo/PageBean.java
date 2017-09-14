package cn.ll.vo;

import java.util.List;

/**   
*    
* 项目名称：javaweb_servlet_jsp   
* 类名称：PageBean   
* 类描述：  分页查询封装的属性封装的类
* 创建人：LL   
* 创建时间：2017年8月26日 下午8:51:16   
* 修改人：LL   
* 修改时间：2017年8月26日 下午8:51:16   
* 修改备注：   
* @version    
*    
*/

public class PageBean<T> {
	//当前页
	private int currentPage;
	//当前页显示的条数
	private int currentCount;
	//总条数
	private int totalCount;
	//总页数
	private int totalPage;
	//当前页显示的数据列表
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
