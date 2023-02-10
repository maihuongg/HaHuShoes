package HaHuShoes.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.el.parser.BooleanNode;

public class Session {
//luu
	public static void add(HttpServletRequest req, String name,Object value) {
		HttpSession session = req.getSession();
		session.setAttribute(name, value);
		
	}
//	lay doi tuong
	public static Object get(HttpServletRequest req, String name)
	{
		HttpSession session = req.getSession();
		return session.getAttribute(name);
	}
	//huy sestion
	public static void invalidate(HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		req.removeAttribute("account");
		session.invalidate();
				
	}
	public static boolean isLogin(HttpServletRequest req)
	{
		return get(req,"account")!=null;
	}
	public static String getLogin(HttpServletRequest req)
	{
		Object usernameObject= get(req, "account");
		return usernameObject==null?null:usernameObject.toString();
	}
}
