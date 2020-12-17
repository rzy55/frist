package com.hnjd.news.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogsUtil {

	public static void printToDisk(String message) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("D://logs.txt"));
			Date date = new Date();
			SimpleDateFormat systemTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			out.println("[��ؼ�¼]"+systemTime+"------"+message);
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		out.close();
		
	}
}
