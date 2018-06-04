

/**
 * UserStoreConfigAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.user.store.configuration.stub;

    /*
     *  UserStoreConfigAdminService java interface
     */

    public interface UserStoreConfigAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param getAvailableUserStoreClasses6
                
             * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */

         
                     public java.lang.String[] getAvailableUserStoreClasses(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAvailableUserStoreClasses6
            
          */
        public void startgetAvailableUserStoreClasses(

            

            final org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  changeUserStoreState(
         java.lang.String domain10,boolean isDisable11

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        

        /**
          * Auto generated method signature
          * 
                    * @param testRDBMSConnection12
                
             * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */

         
                     public boolean testRDBMSConnection(

                        java.lang.String domainName13,java.lang.String driverName14,java.lang.String connectionURL15,java.lang.String username16,java.lang.String connectionPassword17,java.lang.String messageID18)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param testRDBMSConnection12
            
          */
        public void starttestRDBMSConnection(

            java.lang.String domainName13,java.lang.String driverName14,java.lang.String connectionURL15,java.lang.String username16,java.lang.String connectionPassword17,java.lang.String messageID18,

            final org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  editUserStoreWithDomainName(
         java.lang.String previousDomainName22,org.wso2.carbon.identity.user.store.configuration.stub.dto.UserStoreDTO userStoreDTO23

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getSecondaryRealmConfigurations24
                
             * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */

         
                     public org.wso2.carbon.identity.user.store.configuration.stub.dto.UserStoreDTO[] getSecondaryRealmConfigurations(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getSecondaryRealmConfigurations24
            
          */
        public void startgetSecondaryRealmConfigurations(

            

            final org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  editUserStore(
         org.wso2.carbon.identity.user.store.configuration.stub.dto.UserStoreDTO userStoreDTO28

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  deleteUserStoresSet(
         java.lang.String[] domains30

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  addUserStore(
         org.wso2.carbon.identity.user.store.configuration.stub.dto.UserStoreDTO userStoreDTO32

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getUserStoreManagerProperties33
                
             * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */

         
                     public org.wso2.carbon.identity.user.store.configuration.stub.api.Properties getUserStoreManagerProperties(

                        java.lang.String className34)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserStoreManagerProperties33
            
          */
        public void startgetUserStoreManagerProperties(

            java.lang.String className34,

            final org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException : 
         */
        public void  deleteUserStore(
         java.lang.String domainName38

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.store.configuration.stub.UserStoreConfigAdminServiceIdentityUserStoreMgtException;

        

        
       //
       }
    