package org.nickharle.recipeapp.converters;

import lombok.Synchronized;
import org.nickharle.recipeapp.commands.CategoryCommand;
import org.nickharle.recipeapp.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized   // Spring does not guarantee thread safety -  can now run in a multi thread environment
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {

        if (source == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(source.getId());
        category.setDescription(source.getDescription());
        return category;
    }
}
