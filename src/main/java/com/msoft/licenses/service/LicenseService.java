package com.msoft.licenses.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msoft.licenses.config.ServiceConfig;
import com.msoft.licenses.model.License;
import com.msoft.licenses.repository.LicenseRepository;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepository licenseRepository;
	
	@Autowired
	private ServiceConfig config;
	
	public License getLicense(String organizationId, String licenseId) {
		License license = licenseRepository
				.findByorganizationIdAndLicenseId(organizationId, licenseId);
		if(license != null)
			license.setComment(config.getExampleProperty());
		
		return license;
	}
	
	public List<License> getLicensesByOrganization(String organizationId) {
		return licenseRepository.findByOrganizationId(organizationId);
	}
	
	public void saveLicense(License license) {
		license.setLicenseId(UUID.randomUUID().toString());
		licenseRepository.save(license);
	}
	
}
