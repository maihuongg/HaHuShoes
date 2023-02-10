package HaHuShoes.Util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookie {
	public static String get(String name,HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					
					
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	public static Cookie add(String name,String value, int hours, HttpServletResponse resp)
	{
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(60*60*hours);
		cookie.setPath("/");
		resp.addCookie(cookie);
		return cookie;
	}
}

