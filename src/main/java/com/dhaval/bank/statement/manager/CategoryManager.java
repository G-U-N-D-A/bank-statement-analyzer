package com.dhaval.bank.statement.manager;

import com.dhaval.bank.constants.Constants;
import com.dhaval.bank.exception.CategoryManagerException;
import com.dhaval.bank.io.MyFileReader;
import com.dhaval.bank.statement.objects.Category;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager {
    private final MyFileReader fileReader = new MyFileReader();

    private String categoriesFileName = Constants.CATEGORIES_FILE_NAME;

    public CategoryManager() {
    }

    public List<Category> getCategories() throws CategoryManagerException {
        List<String> categoriesDef = readCategories();

        List<Category> categories = new ArrayList<Category>();
        for(String categoryDef: categoriesDef){
            String[] defAttributes = categoryDef.split(",");
            String name = (defAttributes[0]).trim();
            String classifier = formatClassifier((defAttributes[1]).trim());
            Category category = new Category(name, classifier);
            categories.add(category);
        }
        return categories;
    }

    private String formatClassifier(String classifiers) {
        return classifiers.replaceAll("%", ",");
    }

    private List<String> readCategories() throws CategoryManagerException {
        try {
            return fileReader.readLines(categoriesFileName);
        } catch (FileNotFoundException e) {
            throw new CategoryManagerException(e);
        }
    }

    public void printCategoryWiseTransactions(List<Category> categories) {
        for(Category category: categories){
            System.out.println("****************** " + category.getName() + " ****************** ");
            category.printAllTransactions();
            System.out.println();
        }
    }
}