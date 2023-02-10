package HaHuShoes.Controller.Web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HaHuShoes.Model.CartModel;
import HaHuShoes.Model.ItemModel;
import HaHuShoes.Model.ProductModel;
import HaHuShoes.Service.iProductService;
import HaHuShoes.Service.Impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/process"})
public class ProcessController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	iProductService productService=new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		// findAll product
		List<ProductModel> productList = productService.findAll();

		// Cookie giỏ hàng
		Cookie[] arr = req.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("cart")) {
					txt += o.getValue();
					o.setMaxAge(0);
					resp.addCookie(o);
				}
			}
		}
		CartModel cart = new CartModel(txt,productList);
		String num_raw=req.getParameter("num");
		String id_raw=req.getParameter("id");
		int id,num=0;
		try {
			id=Integer.parseInt(id_raw);
			ProductModel p = productService.findoneId(id);
			int numStore = p.getAmount();
			num=Integer.parseInt(num_raw);
			if((num==-1)&&(cart.getQuantityById(id)<=1)) {
				cart.removeItem(id);
			}else {
				if((num==1) && (cart.getQuantityById(id)>=numStore)) {
					num=0;
				}
				double price=p.getPrice();
				ItemModel t = new ItemModel(p,num,price);
				cart.addItem(t);
			}
		}catch(NumberFormatException e) {
			
		}
		
		List<ItemModel> items =cart.getItems();
		txt="";
		if(items.size()>0) {
			txt=items.get(0).getProduct().getProductId()+":"+
					items.get(0).getQuantity();
			for(int i=1; i<items.size(); i++) {
				txt+="-"+items.get(i).getProduct().getProductId()+":"+
						items.get(i).getQuantity();
			}
		}
		
		Cookie c = new Cookie("cart",txt);
		c.setMaxAge(1*24*60*60);
		resp.addCookie(c);
		int n;
		if (items != null) {
			n = items.size();
		} else
			n = 0;
		req.setAttribute("size", n);
		req.setAttribute("cart", cart);
		req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		List<ProductModel> productList = productService.findAll();

		// Cookie giỏ hàng
		Cookie[] arr = req.getCookies();
		String txt = "";
		if (arr != null) {
			for (Cookie o : arr) {
				if (o.getName().equals("cart")) {
					txt += o.getValue();
					o.setMaxAge(0);
					resp.addCookie(o);
				}
			}
		}
		String id=req.getParameter("id");
		String[] ids=txt.split("-");
		String out="";
		for (int i = 0; i < ids.length; i++) {
            String[] s=ids[i].split(":");
            if(!s[0].equals(id)){
                if(out.isEmpty()){
                    out=ids[i];
                }else{
                    out+="-"+ids[i];
                }
            }
        }
		if(!out.isEmpty()) {
			Cookie c=new Cookie("cart", out);
			c.setMaxAge(1*24*60*60);
			resp.addCookie(c);
		}
		CartModel cart=new CartModel(out, productList);
		req.setAttribute("cart", cart);
		List<ItemModel> items =cart.getItems();
		int n;
		if (items != null) {
			n = items.size();
		} else
			n = 0;
		req.setAttribute("size", n);
		req.getRequestDispatcher("/views/web/cart.jsp").forward(req, resp);
		
	}
}
