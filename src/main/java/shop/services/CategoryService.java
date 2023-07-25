package shop.services;

import shop.model.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
	private int newCategoryId = 1;
	private final List<Category> categories = new ArrayList<>();

	public void createCategory(String name) {
		Category category = new Category(newCategoryId++, name);
		categories.add(category);
	}

	public Category getCategoryById(int categoryId) {
		for (Category category : categories) {
			if (category.id() == categoryId) {
				return category;
			}
		}
		return null;
	}

	public boolean removeCategory(int id) {
		return categories.removeIf(category -> id == category.id());
	}

	public List<Category> getCategories() {
		return categories;
	}
}
