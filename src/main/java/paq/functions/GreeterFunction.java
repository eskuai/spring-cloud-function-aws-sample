package paq.functions;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("morcilla")
@Slf4j
public class GreeterFunction implements Function<String, String> {

	@Override
	public String apply(String s) {
		log.info("Hello " + s + ", and welcome to Spring Cloud Function!!!");
		return "Hello " + s + ", and welcome to Spring Cloud Function!!!";
	}
}