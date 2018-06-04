

/**
 * UserInformationRecoveryService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.mgt.stub;

    /*
     *  UserInformationRecoveryService java interface
     */

    public interface UserInformationRecoveryService {
          

        /**
          * Auto generated method signature
          * 
                    * @param updatePassword40
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean updatePassword(

                        java.lang.String username41,java.lang.String confirmationCode42,java.lang.String newPassword43)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updatePassword40
            
          */
        public void startupdatePassword(

            java.lang.String username41,java.lang.String confirmationCode42,java.lang.String newPassword43,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserChallengeQuestions46
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserChallengesCollectionDTO getUserChallengeQuestions(

                        java.lang.String userName47,java.lang.String confirmation48)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserChallengeQuestions46
            
          */
        public void startgetUserChallengeQuestions(

            java.lang.String userName47,java.lang.String confirmation48,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserChallengeQuestion51
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO getUserChallengeQuestion(

                        java.lang.String userName52,java.lang.String confirmation53,java.lang.String questionId54)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserChallengeQuestion51
            
          */
        public void startgetUserChallengeQuestion(

            java.lang.String userName52,java.lang.String confirmation53,java.lang.String questionId54,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param verifyAccount57
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyAccount(

                        org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] claims58,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha59,java.lang.String tenantDomain60)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyAccount57
            
          */
        public void startverifyAccount(

            org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] claims58,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha59,java.lang.String tenantDomain60,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param sendRecoveryNotification63
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean sendRecoveryNotification(

                        java.lang.String username64,java.lang.String key65,java.lang.String notificationType66)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param sendRecoveryNotification63
            
          */
        public void startsendRecoveryNotification(

            java.lang.String username64,java.lang.String key65,java.lang.String notificationType66,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param verifyUser69
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyUser(

                        java.lang.String username70,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha71)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyUser69
            
          */
        public void startverifyUser(

            java.lang.String username70,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha71,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllChallengeQuestions74
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionDTO[] getAllChallengeQuestions(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllChallengeQuestions74
            
          */
        public void startgetAllChallengeQuestions(

            

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resendSignUpConfiramtionCode77
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean resendSignUpConfiramtionCode(

                        java.lang.String userName78,java.lang.String code79,java.lang.String profileName80,java.lang.String tenantDomain81)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resendSignUpConfiramtionCode77
            
          */
        public void startresendSignUpConfiramtionCode(

            java.lang.String userName78,java.lang.String code79,java.lang.String profileName80,java.lang.String tenantDomain81,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param verifyUserChallengeAnswer84
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyUserChallengeAnswer(

                        java.lang.String userName85,java.lang.String confirmation86,java.lang.String questionId87,java.lang.String answer88)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyUserChallengeAnswer84
            
          */
        public void startverifyUserChallengeAnswer(

            java.lang.String userName85,java.lang.String confirmation86,java.lang.String questionId87,java.lang.String answer88,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param confirmUserSelfRegistration91
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean confirmUserSelfRegistration(

                        java.lang.String username92,java.lang.String code93,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha94,java.lang.String tenantDomain95)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param confirmUserSelfRegistration91
            
          */
        public void startconfirmUserSelfRegistration(

            java.lang.String username92,java.lang.String code93,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha94,java.lang.String tenantDomain95,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param verifyUserChallengeAnswers98
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyUserChallengeAnswers(

                        java.lang.String userName99,java.lang.String confirmation100,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] userChallengesDTOs101)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyUserChallengeAnswers98
            
          */
        public void startverifyUserChallengeAnswers(

            java.lang.String userName99,java.lang.String confirmation100,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] userChallengesDTOs101,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserChallengeQuestionIds104
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionIdsDTO getUserChallengeQuestionIds(

                        java.lang.String username105,java.lang.String confirmation106)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserChallengeQuestionIds104
            
          */
        public void startgetUserChallengeQuestionIds(

            java.lang.String username105,java.lang.String confirmation106,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param verifyConfirmationCode109
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean verifyConfirmationCode(

                        java.lang.String username110,java.lang.String code111,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha112)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param verifyConfirmationCode109
            
          */
        public void startverifyConfirmationCode(

            java.lang.String username110,java.lang.String code111,org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean captcha112,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserIdentitySupportedClaims115
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] getUserIdentitySupportedClaims(

                        java.lang.String dialect116)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserIdentitySupportedClaims115
            
          */
        public void startgetUserIdentitySupportedClaims(

            java.lang.String dialect116,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getCaptcha119
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.captcha.mgt.beans.xsd.CaptchaInfoBean getCaptcha(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getCaptcha119
            
          */
        public void startgetCaptcha(

            

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param registerUser122
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.beans.VerificationBean registerUser(

                        java.lang.String userName123,java.lang.String password124,org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] claims125,java.lang.String profileName126,java.lang.String tenantDomain127)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param registerUser122
            
          */
        public void startregisterUser(

            java.lang.String userName123,java.lang.String password124,org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] claims125,java.lang.String profileName126,java.lang.String tenantDomain127,

            final org.wso2.carbon.identity.mgt.stub.UserInformationRecoveryServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    