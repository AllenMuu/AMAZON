package com.amazon.utils;

public class StringUtils {
	
	/**
	 * 替换特殊符号
	 * @param content
	 * @return
	 */
	public static String replaceCode(String content){
		String res = "";
		res=content.replaceAll(" ", "&nbsp;");
		res=res.replaceAll("<", "&lt;");
		res=res.replaceAll(">", "&gt;");
		res=res.replaceAll("\r\n", "<br/>");
		res=res.replaceAll("\"", "&quot;");
		return res;
	}

}
