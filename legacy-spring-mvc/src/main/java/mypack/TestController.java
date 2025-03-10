package mypack;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TestController extends AbstractController {

  public TestController() {
    System.out.println("########## TestController Loaded ############");
  }

  @Override
  protected ModelAndView handleRequestInternal(HttpServletRequest request,
      HttpServletResponse response)
      throws Exception {
    response.setContentType("text/html");
    System.out.println(
        "########## handleRequestInternal method of TestController called. ###########");
    PrintWriter out = response.getWriter();
    out.println("This response is displayed without creating jsp or velocity file.");
    return null;
  }
}