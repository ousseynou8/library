package library;

import library.model.Autor;
import library.model.Book;
import library.model.Loan;
import org.hibernate.boot.model.relational.Database;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	CommandLineRunner runner(){

		return args -> {
			Date date =new Date();
			date.setMonth(Calendar.FEBRUARY);
			date.setYear(2000);
			Autor autor = new Autor();
			autor.setAbout("hello ds");
			autor.setNationality("France");
			autor.setType("Ecrivant ");
			autor.setEmail("Bismark@Gmail.com");
			autor.setDateBirth(date);
			autor.setLasName("Bismark");
			autor.setFirstname("Boakye");
			autor.setSexe("Homme");
			autor.setPhoto("heleo.jpeg");




		};
	}
}
