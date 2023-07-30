package shop;

import shop.model.Category;
import shop.services.CategoryService;
import shop.services.OrderService;
import shop.services.ProductService;

import java.util.Scanner;

import static shop.services.OrderService.printAllOrders;

public class Menu {
	private final Scanner scanner = new Scanner(System.in);
	private final CategoryService categoryService = new CategoryService();

	public void showMainMenu() {
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
				case 1 -> showOrderSubMenu();
				case 2 -> showCategorySubMenu();
				case 3 -> showProductSubMenu();
				case 4 -> exit = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
	}

	public void showOrderSubMenu() {
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
				case 1 -> printAllOrders();
				case 2 -> {
					OrderService.printOrderDetails();
				}
				case 3 -> OrderService.addOrder();
				case 4 -> deleteCategory();
				//case 5 ->
				case 6 -> OrderService.changeOrderStatus();
				case 7 -> OrderService.printOrderStatus();
				//case 8 ->
				case 9 -> back = true;
				default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
			}
			System.out.println();
		}
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
				case 1 -> ProductService.printAllProducts();
				case 2 -> ProductService.printSpecificProduct();
				case 3 -> ProductService.addProduct();
				case 4 -> ProductService.deleteProduct();
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
					+ ", Nazwa: " + category.name());
		}
	}

	public void printCategoryDetails(int categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		if (category != null) {
			System.out.println("Szczegóły produktu:");
			System.out.println("ID: " + category.id());
			System.out.println("Nazwa: " + category.name());

		} else {
			System.out.println("Produkt o podanym ID nie istnieje.");
		}
	}

	public void printSpecificCategory() {
		System.out.print("Podaj ID kategorii: ");

		int categoryId = scanner.nextInt();
		scanner.nextLine();

		Category category = categoryService.getCategoryById(categoryId);
		if (category != null) {
			printCategoryDetails(categoryId);
		} else {
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
		int categoryId = scanner.nextInt();

		if (categoryService.removeCategory(categoryId)) {
			System.out.println("Usunięto.");
		} else {
			System.out.println("Nie znaleziono kategorii o podanym ID.");

		}
	}
}
