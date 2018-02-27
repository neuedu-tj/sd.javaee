package web.util;

import java.util.List;

import com.model.Product;

public class PageBean {

	private List<Product> data;
	
	private int currPage = 1 ;  // 当前页
	private int totalRows ;  // 总记录数
	private int totalPage ;   // 总页数 ( 需要计算才能获取 )
	private int pageSize = 3 ;  // 每页显示多少条数据 ...  
	
	public List<Product> getData() {
		return data;
	}
	public void setData(List<Product> data) {
		this.data = data;
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPage() {
		
		if(totalRows%pageSize==0 ) {
			totalPage = totalRows/ pageSize;
		} else {
			totalPage = (totalRows/ pageSize) + 1;
		}
		
		return totalPage ;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "PageBean [data=" + data + ", currPage=" + currPage + ", totalRows=" + totalRows + ", totalPage="
				+ getTotalPage() + ", pageSize=" + pageSize + "]";
	}
	
	
	
	
	
	
}
