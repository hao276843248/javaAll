package cn.sun.tree.entity;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	 public int id;//节点的编号
     public String text;//节点上的文字
     public List<TreeNode> children=new ArrayList<TreeNode>();//这个节点的子节点
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
     
}
