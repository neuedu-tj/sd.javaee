package com.servlet.handler;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class VedioUploadHandler implements Runnable {
	
	private InputStream in ;
	private File file;
	
	
	public VedioUploadHandler() {
	}
	
	public VedioUploadHandler(InputStream in , File file) {
		this.in = in;
		this.file = file;
	}
	
	@Override
	public void run() {
		try {
			
			
			FileUtils.copyInputStreamToFile(in, file);
			System.out.println("人为延迟 2 秒 .  ");
			Thread.sleep(2000);
			
		} catch (Exception e) {
			System.err.println("子线程  上传文件出错 . . . . ");
			e.printStackTrace();
		}
		
	}

}
