package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class BuyCartListener implements HttpSessionAttributeListener {

	/* 当  session.setAttribute( key , value ) */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("session 监听事件-add : " + event.getValue().toString());
    }

    /* 当  session.removeAttribute( key ) */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	System.out.println("session 监听事件-remove : " + event.getValue().toString());
    }

	/*   */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	System.out.println("session 监听事件-replaced: " + event.getValue().toString());
    }
	
}
