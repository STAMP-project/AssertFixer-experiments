

/**
 * UserIdentityManagementService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.mgt.stub;

    /*
     *  UserIdentityManagementService java interface
     */

    public interface UserIdentityManagementService {
          

        /**
          * Auto generated method signature
          * 
                    * @param updateCredential16
                
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean updateCredential(

                        java.lang.String userName17,java.lang.String confirmation18,java.lang.String password19,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captchaInfoBean20)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateCredential16
            
          */
        public void startupdateCredential(

            java.lang.String userName17,java.lang.String confirmation18,java.lang.String password19,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captchaInfoBean20,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getChallengeQuestionsForUser23
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] getChallengeQuestionsForUser(

                        java.lang.String userName24,java.lang.String confirmation25)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getChallengeQuestionsForUser23
            
          */
        public void startgetChallengeQuestionsForUser(

            java.lang.String userName24,java.lang.String confirmation25,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param authenticateWithTemporaryCredentials28
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] authenticateWithTemporaryCredentials(

                        java.lang.String userName29,java.lang.String tempCredential30)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param authenticateWithTemporaryCredentials28
            
          */
        public void startauthenticateWithTemporaryCredentials(

            java.lang.String userName29,java.lang.String tempCredential30,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param confirmUserRegistration33
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] confirmUserRegistration(

                        java.lang.String userName34,java.lang.String confirmationCode35)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param confirmUserRegistration33
            
          */
        public void startconfirmUserRegistration(

            java.lang.String userName34,java.lang.String confirmationCode35,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param processPasswordRecovery38
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public boolean processPasswordRecovery(

                        java.lang.String userId39,java.lang.String confirmationCode40,java.lang.String notificationType41)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param processPasswordRecovery38
            
          */
        public void startprocessPasswordRecovery(

            java.lang.String userId39,java.lang.String confirmationCode40,java.lang.String notificationType41,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */
        public void  recoverUserIdentityWithEmail(
         java.lang.String userName45

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        

        /**
          * Auto generated method signature
          * 
                    * @param verifyChallengeQuestion46
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyChallengeQuestion(

                        java.lang.String userName47,java.lang.String confirmation48,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] userChallengesDTOs49)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyChallengeQuestion46
            
          */
        public void startverifyChallengeQuestion(

            java.lang.String userName47,java.lang.String confirmation48,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] userChallengesDTOs49,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPrimarySecurityQuestions52
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */

         
                     public java.lang.String[] getPrimarySecurityQuestions(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPrimarySecurityQuestions52
            
          */
        public void startgetPrimarySecurityQuestions(

            

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param confirmUserAccount55
                
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean confirmUserAccount(

                        java.lang.String confirmationKey56)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param confirmUserAccount55
            
          */
        public void startconfirmUserAccount(

            java.lang.String confirmationKey56,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException : 
         */
        public void  recoverUserIdentityWithSecurityQuestions(
         java.lang.String userName60,org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] secQuesAnsweres61

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementServiceIdentityMgtServiceExceptionException;

        

        
       //
       }
    