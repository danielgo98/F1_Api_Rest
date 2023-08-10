package com.dab.rest;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SpringBootF1GridApplication{
	

	public static void main(String[] args) throws IOException{
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootF1GridApplication.class, args);
		System.in.read();
		ctx.close();
	}

}
