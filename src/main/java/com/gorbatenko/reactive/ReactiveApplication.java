package com.gorbatenko.reactive;

import com.gorbatenko.reactive.client.GreetingWebClient;
import com.gorbatenko.reactive.client.PersonWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);

		GreetingWebClient gwc = new GreetingWebClient();
		System.out.println(gwc.getResult());

		PersonWebClient pwc = new PersonWebClient();
		System.out.println(pwc.getResult());

	}

}
