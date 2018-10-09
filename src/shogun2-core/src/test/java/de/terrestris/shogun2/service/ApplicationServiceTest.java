package de.terrestris.shogun2.service;

import de.terrestris.shogun2.dao.ApplicationDao;
import de.terrestris.shogun2.model.Application;

public class ApplicationServiceTest extends
    PermissionAwareCrudServiceTest<Application, ApplicationDao<Application>, ApplicationService<Application, ApplicationDao<Application>>> {

    /**
     * @throws Exception
     */
    @Override
    public void setUpImplToTest() throws Exception {
        implToTest = new Application();
    }

    @Override
    protected ApplicationService<Application, ApplicationDao<Application>> getCrudService() {
        return new ApplicationService<Application, ApplicationDao<Application>>();
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Class<ApplicationDao<Application>> getDaoClass() {
        return (Class<ApplicationDao<Application>>) new ApplicationDao<Application>().getClass();
    }


}
