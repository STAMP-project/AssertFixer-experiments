

/**
 * ClaimManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.claim.mgt.stub;

    /*
     *  ClaimManagementService java interface
     */

    public interface ClaimManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param removeClaimDialect9
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public void removeClaimDialect(

                        java.lang.String dialectUri10)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeClaimDialect9
            
          */
        public void startremoveClaimDialect(

            java.lang.String dialectUri10,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeClaimMapping12
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public void removeClaimMapping(

                        java.lang.String dialectUri13,java.lang.String claimUri14)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeClaimMapping12
            
          */
        public void startremoveClaimMapping(

            java.lang.String dialectUri13,java.lang.String claimUri14,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getClaimMappingByDialect16
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO getClaimMappingByDialect(

                        java.lang.String dialectUri17)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getClaimMappingByDialect16
            
          */
        public void startgetClaimMappingByDialect(

            java.lang.String dialectUri17,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addNewClaimDialect20
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public void addNewClaimDialect(

                        org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO claimDialectDTO21)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addNewClaimDialect20
            
          */
        public void startaddNewClaimDialect(

            org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO claimDialectDTO21,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getClaimMappings23
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO[] getClaimMappings(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getClaimMappings23
            
          */
        public void startgetClaimMappings(

            

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addNewClaimMapping26
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public void addNewClaimMapping(

                        org.wso2.carbon.claim.mgt.stub.dto.ClaimMappingDTO claimMappingDTO27)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addNewClaimMapping26
            
          */
        public void startaddNewClaimMapping(

            org.wso2.carbon.claim.mgt.stub.dto.ClaimMappingDTO claimMappingDTO27,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param upateClaimMapping29
                
             * @throws org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException : 
         */

         
                     public void upateClaimMapping(

                        org.wso2.carbon.claim.mgt.stub.dto.ClaimMappingDTO claimMappingDTO30)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceClaimManagementException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param upateClaimMapping29
            
          */
        public void startupateClaimMapping(

            org.wso2.carbon.claim.mgt.stub.dto.ClaimMappingDTO claimMappingDTO30,

            final org.wso2.carbon.claim.mgt.stub.ClaimManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    