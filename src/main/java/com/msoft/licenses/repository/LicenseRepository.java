package com.msoft.licenses.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msoft.licenses.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, String>{
	
	public List<License> findByOrganizationId(String organizationId);
	
	public License findByorganizationIdAndLicenseId(String organizationId, String licenseId);
	
}
