package HaHuShoes.Model;

import java.util.List;
import java.util.ArrayList;

public class CartModel {
	private List<ItemModel> items;
	
	public CartModel() {
		items=new ArrayList<>();
	}

	public List<ItemModel> getItems() {
		return items;
	}

	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
	
	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}
	
	private ItemModel getItemById(int id) {
		for(ItemModel i:items) {
			if(i.getProduct().getProductId()==id) {
				return i;
			}
		}
		return null;
	}
	
	public void addItem(ItemModel t) {
		if(getItemById(t.getProduct().getProductId())!=null) {
			ItemModel m=getItemById(t.getProduct().getProductId());
			m.setQuantity(m.getQuantity()+t.getQuantity());
		}else
			items.add(t);
	}
	
	public void removeItem(int id) {
		if(getItemById(id)!=null) {
			items.remove(getItemById(id));
		}
	}
	
	public double getTotalMoney() {
		double t = 0;
		for (ItemModel i:items)
			t+=(i.getQuantity()*i.getPrice());
		return t;
	}
	
	private ProductModel getProductById(int id, List<ProductModel> list) {
		for(ProductModel i:list) {
			if(i.getProductId()==id)
				return i;
		}
		return null;
	}
	
	public CartModel(String txt, List<ProductModel> list) {
		items=new ArrayList<>();
		try {
		if(txt!=null && txt.length()!=0) {
			String[] s=txt.split("-");
			for(String i:s) {
				String[] n=i.split(":");
				int id=Integer.parseInt(n[0]);
				int quantity=Integer.parseInt(n[1]);
				ProductModel p = getProductById(id, list);
				ItemModel t=new ItemModel(p, quantity, p.getPrice());
				addItem(t);
			}
		}
		}catch(NumberFormatException e) {
		
		}
	}
}
