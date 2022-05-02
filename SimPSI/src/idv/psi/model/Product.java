package idv.psi.model;

public class Product {
	private String name;//產品名
	private String description;//描述
	private Integer price;//價錢

	public Product() {
		super();
	}

	public Product(String name, String description, Integer price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	//private Integer inventory;//庫存量

}
