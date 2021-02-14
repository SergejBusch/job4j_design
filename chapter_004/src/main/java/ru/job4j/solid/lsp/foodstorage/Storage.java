package ru.job4j.solid.lsp.foodstorage;

import java.util.ArrayList;
import java.util.List;

public abstract class Storage {
   List<Food> foodList = new ArrayList<>();

   abstract boolean check(Food food, int index);

   public boolean add(Food food, int index) {
      if (check(food, index)) {
         return foodList.add(food);
      }
      return false;
   }

   public List<Food> getFoodList() {
      return foodList;
   }

   public List<Food> checkAffiliation() {
      List<Food> fl = new ArrayList<>();
      for (var food : foodList) {
         if (!check(food, CheckExp.check(food))) {
            fl.add(food);
            foodList.remove(food);
         }
      }
      return fl;
   }
}
