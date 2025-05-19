package com.blackcat.soundfolio.soundfolio.config;

import com.blackcat.soundfolio.soundfolio.model.Mood;
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
                        "chill", "hype", "sad", "happy", "romantic", "introspective", "nostalgic",
                        "dreamy", "gritty", "uplifting", "dark", "bright", "rebellious",
                        "party", "study", "late night", "spacey", "workout"
                );

                List<Mood> moods = moodNames.stream()
                        .map(name -> Mood.builder().name(name).build())
                        .toList();

                moodsRepository.saveAll(moods);
                System.out.println("SEEDED MOODS.");
            }else{
                System.out.println("MOODS ALREADY SEEDED.");
            }
        };
    }

}
