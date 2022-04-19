package com.cg.nutritionapp.controller;



import com.cg.nutritionapp.exceptions.NutritionPlanException;
import com.cg.nutritionapp.model.NutritionPlan;
import com.cg.nutritionapp.service.NutritionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class NutritionPlanController {
       // @Autowired
        private NutritionPlanService nutritionPlanService;

        @GetMapping("/test")
        ResponseEntity<String> getOk(){
                return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
        }
        @GetMapping("/nutritionPlan")

        ResponseEntity<List<NutritionPlan>> listAllPlans(){
                //return new ResponseEntity<>(nutritionPlanService.listAllPlans(), HttpStatus.ACCEPTED);
                return new ResponseEntity<>(nutritionPlanService.listAllPlans(), HttpStatus.ACCEPTED);
        }


        @PostMapping("/nutritionPlan/createPlan")
        public ResponseEntity<NutritionPlan> createPlan(@RequestBody NutritionPlan nutritionPlan){

                nutritionPlanService.createPlan(nutritionPlan);
                return new ResponseEntity<>(nutritionPlan, HttpStatus.CREATED);

        }





        @PutMapping("/nutritionPlan/{id}")
        public ResponseEntity<NutritionPlan> changePlan(@RequestBody NutritionPlan nutritionPlan){
                try{
                        if(nutritionPlan==null) {
                                throw new NutritionPlanException("plan empty");
                        }
                            nutritionPlanService.changePlan(nutritionPlan);
                        return new ResponseEntity<>(nutritionPlan, HttpStatus.CREATED);

                }catch(NutritionPlanException e){
                        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }


        }

        @DeleteMapping("/nutritionPlan/{id}")
        public ResponseEntity<String> removePlan(@RequestBody NutritionPlan nutritionPlan) throws NutritionPlanException {
                try{
                        if(nutritionPlan==null){
                                throw new NutritionPlanException("plan empty");
                        }
                        nutritionPlanService.removePlan(nutritionPlan);
                        return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);

                }catch (NutritionPlanException e){
                        return new ResponseEntity<>("null",HttpStatus.BAD_REQUEST);
                } 
        }














}
