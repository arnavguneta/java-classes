package com.Guneta;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		Cookie cookies[] = req.getCookies();
		int k = 0;
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("k"))
				k = Integer.parseInt(c.getValue());
		}
		k = k * k;

		PrintWriter out = res.getWriter();
		out.println("square of sum is " + k);
	}
}
