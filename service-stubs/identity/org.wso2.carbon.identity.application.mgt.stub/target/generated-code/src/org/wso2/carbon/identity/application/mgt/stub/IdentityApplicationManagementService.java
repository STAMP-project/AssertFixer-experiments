

/**
 * IdentityApplicationManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.application.mgt.stub;

    /*
     *  IdentityApplicationManagementService java interface
     */

    public interface IdentityApplicationManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getAllLocalAuthenticators14
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.LocalAuthenticatorConfig[] getAllLocalAuthenticators(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllLocalAuthenticators14
            
          */
        public void startgetAllLocalAuthenticators(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateApplication17
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public void updateApplication(

                        org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider serviceProvider18)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateApplication17
            
          */
        public void startupdateApplication(

            org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider serviceProvider18,

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param createApplication20
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public void createApplication(

                        org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider serviceProvider21)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param createApplication20
            
          */
        public void startcreateApplication(

            org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider serviceProvider21,

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
         */

         
                     public void getAuthenticationFlowTemplates(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
          */
        public void startgetAuthenticationFlowTemplates(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAuthenticationTemplatesJSON25
                
         */

         
                     public java.lang.String getAuthenticationTemplatesJSON(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAuthenticationTemplatesJSON25
            
          */
        public void startgetAuthenticationTemplatesJSON(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllApplicationBasicInfo28
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.ApplicationBasicInfo[] getAllApplicationBasicInfo(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllApplicationBasicInfo28
            
          */
        public void startgetAllApplicationBasicInfo(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getIdentityProvider31
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.IdentityProvider getIdentityProvider(

                        java.lang.String federatedIdPName32)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getIdentityProvider31
            
          */
        public void startgetIdentityProvider(

            java.lang.String federatedIdPName32,

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteApplication35
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public void deleteApplication(

                        java.lang.String applicationName36)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteApplication35
            
          */
        public void startdeleteApplication(

            java.lang.String applicationName36,

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllRequestPathAuthenticators38
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.RequestPathAuthenticatorConfig[] getAllRequestPathAuthenticators(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllRequestPathAuthenticators38
            
          */
        public void startgetAllRequestPathAuthenticators(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllLocalClaimUris41
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public java.lang.String[] getAllLocalClaimUris(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllLocalClaimUris41
            
          */
        public void startgetAllLocalClaimUris(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getApplication44
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.ServiceProvider getApplication(

                        java.lang.String applicationName45)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getApplication44
            
          */
        public void startgetApplication(

            java.lang.String applicationName45,

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllIdentityProviders48
                
             * @throws org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.xsd.IdentityProvider[] getAllIdentityProviders(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceIdentityApplicationManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllIdentityProviders48
            
          */
        public void startgetAllIdentityProviders(

            

            final org.wso2.carbon.identity.application.mgt.stub.IdentityApplicationManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    