package com.msoft.licenses.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msoft.licenses.model.License;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@RequestMapping(value="/{licenseId}", method = RequestMethod.GET)
	public License getLicenses(
			@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		
		return	License.builder()
				.id(licenseId)
				.productName("Teleco")
				.licenseType("Seat")
				.organizationId(organizationId)
				.build();
	
	}
	
}
