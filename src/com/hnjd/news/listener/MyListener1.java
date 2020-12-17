package com.hnjd.news.listener;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

import com.hnjd.news.util.LogsUtil;

public class MyListener1 implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		LogsUtil.printToDisk("��������....");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		LogsUtil.printToDisk("�����ʼ��..[ʵʱ�����־]"+getIpAddress((HttpServletRequest) arg0.getServletRequest())+"��ʼ���з���");
		
	}
	public String getIpAddress(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// ��������ȡ�������õ�IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// ����ͨ�����������������һ��IPΪ�ͻ�����ʵIP,���IP����','�ָ�
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}
}
