package shop;

import shop.model.Category;
import shop.model.Order;
import shop.model.Product;
import shop.services.CategoryService;
import shop.services.ProductService;

import java.util.Scanner;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);
	private final CategoryService categoryService = new CategoryService();
	private final ProductService productService = new ProductService();


	public void showMainMenu(int orderId) {
		boolean exit = false;
		while (!exit) {

			System.out.println("Wybierz z listy: ");

			System.out.println("1. Zamówienia");
			System.out.println("2. Kategorie produktów");
			System.out.println("3. Produkty");
			System.out.println("4. Wyjdź");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> showOrderSubMenu(orderId);
				case 2 -> showCategorySubMenu();
				case 3 -> showProductSubMenu();
				case 4 -> exit = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
	}


	public Order showOrderSubMenu(int orderId) {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista zamówień.");
			System.out.println("[2] Konkretne zamówienie.");
			System.out.println("[3] Dodaj zamówienie.");
			System.out.println("[4] Usuń zamówienie.");
			//System.out.println("[5] Edytuj zamówienie.");
			System.out.println("[6] Zmień status zamówienia.");
			System.out.println("[7] Pokaż status zamówienia.");
			//System.out.println("[8] Dodaj produkt do zamówienia.");
			System.out.println("[9] Cofnij");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> printAllCategory();
				case 2 -> {
					printAllCategory();
				}
				case 3 -> categoryService.addOrder();
				case 4 -> deleteCategory();
				//case 5 ->
				case 6 -> categoryService.hashCode();
				case 7 -> categoryService.hashCode();
				//case 8 ->
				case 9 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
		return null;
	}


	public void showCategorySubMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista kategorii.");
			System.out.println("[2] Konkretna kategoria.");
			System.out.println("[3] Dodaj kategorie.");
			System.out.println("[4] Usuń kategorie.");
			System.out.println("[5] Cofnij");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> printAllCategory();
				case 2 -> printSpecificCategory();
				case 3 -> addCategory();
				case 4 -> deleteCategory();
				case 5 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
	}

	public void showProductSubMenu() {
		boolean back = false;
		while (!back) {
			System.out.println("[1] Lista produktów.");
			System.out.println("[2] Konkretny produkt.");
			System.out.println("[3] Dodaj produkt.");
			System.out.println("[4] Usuń produkt.");
			System.out.println("[5] Cofnij");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> printAllProducts();
				case 2 -> printSpecificProduct();
				//case 3 -> addProduct();
				case 4 -> deleteProduct();
				case 5 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
	}


	public void printAllCategory() {
		System.out.println("Lista kategorii:");
		for (Category category : categoryService.getCategories()) {
			System.out.println("ID: " + category.id()
					+ ", Nazwa: " + categoryService.getCategories());
		}
	}

	public void printSpecificCategory() {
		System.out.print("Podaj ID kategorii: ");

		int categoryId = scanner.nextInt();
		scanner.nextLine();

		Category category = categoryService.getCategoryById(categoryId);
		if (category != null) printAllCategory();
		else {
			System.out.println("Kategoria o podanym ID nie istnieje.");
		}
	}

	public void addCategory() {
		System.out.println("Dodawanie kategorii: ");
		System.out.println();

		System.out.print("Podaj nazwę: ");
		String name = scanner.nextLine();

		categoryService.createCategory(name);

		System.out.println("Kategoria została dodana.");
	}


	public void deleteCategory() {
		System.out.print("Podaj Id kategorii, którą chcesz usunąć: ");
		int id = scanner.nextInt();

		if (categoryService.removeCategory(id)) {
			System.out.println("Usunięto.");
		} else {
			System.out.println("Nie znaleziono kategorii o podanym ID.");
		}
	}

	public void printAllProducts() {
		System.out.println("Lista produktów:");
		for (Product product : productService.getProducts()) {
			System.out.println("ID: " + product.getProductId()
					+ ", Nazwa: " + product.getName()
					+ ", Kategoria: " + product.getCategory()
					+ ", Cena: " + product.getPrice() + " zł");
		}
	}

	public void printProductDetails(int productId) {
		Product product = productService.getProductById(productId);
		if (product != null) {
			System.out.println("Szczegóły produktu:");
			System.out.println("ID: " + product.getProductId());
			System.out.println("Nazwa: " + product.getName());
			System.out.println("Cena: " + product.getPrice() + " zł");
			System.out.println("Ilość: " + product.getQuantity());
		} else {
			System.out.println("Produkt o podanym ID nie istnieje.");
		}
	}

	public void printSpecificProduct() {
		System.out.print("Podaj ID produktu: ");

		int productId = scanner.nextInt();
		scanner.nextLine();

		Product product = productService.getProductById(productId);
		if (product != null) {
			printProductDetails(productId);
		} else {
			System.out.println("Produkt o podanym ID nie istnieje.");
		}
	}

/*	public void addProduct() {
		System.out.println("Dodawanie produktu: ");
		System.out.println();

		System.out.print("Podaj cenę: ");
		double price = scanner.nextDouble();
		scanner.nextLine();

		System.out.print("Podaj nazwę: ");
		String name = scanner.nextLine();

		System.out.print("Podaj ilość: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		Product newProduct = new Product(price, name, quantity);
		productService.createProduct( );

		System.out.println("Produkt został dodany.");
	}*/


	public void deleteProduct() {
		System.out.print("Podaj Id produktu, który chcesz usunąć: ");
		int productId = scanner.nextInt();

		if (productService.removeProduct(productId)) {
			System.out.println("Produkt został usunięty.");
		} else {
			System.out.println("Nie znaleziono produktu o podanym ID.");
		}
	}


}
