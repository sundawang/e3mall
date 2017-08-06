package cn.e3mall.common;

import java.io.Serializable;
import java.util.List;

public class DataGridResult implements Serializable{
	private Integer total;
	private List rows;
	
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
