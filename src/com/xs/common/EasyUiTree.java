package com.xs.common;

import java.util.List;

public class EasyUiTree {
	
	private String id;
	
	private String text;
	
	private List<EasyUiTree> children;
	
	private String state;

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public List<EasyUiTree> getChildren() {
		return children;
	}

	public String getState() {
		return state;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setChildren(List<EasyUiTree> children) {
		this.children = children;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
