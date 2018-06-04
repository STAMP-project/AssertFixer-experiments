
/**
 * UserIdentityManagementAdminServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.mgt.stub;

    /**
     *  UserIdentityManagementAdminServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class UserIdentityManagementAdminServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public UserIdentityManagementAdminServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public UserIdentityManagementAdminServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for changeUserPassword method
            * override this method for handling normal response from changeUserPassword operation
            */
           public void receiveResultchangeUserPassword(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changeUserPassword operation
           */
            public void receiveErrorchangeUserPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resetUserPassword method
            * override this method for handling normal response from resetUserPassword operation
            */
           public void receiveResultresetUserPassword(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resetUserPassword operation
           */
            public void receiveErrorresetUserPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for enableUserAccount method
            * override this method for handling normal response from enableUserAccount operation
            */
           public void receiveResultenableUserAccount(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from enableUserAccount operation
           */
            public void receiveErrorenableUserAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getChallengeQuestionsOfUser method
            * override this method for handling normal response from getChallengeQuestionsOfUser operation
            */
           public void receiveResultgetChallengeQuestionsOfUser(
                    org.wso2.carbon.identity.mgt.stub.dto.UserChallengesDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getChallengeQuestionsOfUser operation
           */
            public void receiveErrorgetChallengeQuestionsOfUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isReadOnlyUserStore method
            * override this method for handling normal response from isReadOnlyUserStore operation
            */
           public void receiveResultisReadOnlyUserStore(
                    boolean result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isReadOnlyUserStore operation
           */
            public void receiveErrorisReadOnlyUserStore(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for unlockUserAccount method
            * override this method for handling normal response from unlockUserAccount operation
            */
           public void receiveResultunlockUserAccount(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from unlockUserAccount operation
           */
            public void receiveErrorunlockUserAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disableUserAccount method
            * override this method for handling normal response from disableUserAccount operation
            */
           public void receiveResultdisableUserAccount(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disableUserAccount operation
           */
            public void receiveErrordisableUserAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllChallengeQuestions method
            * override this method for handling normal response from getAllChallengeQuestions operation
            */
           public void receiveResultgetAllChallengeQuestions(
                    org.wso2.carbon.identity.mgt.stub.dto.ChallengeQuestionDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllChallengeQuestions operation
           */
            public void receiveErrorgetAllChallengeQuestions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateUserIdentityClaims method
            * override this method for handling normal response from updateUserIdentityClaims operation
            */
           public void receiveResultupdateUserIdentityClaims(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateUserIdentityClaims operation
           */
            public void receiveErrorupdateUserIdentityClaims(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllUserIdentityClaims method
            * override this method for handling normal response from getAllUserIdentityClaims operation
            */
           public void receiveResultgetAllUserIdentityClaims(
                    org.wso2.carbon.identity.mgt.stub.dto.UserIdentityClaimDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllUserIdentityClaims operation
           */
            public void receiveErrorgetAllUserIdentityClaims(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for lockUserAccount method
            * override this method for handling normal response from lockUserAccount operation
            */
           public void receiveResultlockUserAccount(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from lockUserAccount operation
           */
            public void receiveErrorlockUserAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setChallengeQuestionsOfUser method
            * override this method for handling normal response from setChallengeQuestionsOfUser operation
            */
           public void receiveResultsetChallengeQuestionsOfUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setChallengeQuestionsOfUser operation
           */
            public void receiveErrorsetChallengeQuestionsOfUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteUser method
            * override this method for handling normal response from deleteUser operation
            */
           public void receiveResultdeleteUser(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteUser operation
           */
            public void receiveErrordeleteUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setChallengeQuestions method
            * override this method for handling normal response from setChallengeQuestions operation
            */
           public void receiveResultsetChallengeQuestions(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setChallengeQuestions operation
           */
            public void receiveErrorsetChallengeQuestions(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAllPromotedUserChallenge method
            * override this method for handling normal response from getAllPromotedUserChallenge operation
            */
           public void receiveResultgetAllPromotedUserChallenge(
                    org.wso2.carbon.identity.mgt.stub.dto.UserChallengesSetDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAllPromotedUserChallenge operation
           */
            public void receiveErrorgetAllPromotedUserChallenge(java.lang.Exception e) {
            }
                


    }
    