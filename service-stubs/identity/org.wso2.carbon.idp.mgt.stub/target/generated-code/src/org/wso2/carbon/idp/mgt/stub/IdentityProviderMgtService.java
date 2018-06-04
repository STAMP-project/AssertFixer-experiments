

/**
 * IdentityProviderMgtService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.idp.mgt.stub;

    /*
     *  IdentityProviderMgtService java interface
     */

    public interface IdentityProviderMgtService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getResidentIdP16
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider getResidentIdP(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getResidentIdP16
            
          */
        public void startgetResidentIdP(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addIdP19
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public void addIdP(

                        org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider20)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addIdP19
            
          */
        public void startaddIdP(

            org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider20,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllIdPs22
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider[] getAllIdPs(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllIdPs22
            
          */
        public void startgetAllIdPs(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllLocalClaimUris25
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public java.lang.String[] getAllLocalClaimUris(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllLocalClaimUris25
            
          */
        public void startgetAllLocalClaimUris(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllProvisioningConnectors28
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.ProvisioningConnectorConfig[] getAllProvisioningConnectors(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllProvisioningConnectors28
            
          */
        public void startgetAllProvisioningConnectors(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param forceDeleteIdP31
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public void forceDeleteIdP(

                        java.lang.String idPName32)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param forceDeleteIdP31
            
          */
        public void startforceDeleteIdP(

            java.lang.String idPName32,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getResidentIDPMetadata34
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public java.lang.String getResidentIDPMetadata(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getResidentIDPMetadata34
            
          */
        public void startgetResidentIDPMetadata(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateIdP37
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public void updateIdP(

                        java.lang.String oldIdPName38,org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider39)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateIdP37
            
          */
        public void startupdateIdP(

            java.lang.String oldIdPName38,org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider39,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllFederatedAuthenticators41
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.FederatedAuthenticatorConfig[] getAllFederatedAuthenticators(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllFederatedAuthenticators41
            
          */
        public void startgetAllFederatedAuthenticators(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEnabledAllIdPs44
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider[] getEnabledAllIdPs(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEnabledAllIdPs44
            
          */
        public void startgetEnabledAllIdPs(

            

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getIdPByName47
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider getIdPByName(

                        java.lang.String idPName48)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getIdPByName47
            
          */
        public void startgetIdPByName(

            java.lang.String idPName48,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteIdP51
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public void deleteIdP(

                        java.lang.String idPName52)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteIdP51
            
          */
        public void startdeleteIdP(

            java.lang.String idPName52,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateResidentIdP54
                
             * @throws org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException : 
         */

         
                     public void updateResidentIdP(

                        org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider55)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceIdentityProviderManagementExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateResidentIdP54
            
          */
        public void startupdateResidentIdP(

            org.wso2.carbon.identity.application.common.model.idp.xsd.IdentityProvider identityProvider55,

            final org.wso2.carbon.idp.mgt.stub.IdentityProviderMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    