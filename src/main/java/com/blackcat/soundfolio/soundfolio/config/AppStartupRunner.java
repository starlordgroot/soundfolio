package com.blackcat.soundfolio.soundfolio.config;

import com.blackcat.soundfolio.soundfolio.repository.MoodsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppStartupRunner {

    @Bean
    CommandLineRunner seedMoodListInDatabase(MoodsRepository moodsRepository){
        return args -> {
            if (moodsRepository.count() == 0){
                List<String> moodNames = List.of(
                        "chill", "nostalgic", "rage", "ethereal",
                        "melancholy", "uplifting", "gritty", "romantic",
                        "bittersweet", "spacey", "moody", "heartbroken"
                );
            }
        }
    }

}
