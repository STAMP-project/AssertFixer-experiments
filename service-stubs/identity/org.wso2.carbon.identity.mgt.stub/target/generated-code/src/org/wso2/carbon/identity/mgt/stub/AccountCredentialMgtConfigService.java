

/**
 * AccountCredentialMgtConfigService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.mgt.stub;

    /*
     *  AccountCredentialMgtConfigService java interface
     */

    public interface AccountCredentialMgtConfigService {
          

        /**
          * Auto generated method signature
          * 
                    * @param saveEmailConfig1
                
             * @throws org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void saveEmailConfig(

                        org.wso2.carbon.identity.mgt.stub.dto.EmailTemplateDTO[] emailTemplates2)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param saveEmailConfig1
            
          */
        public void startsaveEmailConfig(

            org.wso2.carbon.identity.mgt.stub.dto.EmailTemplateDTO[] emailTemplates2,

            final org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEmailConfig4
                
             * @throws org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.EmailTemplateDTO[] getEmailConfig(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEmailConfig4
            
          */
        public void startgetEmailConfig(

            

            final org.wso2.carbon.identity.mgt.stub.AccountCredentialMgtConfigServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    