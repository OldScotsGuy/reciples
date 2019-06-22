package org.nickharle.recipeapp.repositories;

import org.nickharle.recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
