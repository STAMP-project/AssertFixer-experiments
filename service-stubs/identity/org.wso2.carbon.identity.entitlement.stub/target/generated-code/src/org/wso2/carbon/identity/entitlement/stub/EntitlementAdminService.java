

/**
 * EntitlementAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.entitlement.stub;

    /*
     *  EntitlementAdminService java interface
     */

    public interface EntitlementAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getGlobalPolicyAlgorithm12
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */

         
                     public java.lang.String getGlobalPolicyAlgorithm(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getGlobalPolicyAlgorithm12
            
          */
        public void startgetGlobalPolicyAlgorithm(

            

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  clearDecisionCache(
         

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  clearAllAttributeCaches(
         

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPIPResourceFinderData17
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PIPFinderDataHolder getPIPResourceFinderData(

                        java.lang.String finder18)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPIPResourceFinderData17
            
          */
        public void startgetPIPResourceFinderData(

            java.lang.String finder18,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  setGlobalPolicyAlgorithm(
         java.lang.String policyCombiningAlgorithm22

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPolicyFinderData23
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PolicyFinderDataHolder getPolicyFinderData(

                        java.lang.String finder24)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPolicyFinderData23
            
          */
        public void startgetPolicyFinderData(

            java.lang.String finder24,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  refreshAttributeFinder(
         java.lang.String attributeFinder28

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  clearCarbonAttributeCache(
         

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPDPData30
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PDPDataHolder getPDPData(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPDPData30
            
          */
        public void startgetPDPData(

            

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  clearAllResourceCaches(
         

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getPIPAttributeFinderData34
                
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.PIPFinderDataHolder getPIPAttributeFinderData(

                        java.lang.String finder35)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPIPAttributeFinderData34
            
          */
        public void startgetPIPAttributeFinderData(

            java.lang.String finder35,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  clearAttributeFinderCache(
         java.lang.String attributeFinder39

        ) throws java.rmi.RemoteException
        
        ;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  clearResourceFinderCache(
         java.lang.String resourceFinder41

        ) throws java.rmi.RemoteException
        
        ;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  clearCarbonResourceCache(
         

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        /**
          * Auto generated method signature
          * 
                    * @param doTestRequest43
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */

         
                     public java.lang.String doTestRequest(

                        java.lang.String xacmlRequest44)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param doTestRequest43
            
          */
        public void startdoTestRequest(

            java.lang.String xacmlRequest44,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param doTestRequestForGivenPolicies47
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */

         
                     public java.lang.String doTestRequestForGivenPolicies(

                        java.lang.String xacmlRequest48,java.lang.String[] policies49)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param doTestRequestForGivenPolicies47
            
          */
        public void startdoTestRequestForGivenPolicies(

            java.lang.String xacmlRequest48,java.lang.String[] policies49,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  refreshResourceFinder(
         java.lang.String resourceFinder53

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
         */
        public void  clearAttributeFinderCacheByAttributes(
         java.lang.String attributeFinder55,java.lang.String[] attributeIds56

        ) throws java.rmi.RemoteException
        
        ;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException : 
         */
        public void  refreshPolicyFinders(
         java.lang.String policyFinder58

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.entitlement.stub.EntitlementAdminServiceIdentityException;

        

        
       //
       }
    