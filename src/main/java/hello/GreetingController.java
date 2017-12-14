package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, 
    					   @RequestParam(value="lang", required=false, defaultValue="en") String lang, 
    					   Model model) {
    	model.addAttribute("hello", GreetingTranslator.sayHelloIn(lang));
        model.addAttribute("name", name);
        return "greeting";
	}
}