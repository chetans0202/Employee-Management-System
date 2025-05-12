//EmployeeOperationsController

package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller 
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService empService;
	
	
	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	
	@GetMapping("/report")
	public String showReport(Map<String,Object>map) {
		
		List<Employee> empsList = empService.fetchAllEmployees();
		map.put("empInfo", empsList);
		return "show_report";	
	}
	
	
	@GetMapping("/register")
	public String ShowregisterEmployeeFormPage(@ModelAttribute("emp") Employee emp)
	{
			return "employee_register_form";
	}
	
	
//	@PostMapping("/register")
//	public String processRegisterEmployeeFormPage(Map<String,Object> map,
//			@ModelAttribute("emp") Employee emp) {
//		
//		String msg = empService.registerEmployee(emp);
////		List<Employee> list=empService.fetchAllEmployees();
//		
//		map.put("resultMsg", msg);
////		map.put("empsInfo", list);
//		
////		return "show_report";
//		return "redirect:report";
//	}
	
	@PostMapping("/register")
	public String processRegisterEmployeeFormPage(RedirectAttributes attrs,
												@ModelAttribute("emp") Employee emp) {
	
		String msg = empService.registerEmployee(emp);

		attrs.addFlashAttribute("resultMsg",msg);
		
		return "redirect:report";	
	}
	
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,
															@ModelAttribute("emp") Employee emp) {
		
		Employee emp1 = empService.getEmployeeByNo(no);
		//keep emp1 obj data to model class obj emp
		BeanUtils.copyProperties(emp1, emp);
		
		return "employee_edit_form";
	}
	
	@PostMapping("/edit")
	public String processEditFormPage(RedirectAttributes attrs,
															@ModelAttribute("emp") Employee emp) {
		
		String msg = empService.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);		
		return "redirect:report";
	}
	
	@GetMapping("/delete")
	public String deleteEmployeeByNo(@RequestParam("no") int no,
																RedirectAttributes attrs) {
		
		String msg=empService.deleteEmployee(no);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
