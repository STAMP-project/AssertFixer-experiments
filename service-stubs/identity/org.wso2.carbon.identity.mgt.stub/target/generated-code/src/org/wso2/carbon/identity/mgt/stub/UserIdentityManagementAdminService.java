

/**
 * UserIdentityManagementAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.mgt.stub;

    /*
     *  UserIdentityManagementAdminService java interface
     */

    public interface UserIdentityManagementAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param changeUserPassword25
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void changeUserPassword(

                        java.lang.String newPassword26,java.lang.String oldPassword27)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changeUserPassword25
            
          */
        public void startchangeUserPassword(

            java.lang.String newPassword26,java.lang.String oldPassword27,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param resetUserPassword29
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void resetUserPassword(

                        java.lang.String userName30,java.lang.String newPassword31)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param resetUserPassword29
            
          */
        public void startresetUserPassword(

            java.lang.String userName30,java.lang.String newPassword31,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param enableUserAccount33
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void enableUserAccount(

                        java.lang.String userName34,java.lang.String notificationType35)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param enableUserAccount33
            
          */
        public void startenableUserAccount(

            java.lang.String userName34,java.lang.String notificationType35,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getChallengeQuestionsOfUser37
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] getChallengeQuestionsOfUser(

                        java.lang.String userName38)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getChallengeQuestionsOfUser37
            
          */
        public void startgetChallengeQuestionsOfUser(

            java.lang.String userName38,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isReadOnlyUserStore41
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public boolean isReadOnlyUserStore(

                        java.lang.String userName42,java.lang.String tenantDomain43)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isReadOnlyUserStore41
            
          */
        public void startisReadOnlyUserStore(

            java.lang.String userName42,java.lang.String tenantDomain43,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param unlockUserAccount46
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void unlockUserAccount(

                        java.lang.String userName47,java.lang.String notificationType48)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param unlockUserAccount46
            
          */
        public void startunlockUserAccount(

            java.lang.String userName47,java.lang.String notificationType48,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param disableUserAccount50
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void disableUserAccount(

                        java.lang.String userName51,java.lang.String notificationType52)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param disableUserAccount50
            
          */
        public void startdisableUserAccount(

            java.lang.String userName51,java.lang.String notificationType52,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllChallengeQuestions54
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionDTO[] getAllChallengeQuestions(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllChallengeQuestions54
            
          */
        public void startgetAllChallengeQuestions(

            

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUserIdentityClaims57
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void updateUserIdentityClaims(

                        org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] userIdentityClaims58)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUserIdentityClaims57
            
          */
        public void startupdateUserIdentityClaims(

            org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] userIdentityClaims58,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllUserIdentityClaims60
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] getAllUserIdentityClaims(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllUserIdentityClaims60
            
          */
        public void startgetAllUserIdentityClaims(

            

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param lockUserAccount63
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void lockUserAccount(

                        java.lang.String userName64)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param lockUserAccount63
            
          */
        public void startlockUserAccount(

            java.lang.String userName64,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setChallengeQuestionsOfUser66
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void setChallengeQuestionsOfUser(

                        java.lang.String userName67,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] challengesDTOs68)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setChallengeQuestionsOfUser66
            
          */
        public void startsetChallengeQuestionsOfUser(

            java.lang.String userName67,org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] challengesDTOs68,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUser70
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void deleteUser(

                        java.lang.String userName71)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUser70
            
          */
        public void startdeleteUser(

            java.lang.String userName71,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param setChallengeQuestions73
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public void setChallengeQuestions(

                        org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionDTO[] challengeQuestionDTOs74)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param setChallengeQuestions73
            
          */
        public void startsetChallengeQuestions(

            org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionDTO[] challengeQuestionDTOs74,

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllPromotedUserChallenge76
                
             * @throws org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException : 
         */

         
                     public org.wso2.carbon.identity.mgt.stub.dto.UserChallengesSetDTO[] getAllPromotedUserChallenge(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceIdentityMgtServiceExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllPromotedUserChallenge76
            
          */
        public void startgetAllPromotedUserChallenge(

            

            final org.wso2.carbon.identity.mgt.stub.UserIdentityManagementAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    