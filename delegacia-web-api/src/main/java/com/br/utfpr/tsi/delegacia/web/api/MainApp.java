package com.br.utfpr.tsi.delegacia.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.br.utfpr.tsi.delegacia.web.api.controller.CSVLeitor;

@SpringBootApplication
@ComponentScan({"com.br.utfpr.tsi.delegacia.web.api"})
public class MainApp {	
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}
}