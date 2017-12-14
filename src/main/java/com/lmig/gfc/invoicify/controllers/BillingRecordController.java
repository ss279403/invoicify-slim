package com.lmig.gfc.invoicify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.invoicify.models.BillingRecord;
import com.lmig.gfc.invoicify.models.Company;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@Controller
@RequestMapping("/billing-records")
public class BillingRecordController {
	
	private BillingRecordRepository records;
	private CompanyRepository companies;
	
	public BillingRecordController(BillingRecordRepository records, CompanyRepository companies) {
		this.records = records;
		this.companies = companies;
	}

	@GetMapping("")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("billing-records/list");
		
		// Get all the billing records and add them to the model and 
		//view with the key "records"
		
		List<BillingRecord> br = records.findAll();		
		
		// Get all the companies and add them to the model and view 
		//with the key "companies"
		
		List<Company> cs = companies.findAll();
		mv.addObject("companies", cs);
		mv.addObject("records", br);
		
		return mv;
	}

}
