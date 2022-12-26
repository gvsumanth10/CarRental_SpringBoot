package com.webapp.demo.CarController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.Car.CarRent;
import com.webapp.demo.CarDao.CarDao;

@RestController
public class CarController {
	
	@Autowired
	CarDao dao;
	@RequestMapping("/saveCar")
	@ResponseBody
	public void saveCar(@RequestParam String id,String model, String no,CarRent obj) {
		
		obj.setCardId(id);
		obj.setCarModel(model);
		obj.setCarNo(no);
		obj.setStatus("available");
		dao.save(obj);
		
	}
	
	@RequestMapping("/editCar")
	@ResponseBody
	public void editCar(@RequestParam String id,String model, String no) {
		
		
		dao.editCarDetails(id,model,no);
		
	}
	
	@RequestMapping("/deleteCar")
	@ResponseBody
	public void deleteCar(@RequestParam String id) {
		
		
		dao.deleteCar(id);
		
	}
	

	@RequestMapping("/getAll")
	@ResponseBody
	public List<CarRent> getAll() {
		
		return dao.findAll();
		
		
	}
	
	@RequestMapping("/getById")
	@ResponseBody
	public List<CarRent> getCarById(String id) {
		
		return dao.findById(id);
		
		
	}

}