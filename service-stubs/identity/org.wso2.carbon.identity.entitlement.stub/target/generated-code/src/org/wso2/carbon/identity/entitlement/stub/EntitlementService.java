

/**
 * EntitlementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.entitlement.stub;

    /*
     *  EntitlementService java interface
     */

    public interface EntitlementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getEntitledAttributes10
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceIdentityException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.EntitledResultSetDTO getEntitledAttributes(

                        java.lang.String subjectName11,java.lang.String resourceName12,java.lang.String subjectId13,java.lang.String action14,boolean enableChildSearch15)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEntitledAttributes10
            
          */
        public void startgetEntitledAttributes(

            java.lang.String subjectName11,java.lang.String resourceName12,java.lang.String subjectId13,java.lang.String action14,boolean enableChildSearch15,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getDecisionByAttributes18
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException : 
         */

         
                     public java.lang.String getDecisionByAttributes(

                        java.lang.String subject19,java.lang.String resource20,java.lang.String action21,java.lang.String[] environment22)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getDecisionByAttributes18
            
          */
        public void startgetDecisionByAttributes(

            java.lang.String subject19,java.lang.String resource20,java.lang.String action21,java.lang.String[] environment22,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getDecision25
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException : 
         */

         
                     public java.lang.String getDecision(

                        java.lang.String request26)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getDecision25
            
          */
        public void startgetDecision(

            java.lang.String request26,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param xACMLAuthzDecisionQuery29
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException : 
         */

         
                     public java.lang.String xACMLAuthzDecisionQuery(

                        java.lang.String request30)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param xACMLAuthzDecisionQuery29
            
          */
        public void startxACMLAuthzDecisionQuery(

            java.lang.String request30,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getBooleanDecision33
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException : 
         */

         
                     public boolean getBooleanDecision(

                        java.lang.String subject34,java.lang.String resource35,java.lang.String action36)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getBooleanDecision33
            
          */
        public void startgetBooleanDecision(

            java.lang.String subject34,java.lang.String resource35,java.lang.String action36,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllEntitlements39
                
             * @throws org.wso2.carbon.identity.entitlement.stub.EntitlementServiceIdentityException : 
         */

         
                     public org.wso2.carbon.identity.entitlement.stub.dto.EntitledResultSetDTO getAllEntitlements(

                        java.lang.String identifier40,org.wso2.carbon.identity.entitlement.stub.dto.AttributeDTO[] givenAttributes41)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.entitlement.stub.EntitlementServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllEntitlements39
            
          */
        public void startgetAllEntitlements(

            java.lang.String identifier40,org.wso2.carbon.identity.entitlement.stub.dto.AttributeDTO[] givenAttributes41,

            final org.wso2.carbon.identity.entitlement.stub.EntitlementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    