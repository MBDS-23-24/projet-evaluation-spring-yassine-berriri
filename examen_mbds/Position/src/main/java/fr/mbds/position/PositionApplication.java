package fr.mbds.position;

import fr.mbds.position.clients.SkillProxy;
import fr.mbds.position.entities.PositionEntity;
import fr.mbds.position.models.Skill;
import fr.mbds.position.repositories.PositionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class PositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PositionRepository positionRepository, SkillProxy skillClient){
		return args -> {
			// Assigner manuellement les IDs
			PositionEntity position1 = new PositionEntity(1L, "Développeur Java", 50000.0, null, List.of(1L, 2L)); // Supposons que les compétences avec ID 1 et 2 existent déjà
			PositionEntity position2 = new PositionEntity(2L, "Architecte logiciel", 70000.0, null, List.of(2L, 3L)); // Supposons que les compétences avec ID 2 et 3 existent déjà

			positionRepository.save(position1);
			positionRepository.save(position2);
			// Sauvegardez d'autres entités au besoin
		};
	}



}
