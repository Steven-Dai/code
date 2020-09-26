package site.daishuyang.dataway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.hasor.spring.boot.EnableHasor;

/**
 * @author steven
 */
@EnableHasor
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
