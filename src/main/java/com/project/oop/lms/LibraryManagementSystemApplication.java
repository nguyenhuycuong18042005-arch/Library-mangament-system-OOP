package com.project.oop.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LibraryManagementSystemApplication.class, args);


		Environment env = context.getEnvironment();
		String protocol = "http";
		String port = env.getProperty("server.port", "8080"); // Mặc định 8080 nếu không cấu hình
		String contextPath = env.getProperty("server.servlet.context-path", "/");


		try {
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			System.out.println("\tLocal: \t\t" + protocol + "://localhost:" + port + contextPath);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
