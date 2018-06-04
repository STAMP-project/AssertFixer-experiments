

/**
 * IdentityGovernanceAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.governance.stub;

    /*
     *  IdentityGovernanceAdminService java interface
     */

    public interface IdentityGovernanceAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param updateConfigurations1
                
             * @throws org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceExceptionException : 
         */

         
                     public void updateConfigurations(

                        org.wso2.carbon.identity.governance.stub.bean.Property[] configurations2)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateConfigurations1
            
          */
        public void startupdateConfigurations(

            org.wso2.carbon.identity.governance.stub.bean.Property[] configurations2,

            final org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getConnectorList4
                
             * @throws org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.governance.stub.bean.ConnectorConfig[] getConnectorList(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getConnectorList4
            
          */
        public void startgetConnectorList(

            

            final org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    