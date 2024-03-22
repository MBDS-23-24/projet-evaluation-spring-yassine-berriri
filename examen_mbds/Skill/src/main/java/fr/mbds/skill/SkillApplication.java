package fr.mbds.skill;

import fr.mbds.skill.entities.SkillEntity;
import fr.mbds.skill.repositories.SkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SkillApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(SkillRepository skillRepository) {
		return args -> {
			SkillEntity javaSkill = SkillEntity.builder()
					.name("Java")
					.build();

			SkillEntity pythonSkill = SkillEntity.builder()
					.name("Python")
					.build();

			SkillEntity jsSkill = SkillEntity.builder()
					.name("JavaScript")
					.build();

			SkillEntity managementSkill = SkillEntity.builder()
					.name("Management")
					.build();

			SkillEntity cloudSkill = SkillEntity.builder()
					.name("Cloud Computing")
					.build();


			// Sauvegarder toutes les compétences en une seule opération
			skillRepository.saveAll(Arrays.asList(javaSkill, pythonSkill, jsSkill, managementSkill, cloudSkill));
		};
	}

}
