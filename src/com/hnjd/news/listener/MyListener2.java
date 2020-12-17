package com.hnjd.news.listener;


import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;

import com.hnjd.news.util.LogsUtil;

public class MyListener2 implements SessionListener,HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		LogsUtil.printToDisk("httpsession:"+arg0.getSession());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		LogsUtil.printToDisk("httpsession:"+arg0.getSession());
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		LogsUtil.printToDisk("httpsession:"+arg0.getSession()+":"+arg0.getSession().getAttribute(arg0.getName()));
		
	}

	@Override
	public void sessionEvent(SessionEvent arg0) {
		LogsUtil.printToDisk("");
		
	}

	
	
	
	
	

}
