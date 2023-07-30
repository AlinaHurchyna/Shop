package shop;

import shop.model.Category;
import shop.model.Order;
import shop.model.OrderStatus;
import shop.services.CategoryService;
import shop.services.ProductService;

import java.util.Scanner;

import static shop.services.OrderService.orders;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);
	private final CategoryService categoryService = new CategoryService();
	private int categoryId;

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
				case 3 -> showOrderSubMenu(orderId);
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

	private void printAllCategory() {

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
		categoryId = scanner.nextInt();

		if (categoryService.removeCategory(categoryId)) {
			System.out.println("Usunięto.");
		} else {
			System.out.println("Nie znaleziono kategorii o podanym ID.");

		}
	}


	private void printCategoryDetails(int categoryId) {
	}
}


