

/**
 * MultipleCredentialsUserAdmin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.user.mgt.stub;

    /*
     *  MultipleCredentialsUserAdmin java interface
     */

    public interface MultipleCredentialsUserAdmin {
          

        /**
          * Auto generated method signature
          * 
                    * @param getUserId48
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public java.lang.String getUserId(

                        org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential49)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserId48
            
          */
        public void startgetUserId(

            org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential49,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  deleteCredential(
         java.lang.String identifier53,java.lang.String credentialType54

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  deleteUser(
         java.lang.String identifier56,java.lang.String credentialType57

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getAllUserClaimValues58
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] getAllUserClaimValues(

                        java.lang.String identifer59,java.lang.String credentialType60,java.lang.String profileName61)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllUserClaimValues58
            
          */
        public void startgetAllUserClaimValues(

            java.lang.String identifer59,java.lang.String credentialType60,java.lang.String profileName61,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  addUserWithUserId(
         java.lang.String userId65,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential66,java.lang.String[] roleList67,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] claims68,java.lang.String profileName69

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  setUserClaimValue(
         java.lang.String identifer71,java.lang.String credentialType72,java.lang.String claimURI73,java.lang.String claimValue74,java.lang.String profileName75

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUserClaimValues76
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] getUserClaimValues(

                        java.lang.String identifer77,java.lang.String credentialType78,java.lang.String[] claims79,java.lang.String profileName80)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserClaimValues76
            
          */
        public void startgetUserClaimValues(

            java.lang.String identifer77,java.lang.String credentialType78,java.lang.String[] claims79,java.lang.String profileName80,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserClaimValue83
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public java.lang.String getUserClaimValue(

                        java.lang.String identifer84,java.lang.String credentialType85,java.lang.String claimUri86,java.lang.String profileName87)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserClaimValue83
            
          */
        public void startgetUserClaimValue(

            java.lang.String identifer84,java.lang.String credentialType85,java.lang.String claimUri86,java.lang.String profileName87,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  setUserClaimValues(
         java.lang.String identifer91,java.lang.String credentialType92,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] claims93,java.lang.String profileName94

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  deleteUserClaimValue(
         java.lang.String identifer96,java.lang.String credentialType97,java.lang.String claimURI98,java.lang.String profileName99

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  addCredential(
         java.lang.String anIdentifier101,java.lang.String credentialType102,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential103

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  addUsers(
         org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential[] credential105,java.lang.String[] roleList106,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] claims107,java.lang.String profileName108

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getCredentials109
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential[] getCredentials(

                        java.lang.String anIdentifier110,java.lang.String credentialType111)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCredentials109
            
          */
        public void startgetCredentials(

            java.lang.String anIdentifier110,java.lang.String credentialType111,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  addUser(
         org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential115,java.lang.String[] roleList116,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.carbon.ClaimValue[] claims117,java.lang.String profileName118

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  updateCredential(
         java.lang.String identifier120,java.lang.String credentialType121,org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential122

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */
        public void  deleteUserClaimValues(
         java.lang.String identifer124,java.lang.String credentialType125,java.lang.String[] claims126,java.lang.String profileName127

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param authenticate128
                
             * @throws org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException : 
         */

         
                     public boolean authenticate(

                        org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential129)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminMultipleCredentialsUserAdminExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param authenticate128
            
          */
        public void startauthenticate(

            org.wso2.carbon.user.mgt.multiplecredentials.stub.types.Credential credential129,

            final org.wso2.carbon.user.mgt.stub.MultipleCredentialsUserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    