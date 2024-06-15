package ru.netology.daowithhibernate;

import ru.netology.daowithhibernate.entity.Person;
import ru.netology.daowithhibernate.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class DaoHibernateApplication implements CommandLineRunner {
	@PersistenceContext
	EntityManager entityManager;

	public DaoHibernateApplication(PersonRepository personRepository) {

		this.personRepository = personRepository;
	}

	PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DaoHibernateApplication.class, args);

	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		Person ibragim = new Person();
		ibragim.setName("Ибрагим");
		ibragim.setSurname("Ахмедов");
		ibragim.setAge(25);
		ibragim.setCityOfLiving("Moscow");
		ibragim.setPhoneNumber("+75764981");

		Person klim = new Person();
		klim.setName("Клим");
		klim.setSurname("Чугункин");
		klim.setAge(26);
		klim.setCityOfLiving("St. Petersburg");
		klim.setPhoneNumber("+75764982");

		Person daniil = new Person();
		daniil.setName("Даниил");
		daniil.setSurname("Петровский");
		daniil.setAge(27);
		daniil.setCityOfLiving("Kazan");
		daniil.setPhoneNumber("+75764983");

		Person gavrila = new Person();
		gavrila.setName("Гаврила");
		gavrila.setSurname("Ильин");
		gavrila.setAge(28);
		gavrila.setCityOfLiving("Rostov");
		gavrila.setPhoneNumber("+75764984");

		Person islam = new Person();
		islam.setName("Ислам");
		islam.setSurname("Мамедов");
		islam.setAge(29);
		islam.setCityOfLiving("Sochi");
		islam.setPhoneNumber("+75764985");

		personRepository.save(ibragim);
		personRepository.save(klim);
		personRepository.save(daniil);
		personRepository.save(gavrila);
		personRepository.save(islam);

	}
}