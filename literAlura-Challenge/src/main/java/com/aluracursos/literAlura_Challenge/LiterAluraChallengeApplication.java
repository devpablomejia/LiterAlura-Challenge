package com.aluracursos.literAlura_Challenge;

import com.aluracursos.literAlura_Challenge.master.main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication  implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main master = new main();
		master.mostrarMenu();
	}
}
