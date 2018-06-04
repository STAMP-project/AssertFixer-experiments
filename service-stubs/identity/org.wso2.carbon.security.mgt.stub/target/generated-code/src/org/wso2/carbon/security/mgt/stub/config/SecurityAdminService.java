

/**
 * SecurityAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.security.mgt.stub.config;

    /*
     *  SecurityAdminService java interface
     */

    public interface SecurityAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param applySecurity4
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void applySecurity(

                        org.wso2.carbon.security.mgt.stub.config.ApplySecurity applySecurity4)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param applySecurity4
            
          */
        public void startapplySecurity(

            org.wso2.carbon.security.mgt.stub.config.ApplySecurity applySecurity4,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param disableSecurityOnService6
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void disableSecurityOnService(

                        org.wso2.carbon.security.mgt.stub.config.DisableSecurityOnService disableSecurityOnService6)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param disableSecurityOnService6
            
          */
        public void startdisableSecurityOnService(

            org.wso2.carbon.security.mgt.stub.config.DisableSecurityOnService disableSecurityOnService6,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getScenarios8
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.config.GetScenariosResponse getScenarios(

                        org.wso2.carbon.security.mgt.stub.config.GetScenarios getScenarios8)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getScenarios8
            
          */
        public void startgetScenarios(

            org.wso2.carbon.security.mgt.stub.config.GetScenarios getScenarios8,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param applyKerberosSecurityPolicy10
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void applyKerberosSecurityPolicy(

                        org.wso2.carbon.security.mgt.stub.config.ApplyKerberosSecurityPolicy applyKerberosSecurityPolicy10)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param applyKerberosSecurityPolicy10
            
          */
        public void startapplyKerberosSecurityPolicy(

            org.wso2.carbon.security.mgt.stub.config.ApplyKerberosSecurityPolicy applyKerberosSecurityPolicy10,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSecurityScenario12
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.config.GetSecurityScenarioResponse getSecurityScenario(

                        org.wso2.carbon.security.mgt.stub.config.GetSecurityScenario getSecurityScenario12)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSecurityScenario12
            
          */
        public void startgetSecurityScenario(

            org.wso2.carbon.security.mgt.stub.config.GetSecurityScenario getSecurityScenario12,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSecurityConfigData14
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.config.GetSecurityConfigDataResponse getSecurityConfigData(

                        org.wso2.carbon.security.mgt.stub.config.GetSecurityConfigData getSecurityConfigData14)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSecurityConfigData14
            
          */
        public void startgetSecurityConfigData(

            org.wso2.carbon.security.mgt.stub.config.GetSecurityConfigData getSecurityConfigData14,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param activateUsernameTokenAuthentication16
                
             * @throws org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void activateUsernameTokenAuthentication(

                        org.wso2.carbon.security.mgt.stub.config.ActivateUsernameTokenAuthentication activateUsernameTokenAuthentication16)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param activateUsernameTokenAuthentication16
            
          */
        public void startactivateUsernameTokenAuthentication(

            org.wso2.carbon.security.mgt.stub.config.ActivateUsernameTokenAuthentication activateUsernameTokenAuthentication16,

            final org.wso2.carbon.security.mgt.stub.config.SecurityAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    