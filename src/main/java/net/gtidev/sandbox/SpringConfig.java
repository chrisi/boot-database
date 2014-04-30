package net.gtidev.sandbox;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("net.gtidev.sandbox")
//@ComponentScan({"net.gtidev.sandbox", "net.gtidev.sandbox.model"})
public class SpringConfig {
}
