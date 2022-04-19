package com.cg.nutritionapp.service;
import java.util.List;


import com.cg.nutritionapp.dao.NutritionPlanDAO;
import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.service.NutritionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class provides the implementation of services
 * @author 
 *
 */

@Service
public abstract class NutritionPlanServiceImpl implements NutritionPlanService {
	@Autowired
	private static NutritionPlanDAO nutritionPlanDAO;


	public NutritionPlanServiceImpl(){

	}

	@Override
	public NutritionPlan createPlan(NutritionPlan nutritionPlan) throws  NutritionPlanException {
		nutritionPlan = nutritionPlanDAO.save(nutritionPlan);
		return nutritionPlan;
	}

	@Override
	public NutritionPlan changePlan(NutritionPlan nutritionPlan) throws NutritionPlanException {
		nutritionPlan = nutritionPlanDAO.update(nutritionPlan);
		return nutritionPlan;
	}

	@Override
	public void removePlan(NutritionPlan nutritionPlan)  throws NutritionPlanException{
		
	}

	@Override
	public List<NutritionPlan> listAllPlans() throws NutritionPlanException {
		return nutritionPlanDAO.findAll();
	}


}
