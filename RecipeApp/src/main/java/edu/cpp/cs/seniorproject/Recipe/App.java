package edu.cpp.cs.seniorproject.Recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.cpp.cs.seniorproject.Recipe.manager.IntRecipePersister;
import edu.cpp.cs.seniorproject.Recipe.manager.RecipePersister;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class App 
{
	
	@Bean
	public IntRecipePersister persister(){
		IntRecipePersister persister = new RecipePersister();
		return persister;
	}
	
    public static void main( String[] args ) throws Exception
    {
        SpringApplication.run(App.class, args);
    }
}
