package com.webapp.bookmyshowapp.service;

import com.webapp.bookmyshowapp.form.SubRegionCreateForm;
import com.webapp.bookmyshowapp.model.SubRegion;

public interface SubRegionService {

	SubRegion saveSubRegion(SubRegionCreateForm subRegionCreateForm) throws Exception;
}
