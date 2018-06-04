

/**
 * UserRegistrationAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.user.registration.stub;

    /*
     *  UserRegistrationAdminService java interface
     */

    public interface UserRegistrationAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param isAddUserEnabled5
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException : 
         */

         
                     public boolean isAddUserEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isAddUserEnabled5
            
          */
        public void startisAddUserEnabled(

            

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param readUserFieldsForUserRegistration8
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceIdentityException : 
         */

         
                     public org.wso2.carbon.identity.user.registration.stub.dto.UserFieldDTO[] readUserFieldsForUserRegistration(

                        java.lang.String dialect9)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param readUserFieldsForUserRegistration8
            
          */
        public void startreadUserFieldsForUserRegistration(

            java.lang.String dialect9,

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isUserExist12
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceUserRegistrationException : 
         */

         
                     public boolean isUserExist(

                        java.lang.String username13)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceUserRegistrationException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isUserExist12
            
          */
        public void startisUserExist(

            java.lang.String username13,

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPasswordRegularExpressions16
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceIdentityException : 
         */

         
                     public org.wso2.carbon.identity.user.registration.stub.dto.PasswordRegExDTO[] getPasswordRegularExpressions(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceIdentityException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPasswordRegularExpressions16
            
          */
        public void startgetPasswordRegularExpressions(

            

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException : 
         */
        public void  addUser(
         org.wso2.carbon.identity.user.registration.stub.dto.UserDTO user20

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException;

        

        /**
          * Auto generated method signature
          * 
                    * @param isAddUserWithOpenIDEnabled21
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException : 
         */

         
                     public boolean isAddUserWithOpenIDEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isAddUserWithOpenIDEnabled21
            
          */
        public void startisAddUserWithOpenIDEnabled(

            

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isAddUserWithInfoCardEnabled24
                
             * @throws org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException : 
         */

         
                     public boolean isAddUserWithInfoCardEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isAddUserWithInfoCardEnabled24
            
          */
        public void startisAddUserWithInfoCardEnabled(

            

            final org.wso2.carbon.identity.user.registration.stub.UserRegistrationAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    