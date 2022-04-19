package com.cg.nutritionapp.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.cg.nutritionapp.dao.NutritionPlanDAO;
import com.cg.nutritionapp.exceptions.NutritionPlanException;
//import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;


public abstract class NutritionPlanDAOImpl  implements NutritionPlanDAO {

	//JDBCUtil jdbcUtil = new JDBCUtil();
	private List<NutritionPlan> nutritionPlanList=new ArrayList<NutritionPlan>();

	private NutritionPlanDAO nutritionPlanDAO;

	public NutritionPlanDAOImpl(){
		try{
			nutritionPlanList= nutritionPlanDAO.findAll();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean isValid(NutritionPlan nutritionPlan){
		if(nutritionPlan.getName()!=null
			&& nutritionPlan.getPlanDescription()!=null
			&& nutritionPlan.getCreated_At()!=null
			&& nutritionPlan.getPrice()!=null){
			return true;
		}
		return false;
	}
	@Override
	public NutritionPlan save(NutritionPlan nutritionPlan) {
		try{
			if(isValid(nutritionPlan)) {
				nutritionPlanList.add(nutritionPlan);
			} else {
				throw new NutritionPlanException("Invalid/empty fields");
			}
		} catch (NutritionPlanException e){
			System.err.println(e);
		}

		return nutritionPlan;
	}


	@Override
	public List<NutritionPlan> findAll() {
		return  nutritionPlanList;
	}

	private NutritionPlan findByNutritionId(Long nutritionPlanId){
		for(NutritionPlan i:nutritionPlanList){
			if(i.getId()==nutritionPlanId){
				return i;
			}
		}
		return null;
	}

//	private void nutritionUpdate(NutritionPlan nutritionPlan, PreparedStatement pstmt) {
//		try {
//			java.util.Date date = new java.util.Date();
//			java.sql.Date sqlDate = new Date(date.getTime());
//			pstmt.setString(1, nutritionPlan.getName());
//			pstmt.setString(2, nutritionPlan.getPlanDescription());
//			pstmt.setDate(3, sqlDate);
//			pstmt.setLong(4, nutritionPlan.getPrice());
//			pstmt.setLong(5, nutritionPlan.getId());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}


//	@Override
//	public NutritionPlan update(NutritionPlan nutritionPlan) throws NutritionPlanException {
//		try
//		{
//			if(findByNutritionId(nutritionPlan)) {
//				String sql = "update NutritionPlan set name=?,plan_description=?,updated_at=?,price=? where id=?";
//				PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
//				nutritionUpdate(nutritionPlan, pstmt);
//				return nutritionPlan;
//			} else {
//				throw new NutritionPlanException("No matching nutrition id");
//			}
//		}catch(NutritionPlanException e)
//		{
//			System.err.println(e);
//		}
//		return nutritionPlan;
//	}
//
//	//@Override
//	public void delete(NutritionPlan nutritionPlan) {
//		int status=0;
//		String sql = "DELETE FROM NutritionPlan WHERE id=?";
//		PreparedStatement pstmt = jdbcUtil.getPreparedStatement(sql);
//		try{
//			pstmt.setLong(1,nutritionPlan.getId());
//			status = pstmt.executeUpdate();
//			if(status == 0) {
//				throw new SQLException();
//			}
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//	}
	@Override
	public NutritionPlan update(NutritionPlan nutritionPlan) throws NutritionPlanException{
		try
		{
			NutritionPlan x=findByNutritionId(nutritionPlan.getId());
			if(x!=null) {
				x.setName(nutritionPlan.getName());
				x.setPlanDescription(nutritionPlan.getPlanDescription());
				x.setCreated_At(nutritionPlan.getCreated_At());
				x.setUpdated_At(nutritionPlan.getUpdated_At());
				x.setPrice(nutritionPlan.getPrice());
				return x;
			} else {
				throw new NutritionPlanException("No matching nutrition id");
			}
		}catch(NutritionPlanException e)
		{
			System.err.println(e);
		}
		return nutritionPlan;
	}

//	@Override
//	public void delete(NutritionPlan nutritionPlan) {
//		try{
//			Long id=findByNutritionId(nutritionPlan);
//			if(id!=-1L) {
//				nutritionPlanDAO.deleteById(id);
//
//			} else {
//				throw new NutritionPlanException("No matching nutrition id");
//			}
//		} catch (Exception e){
//			e.printStackTrace();
//		}
//	}
}
