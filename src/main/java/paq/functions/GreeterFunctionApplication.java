package paq.functions;

import java.util.Properties;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(Properties.class)
public class GreeterFunctionApplication implements ApplicationContextInitializer<GenericApplicationContext> {

	public static void main(String[] args) {
		SpringApplication.run(GreeterFunctionApplication.class, args);
	}

	public GreeterFunctionApplication() {
	}

	@Bean
	public Function<String, String> function() {
		return new GreeterFunction();
	}

	@Override
	@SuppressWarnings("deprecation")
	public void initialize(GenericApplicationContext context) {
		context.registerBean("function", FunctionRegistration.class,
				() -> new FunctionRegistration<Function<String, String>>(function())
						.type(FunctionType.from(String.class).to(String.class).getType()));

	}
}