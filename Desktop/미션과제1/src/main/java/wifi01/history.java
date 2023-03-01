package wifi01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/history")
public class history extends HttpServlet {
	public void init() {
		System.out.println("init 메서드 호출 ");
	}
}
