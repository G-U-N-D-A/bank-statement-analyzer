package com.dhaval.bank.statement.manager;

import com.dhaval.bank.datasource.DataSource;
import com.dhaval.bank.exception.CategoryManagerException;
import com.dhaval.bank.statement.objects.Category;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class CategoryManagerTest {
    CategoryManager categoryManager = new CategoryManager();

    @Test
    public void getCategories() throws CategoryManagerException {
        List<Category> actualCategories = categoryManager.getCategories();
        List<Category> expectedCategories = DataSource.getExpectedCategories();
        Assert.assertEquals(expectedCategories, actualCategories);
    }
}