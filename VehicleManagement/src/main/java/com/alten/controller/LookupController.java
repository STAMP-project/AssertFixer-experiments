package com.alten.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alten.datatransferobject.ManufacturerDTO;
import com.alten.service.lookups.LookupService;
import com.alten.util.Helper;

import javax.annotation.PostConstruct;
import javax.naming.ConfigurationException;

import java.util.List;

/**
 * The Lookup REST controller.
 */
@RestController
@RequestMapping("/v1/lookups")
public class LookupController
{
    /**
     * The lookup service used to perform operations. Should be non-null after injection.
     */
    @Autowired
    private LookupService lookupService;


    /**
     * Check if all required fields are initialized properly.
     *
     * @throws ConfigurationException if any required field is not initialized properly.
     */
    @PostConstruct
    protected void checkConfiguration() throws ConfigurationException
    {
        Helper.checkConfigNotNull(getLookupService(), "lookupService");
    }


    /**
     * This method is used to get user role lookups.
     *
     * @return the lookups for user role.
     * @throws AttendeeException if any other error occurred during operation
     */
    @GetMapping("/manufacturers")
    public List<ManufacturerDTO> getManufacturers()
    {
        return getLookupService().getAllManufacturers();
    }


    public LookupService getLookupService()
    {
        return lookupService;
    }


    public void setLookupService(LookupService lookupService)
    {
        this.lookupService = lookupService;
    }

}
