package bookseller;

public class BookSelect {
//mvc
	// M:model层 数据
	// v：视觉类
	// c：管理类
	private String name;
	private String isbn;
	private double price;
	private int count; // 当前图书对象的库存量
	
	
	public BookSelect() {}
	public BookSelect(String name) {
		this.setName(name);
	}
	public BookSelect(String name, String isbn, double price, int count) {
		setCount(count);
		setIsbn(isbn);
		setName(name);
		setPrice(price);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			price = 0;
		} else
			this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		if (count < 0) {
			count = 0;
		} else
			this.count = count;
	}

}
