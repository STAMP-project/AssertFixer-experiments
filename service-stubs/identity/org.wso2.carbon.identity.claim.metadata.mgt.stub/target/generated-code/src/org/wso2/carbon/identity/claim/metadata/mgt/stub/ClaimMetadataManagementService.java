

/**
 * ClaimMetadataManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.claim.metadata.mgt.stub;

    /*
     *  ClaimMetadataManagementService java interface
     */

    public interface ClaimMetadataManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param renameClaimDialect15
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void renameClaimDialect(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO oldClaimDialect16,org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO newClaimDialect17)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param renameClaimDialect15
            
          */
        public void startrenameClaimDialect(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO oldClaimDialect16,org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO newClaimDialect17,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addExternalClaim19
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void addExternalClaim(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO externalClaim20)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addExternalClaim19
            
          */
        public void startaddExternalClaim(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO externalClaim20,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeLocalClaim22
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void removeLocalClaim(

                        java.lang.String localClaimURI23)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeLocalClaim22
            
          */
        public void startremoveLocalClaim(

            java.lang.String localClaimURI23,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeClaimDialect25
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void removeClaimDialect(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO claimDialect26)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeClaimDialect25
            
          */
        public void startremoveClaimDialect(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO claimDialect26,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addLocalClaim28
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void addLocalClaim(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO localClaim29)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addLocalClaim28
            
          */
        public void startaddLocalClaim(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO localClaim29,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getLocalClaims31
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO[] getLocalClaims(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getLocalClaims31
            
          */
        public void startgetLocalClaims(

            

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeExternalClaim34
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void removeExternalClaim(

                        java.lang.String externalClaimDialectURI35,java.lang.String externalClaimURI36)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeExternalClaim34
            
          */
        public void startremoveExternalClaim(

            java.lang.String externalClaimDialectURI35,java.lang.String externalClaimURI36,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateExternalClaim38
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void updateExternalClaim(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO externalClaim39)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateExternalClaim38
            
          */
        public void startupdateExternalClaim(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO externalClaim39,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getClaimDialects41
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO[] getClaimDialects(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getClaimDialects41
            
          */
        public void startgetClaimDialects(

            

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getExternalClaims44
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO[] getExternalClaims(

                        java.lang.String externalClaimDialectURI45)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getExternalClaims44
            
          */
        public void startgetExternalClaims(

            java.lang.String externalClaimDialectURI45,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateLocalClaim48
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void updateLocalClaim(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO localClaim49)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateLocalClaim48
            
          */
        public void startupdateLocalClaim(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO localClaim49,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addClaimDialect51
                
             * @throws org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException : 
         */

         
                     public void addClaimDialect(

                        org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO claimDialect52)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceClaimMetadataException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addClaimDialect51
            
          */
        public void startaddClaimDialect(

            org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO claimDialect52,

            final org.wso2.carbon.identity.claim.metadata.mgt.stub.ClaimMetadataManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    