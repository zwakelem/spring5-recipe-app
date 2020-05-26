package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by zwakele
 * on 2020/05/26
 **/
public class RecipeServiceImplTest {

  RecipeServiceImpl recipeService;

  @Mock
  RecipeRepository repository;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    recipeService = new RecipeServiceImpl(repository);
  }

  @Test
  public void getRecipes() {

    Set<Recipe> recipeData = new HashSet<>();
    recipeData.add(new Recipe());
    when(repository.findAll()).thenReturn(recipeData);

    Set<Recipe> recipes = recipeService.getRecipes();

    assertEquals(recipeData.size(), 1);
    verify(repository, times(1)).findAll();
  }
}