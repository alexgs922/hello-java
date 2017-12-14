package hello;

public class GreetingTranslator {
	
	public String sayHelloIn(String lang) {
		String hello;
		if ("en".equals(lang)) {
			hello = "hello";
		} else if ("es".equals(lang)) {
			hello = "hola";
		} else {
			hello = "no hablo tu idioma";
		}
	}

}