package mypack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

public class IndexController extends ParameterizableViewController {
	
	public IndexController() {
		System.out.println("########## IndexController Loaded ############");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("############### handleRequest method of IndexController class ################");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", "This is test application");
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
