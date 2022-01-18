package web08;

public class Order {
	
	private String coffeeName;
	private String type;
	private int price;
	private int count;
	private int total;
	
	
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeName) {
		this.coffeeName = coffeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
	
