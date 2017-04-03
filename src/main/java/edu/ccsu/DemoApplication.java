package edu.ccsu;

import java.io.FileNotFoundException;
import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.ccsu.helper.ClassifiersStore;
import edu.ccsu.helper.DataPivoter;

@EnableAutoConfiguration
@Configuration
@ComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		DataPivoter dp = new DataPivoter();
		// try {
		// dp.loadDataFile(new
		// File("src/main/resources/data/user_ratedmovies_RatingsOnly.dat"),
		// "src/main/resources/data/user_ratedmovies.arff");
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// }
		ClassifiersStore store = ClassifiersStore.getInstance();
		SpringApplication.run(DemoApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringApplication.class);
	}
}
