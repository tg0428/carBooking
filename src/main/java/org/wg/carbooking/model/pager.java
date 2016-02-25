package org.wg.carbooking.model;

import java.util.List;

public class pager<T> {

	private int currentNum;

	private int pageSize;

	private int totalSize;
	
	private int totalRecord;
	
	private List<T> source;
	
	public pager(int currentNum, int pageSize, int totalSize, int totalRecord, List<T> source) {
		this.currentNum = currentNum;
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalRecord = totalRecord;
		this.source = source;
	}

	public int getCurrentNum() {
		return currentNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<T> getSource() {
		return source;
	}

	public void setSource(List<T> source) {
		this.source = source;
	}
}
