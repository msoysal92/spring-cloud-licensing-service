package com.msoft.licenses.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class License {

	private String id;
	private String organizationId;
	private String productName;
	private String licenseType;
	
}
