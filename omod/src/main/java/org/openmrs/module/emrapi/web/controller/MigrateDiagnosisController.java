package org.openmrs.module.emrapi.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.openmrs.module.emrapi.EmrApiProperties;
import org.openmrs.module.emrapi.diagnosis.DiagnosisMetadata;
import org.openmrs.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import openmrs.module.emrapi.diagnosis.MigrateDiagnosis;

@Controller
public class MigrateDiagnosisController {
	
	@Autowired
	EmrApiProperties emrApiProps;
	
	@RequestMapping(value = "module/emrapi/MigrateDiagnosis.form", method = RequestMethod.GET)
	public String handleDiagnosisMigration() {
		return "module/emrapi/migrateEncounterDiagnosis";
	}
	
	
	@RequestMapping(value = "module/emrapi/Migrate.form", method = RequestMethod.GET)
	public String migrate(HttpSession session, HttpServletRequest request) {
		DiagnosisMetadata diagnosisMetadata = emrApiProps.getDiagnosisMetadata();
		if (new MigrateDiagnosis().migrate(diagnosisMetadata)) {
			session.setAttribute(WebConstants.OPENMRS_MSG_ATTR, "emrapi.migrateDiagnosis.success.name");
		} else {
			session.setAttribute(WebConstants.OPENMRS_ERROR_ATTR, "emrapi.migrateDiagnosis.migration.error.message");
		}
		return "redirect:MigrateDiagnosis.form";
	}
	
}
