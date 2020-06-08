package com.besh.ticketplus;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketPlusApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(TicketPlusApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("*** Start CommandLineRunner ***");
			System.out.println("* End CommandLine Runner");
		};
	}
}
