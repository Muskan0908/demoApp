package com.cg.nutritionapp.service;

import java.util.List;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
/**
 * This interface is used for providing services
 * @author 
 *
 */

public interface NutritionPlanService {

	public NutritionPlan createPlan(NutritionPlan nutritionPlan)  throws NutritionPlanException;
	public NutritionPlan changePlan(NutritionPlan nutritionPlan)  throws NutritionPlanException;
	public void removePlan(NutritionPlan nutritionPlan)  throws NutritionPlanException;
	public List<NutritionPlan> listAllPlans() throws NutritionPlanException;

}
