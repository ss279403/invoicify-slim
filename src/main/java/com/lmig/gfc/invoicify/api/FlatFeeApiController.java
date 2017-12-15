package com.lmig.gfc.invoicify.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import com.lmig.gfc.invoicify.models.FlatFeeBillingRecord;
import com.lmig.gfc.invoicify.models.User;
import com.lmig.gfc.invoicify.services.BillingRecordRepository;
import com.lmig.gfc.invoicify.services.CompanyRepository;

@RestController
@RequestMapping("/api/flatfees")
public class FlatFeeApiController {

	private BillingRecordRepository billingRepo;
	private CompanyRepository companyRepo;

	public FlatFeeApiController(BillingRecordRepository billingRepo, CompanyRepository companyRepo) {
		this.billingRepo = billingRepo;
		this.companyRepo = companyRepo;
	}

	@PostMapping

	public FlatFeeBillingRecord create(@RequestBody FlatFeeBillingRecord record, Authentication auth) {

		User user = (User) auth.getPrincipal();

		record.setCreatedBy(user);

		record.setClient(companyRepo.findOne(record.getClient().getId()));

		return billingRepo.save(record);

	}

}