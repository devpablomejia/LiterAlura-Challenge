package com.aluracursos.literAlura_Challenge;

import com.aluracursos.literAlura_Challenge.master.main;
import com.aluracursos.literAlura_Challenge.repository.AutorRepository;
import com.aluracursos.literAlura_Challenge.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraChallengeApplication  implements CommandLineRunner {
	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args)  {
		SpringApplication.run(LiterAluraChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main master = new main(libroRepository, autorRepository);
		master.mostrarMenu();
	}
}
