package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppConfig implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println("生命周期结束 . . . ");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("App / 容器 / 启动 / Servlet 生命周期初始化 . . .. .. ");
    }
	
}
