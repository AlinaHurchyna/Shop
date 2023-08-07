package shop.services;

import shop.model.Category;
import shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	private final List<Product> products = new ArrayList<>();

	private List<Product> generateProducts() {


		Product product1 = new Product(12.2, "arbuz", new Category(1, ""), 1);
		Product product2 = new Product(2.5, "banan", new Category(1, ""), 1);
		Product product3 = new Product(11.4, "winogrona", new Category(1, ""), 15);
		Product product4 = new Product(5.2, "melon", new Category(1, ""), 1);
		Product product5 = new Product(15.2, "maliny", new Category(1, ""), 20);

		products.add(product1);
		products.add(product2);
		products.add(product3);
		products.add(product4);
		products.add(product5);

		return products;
	}

	public void createProduct(Product product) {
		products.add(product);
	}

	public Product getProductById(int productId) {
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}
		}
		return null;
	}

	public boolean removeProduct(int productId) {
		return products.removeIf(product -> productId == product.getProductId());
	}

	public List<Product> getProducts() {
		return products;
	}


}
