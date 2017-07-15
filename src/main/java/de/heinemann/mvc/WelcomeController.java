package de.heinemann.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String welcome() {
		logger.info("WELCOME");
		return "welcome";
	}
	
}
