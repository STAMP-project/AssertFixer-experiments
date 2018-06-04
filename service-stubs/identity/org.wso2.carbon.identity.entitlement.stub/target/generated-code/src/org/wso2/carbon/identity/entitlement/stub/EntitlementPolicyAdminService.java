

/**
 * EntitlementPolicyAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.entitlement.stub;

    /*
     *  EntitlementPolicyAdminService java interface
     */

    public interface EntitlementPolicyAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getEntitlementData34
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.EntitlementTreeNodeDTO getEntitlementData(

                        java.lang.String dataModule35,java.lang.String category36,java.lang.String regexp37,int dataLevel38,int limit39)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEntitlementData34
            
          */
        public void startgetEntitlementData(

            java.lang.String dataModule35,java.lang.String category36,java.lang.String regexp37,int dataLevel38,int limit39,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllPolicyIds42
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public java.lang.String[] getAllPolicyIds(

                        java.lang.String searchString43)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllPolicyIds42
            
          */
        public void startgetAllPolicyIds(

            java.lang.String searchString43,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEntitlementDataModules46
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.EntitlementFinderDataHolder[] getEntitlementDataModules(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEntitlementDataModules46
            
          */
        public void startgetEntitlementDataModules(

            

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getSubscriber49
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PublisherDataHolder getSubscriber(

                        java.lang.String subscribeId50)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSubscriber49
            
          */
        public void startgetSubscriber(

            java.lang.String subscribeId50,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllPolicies53
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PaginatedPolicySetDTO getAllPolicies(

                        java.lang.String policyTypeFilter54,java.lang.String policySearchString55,int pageNumber56,boolean isPDPPolicy57)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllPolicies53
            
          */
        public void startgetAllPolicies(

            java.lang.String policyTypeFilter54,java.lang.String policySearchString55,int pageNumber56,boolean isPDPPolicy57,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  updatePolicy(
         org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO policyDTO61

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  addPolicy(
         org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO policyDTO63

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  deleteSubscriber(
         java.lang.String subscriberId65

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  addPolicies(
         org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO[] policies67

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPolicyVersions68
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public java.lang.String[] getPolicyVersions(

                        java.lang.String policyId69)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPolicyVersions68
            
          */
        public void startgetPolicyVersions(

            java.lang.String policyId69,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  addSubscriber(
         org.wso2.carbon.identity.entitlement.stub.dto.PublisherDataHolder holder73

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getSubscriberIds74
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public java.lang.String[] getSubscriberIds(

                        java.lang.String searchString75)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSubscriberIds74
            
          */
        public void startgetSubscriberIds(

            java.lang.String searchString75,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  updateSubscriber(
         org.wso2.carbon.identity.entitlement.stub.dto.PublisherDataHolder holder79

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  dePromotePolicy(
         java.lang.String policyId81

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getLightPolicy82
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO getLightPolicy(

                        java.lang.String policyId83)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getLightPolicy82
            
          */
        public void startgetLightPolicy(

            java.lang.String policyId83,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  orderPolicy(
         java.lang.String policyId87,int newOrder88

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  rollBackPolicy(
         java.lang.String policyId90,java.lang.String version91

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  importPolicyFromRegistry(
         java.lang.String policyRegistryPath93

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPolicyByVersion94
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO getPolicyByVersion(

                        java.lang.String policyId95,java.lang.String version96)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPolicyByVersion94
            
          */
        public void startgetPolicyByVersion(

            java.lang.String policyId95,java.lang.String version96,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  removePolicy(
         java.lang.String policyId100,boolean dePromote101

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPolicy102
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PolicyDTO getPolicy(

                        java.lang.String policyId103,boolean isPDPPolicy104)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPolicy102
            
          */
        public void startgetPolicy(

            java.lang.String policyId103,boolean isPDPPolicy104,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getStatusData107
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PaginatedStatusHolder getStatusData(

                        java.lang.String about108,java.lang.String key109,java.lang.String type110,java.lang.String searchString111,int pageNumber112)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getStatusData107
            
          */
        public void startgetStatusData(

            java.lang.String about108,java.lang.String key109,java.lang.String type110,java.lang.String searchString111,int pageNumber112,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPublisherModuleData115
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PublisherDataHolder[] getPublisherModuleData(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPublisherModuleData115
            
          */
        public void startgetPublisherModuleData(

            

            final org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  enableDisablePolicy(
         java.lang.String policyId119,boolean enable120

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  publish(
         java.lang.String verificationCode122

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  removePolicies(
         java.lang.String[] policyIds124,boolean dePromote125

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  publishPolicies(
         java.lang.String[] policyIds127,java.lang.String[] subscriberIds128,java.lang.String action129,java.lang.String version130,boolean enabled131,int order132

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException : 
         */
        public void  publishToPDP(
         java.lang.String[] policyIds134,java.lang.String action135,java.lang.String version136,boolean enabled137,int order138

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementPolicyAdminServiceEntitlementException;

        

        
       //
       }
    