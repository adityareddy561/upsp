package com.upspapp.responseDto;

import java.util.List;

import com.upspapp.modal.Category;
import com.upspapp.modal.SubCategory;

public class CategoriesAndSubcategories {
	private Category category;
	private List<SubCategory> subCategories;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<SubCategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}

}
