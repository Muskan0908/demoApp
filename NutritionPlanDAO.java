package com.cg.nutritionapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * NutritionPlan interface for creating different methods of CRUD
 * @author 
 *
 */

public interface NutritionPlanDAO extends JpaRepository<NutritionPlan,Long> {
	/**
	 * save method is used to insert records in the table in DB
	 */
	public NutritionPlan save(NutritionPlan nutritionPlan);
	/**
	 * findAll method is used to fetch records from the DB
	 * @return
	 */
	public List<NutritionPlan> findAll();
	/**
	 * update method is used to update record in the table in DB
	 * @param nutritionPlan
	 */
	NutritionPlan update(NutritionPlan nutritionPlan) throws NutritionPlanException;
	/**
	 * delete method is used to delete a record from the table in DB
	 * @param nutritionPlan
	 */
	public void delete(NutritionPlan nutritionPlan) ;

}
