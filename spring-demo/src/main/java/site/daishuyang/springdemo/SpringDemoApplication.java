package site.daishuyang.springdemo;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringDemoApplication {

	@Resource
	private ApplicationArguments arguments;

	@Value("${my.name}")
	private String name;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringDemoApplication.class);
		application.setAddCommandLineProperties(false);
		application.setBannerMode(Banner.Mode.OFF);
		application.addListeners(new MyListener());
		ConfigurableApplicationContext context = application.run(args);
		SpringDemoApplication bean = context.getBean(SpringDemoApplication.class);
		bean.printArgs();
		System.out.println("bean.name=" + bean.name);
	}

	public void printArgs() {
		arguments.getOptionNames().forEach(a -> {
			System.out.println("参数：" + a + "=" + arguments.getOptionValues(a));
		});
	}

	@GetMapping(value = "/hello")
	public String test(HttpServletRequest request) {
		String lang = request.getParameter("lang");
		Locale locale = Locale.getDefault();
		if (lang != null) {
			String[] s = lang.split("_");
			locale = new Locale(s[0], s[1]);
		}
		ResourceBundle messages = ResourceBundle.getBundle("i18n/messages", locale);
		return String.format("Hello %s", messages.getString("username"));
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
