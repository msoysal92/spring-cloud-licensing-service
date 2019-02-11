package com.msoft.licenses.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.msoft.licenses.config.ServiceConfig;
import com.msoft.licenses.model.License;
import com.msoft.licenses.service.LicenseService;

@RestController
@RequestMapping(value="/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
	
	@Autowired
	private LicenseService licenseService;
	
	@Autowired
	private ServiceConfig config;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
		
		return licenseService.getLicensesByOrganization(organizationId);
	
	}
	
	@RequestMapping(value="/{licenseId}",method = RequestMethod.GET)
    public License getLicense( @PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) {
        License license = licenseService.getLicense(organizationId,licenseId);
        if(license == null)
        	throw new LicenseNotFoundException();
        
        return license;
    }
	
	@RequestMapping(value="{licenseId}",method = RequestMethod.PUT)
    public String updateLicenses( @PathVariable("licenseId") String licenseId) {
        return String.format("This is the put");
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveLicenses(@RequestBody License license) {
       licenseService.saveLicense(license);
    }
    
    @ExceptionHandler(LicenseNotFoundException.class)
    public ResponseEntity<Map<String, Object>> licenseNotFound() {
    	Map<String, Object> body = new HashMap<>();
    	body.put("status", "OK");
    	body.put("description", "License not found you are requested");
    	return new ResponseEntity<>(body, HttpStatus.OK);
    }
    
    @ExceptionHandler(OrganizationNotFoundException.class)
    public ResponseEntity<Map<String, Object>> organizationNotFound() {
    	Map<String, Object> body = new HashMap<>();
    	body.put("status", "OK");
    	body.put("description", "Organization not found you are requested");
    	return new ResponseEntity<>(body, HttpStatus.OK);
    }

}

@SuppressWarnings("serial")
class LicenseNotFoundException extends RuntimeException {
}

@SuppressWarnings("serial")
class OrganizationNotFoundException extends RuntimeException {
}
