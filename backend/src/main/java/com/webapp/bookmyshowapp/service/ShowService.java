package com.webapp.bookmyshowapp.service;

import com.webapp.bookmyshowapp.form.ShowCreateForm;
import com.webapp.bookmyshowapp.model.Show;

public interface ShowService {

	Show saveShow(ShowCreateForm showCreateForm) throws Exception;
}
