

/**
 * UserProfileMgtService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.user.profile.stub;

    /*
     *  UserProfileMgtService java interface
     */

    public interface UserProfileMgtService {
          
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */
        public void  associateID(
         java.lang.String idpID17,java.lang.String associatedID18

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */
        public void  setUserProfile(
         java.lang.String username20,org.wso2.carbon.identity.user.profile.stub.types.UserProfileDTO profile21

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getNameAssociatedWith22
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public java.lang.String getNameAssociatedWith(

                        java.lang.String idpID23,java.lang.String associatedID24)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getNameAssociatedWith22
            
          */
        public void startgetNameAssociatedWith(

            java.lang.String idpID23,java.lang.String associatedID24,

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */
        public void  deleteUserProfile(
         java.lang.String username28,java.lang.String profileName29

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getInstance30
                
         */

         
                     public org.wso2.carbon.identity.user.profile.stub.types.UserProfileAdmin getInstance(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getInstance30
            
          */
        public void startgetInstance(

            

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAssociatedIDs33
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public org.wso2.carbon.identity.user.profile.stub.types.AssociatedAccountDTO[] getAssociatedIDs(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAssociatedIDs33
            
          */
        public void startgetAssociatedIDs(

            

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getProfileFieldsForInternalStore36
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public org.wso2.carbon.identity.user.profile.stub.types.UserProfileDTO getProfileFieldsForInternalStore(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getProfileFieldsForInternalStore36
            
          */
        public void startgetProfileFieldsForInternalStore(

            

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */
        public void  removeAssociateID(
         java.lang.String idpID40,java.lang.String associatedID41

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param isAddProfileEnabledForDomain42
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public boolean isAddProfileEnabledForDomain(

                        java.lang.String domain43)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isAddProfileEnabledForDomain42
            
          */
        public void startisAddProfileEnabledForDomain(

            java.lang.String domain43,

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserProfiles46
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public org.wso2.carbon.identity.user.profile.stub.types.UserProfileDTO[] getUserProfiles(

                        java.lang.String username47)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserProfiles46
            
          */
        public void startgetUserProfiles(

            java.lang.String username47,

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isAddProfileEnabled50
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public boolean isAddProfileEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isAddProfileEnabled50
            
          */
        public void startisAddProfileEnabled(

            

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isReadOnlyUserStore53
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public boolean isReadOnlyUserStore(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isReadOnlyUserStore53
            
          */
        public void startisReadOnlyUserStore(

            

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserProfile56
                
             * @throws org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException : 
         */

         
                     public org.wso2.carbon.identity.user.profile.stub.types.UserProfileDTO getUserProfile(

                        java.lang.String username57,java.lang.String profileName58)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceUserProfileExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserProfile56
            
          */
        public void startgetUserProfile(

            java.lang.String username57,java.lang.String profileName58,

            final org.wso2.carbon.identity.user.profile.stub.UserProfileMgtServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    