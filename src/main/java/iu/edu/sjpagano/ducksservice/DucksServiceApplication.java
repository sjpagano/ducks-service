package iu.edu.sjpagano.ducksservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class DucksServiceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DucksServiceApplication.class, args);
		Files.deleteIfExists(Paths.get("ducks/db.txt"));
	}

}
