package tw.com.beans;

public class Apple {
  private String color;
  private int price;

	public Apple() {
	super();
	}
	
	public Apple(String color, int price) {
	super();
	this.color = color;
	this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Apple [color=" + color + ", price=" + price + "]";
	}
  
}
