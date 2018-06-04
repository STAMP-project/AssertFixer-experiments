

/**
 * UserStoreCountService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.user.store.count.stub;

    /*
     *  UserStoreCountService java interface
     */

    public interface UserStoreCountService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getCountEnabledUserStores17
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public java.lang.String[] getCountEnabledUserStores(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCountEnabledUserStores17
            
          */
        public void startgetCountEnabledUserStores(

            

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countRoles20
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] countRoles(

                        java.lang.String filter21)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countRoles20
            
          */
        public void startcountRoles(

            java.lang.String filter21,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countByClaimInDomain24
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public long countByClaimInDomain(

                        java.lang.String claimURI25,java.lang.String valueFilter26,java.lang.String domain27)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countByClaimInDomain24
            
          */
        public void startcountByClaimInDomain(

            java.lang.String claimURI25,java.lang.String valueFilter26,java.lang.String domain27,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countByClaimsInDomain30
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public long countByClaimsInDomain(

                        org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] claimSetToFilter31,java.lang.String domain32)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countByClaimsInDomain30
            
          */
        public void startcountByClaimsInDomain(

            org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] claimSetToFilter31,java.lang.String domain32,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countClaims35
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] countClaims(

                        org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] claimSetToFilter36)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countClaims35
            
          */
        public void startcountClaims(

            org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] claimSetToFilter36,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countUsersInDomain39
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public long countUsersInDomain(

                        java.lang.String filter40,java.lang.String domain41)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countUsersInDomain39
            
          */
        public void startcountUsersInDomain(

            java.lang.String filter40,java.lang.String domain41,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countUsers44
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] countUsers(

                        java.lang.String filter45)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countUsers44
            
          */
        public void startcountUsers(

            java.lang.String filter45,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countRolesInDomain48
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public long countRolesInDomain(

                        java.lang.String filter49,java.lang.String domain50)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countRolesInDomain48
            
          */
        public void startcountRolesInDomain(

            java.lang.String filter49,java.lang.String domain50,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param countClaim53
                
             * @throws org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException : 
         */

         
                     public org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] countClaim(

                        java.lang.String claimURI54,java.lang.String valueFilter55)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceUserStoreCounterException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param countClaim53
            
          */
        public void startcountClaim(

            java.lang.String claimURI54,java.lang.String valueFilter55,

            final org.wso2.carbon.identity.user.store.count.stub.UserStoreCountServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    