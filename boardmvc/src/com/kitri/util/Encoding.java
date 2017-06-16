package com.kitri.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Encoding {
	
	public static String nullToBlank(String tmp) {
		return tmp == null ? "" : tmp; //�������� ���ֱ� ����.
	}

	public static String isoToEuc(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	
	public static String urlFormat(String tmp){
		String url = "";
		try {
			if (url != null) {				
				url = URLEncoder.encode(tmp, "EUC-KR");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
	
}
