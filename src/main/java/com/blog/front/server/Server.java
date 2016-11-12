package com.blog.front.server;

import com.jfinal.core.JFinal;

public class Server {

	public static void main(String[] args) {
		JFinal.start("WebRoot", 10000, "/", 5); 
	}

}
