
/**
 * UserStoreCountServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.user.store.count.stub;

    /**
     *  UserStoreCountServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class UserStoreCountServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public UserStoreCountServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public UserStoreCountServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getCountEnabledUserStores method
            * override this method for handling normal response from getCountEnabledUserStores operation
            */
           public void receiveResultgetCountEnabledUserStores(
                    java.lang.String[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCountEnabledUserStores operation
           */
            public void receiveErrorgetCountEnabledUserStores(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countRoles method
            * override this method for handling normal response from countRoles operation
            */
           public void receiveResultcountRoles(
                    org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countRoles operation
           */
            public void receiveErrorcountRoles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countByClaimInDomain method
            * override this method for handling normal response from countByClaimInDomain operation
            */
           public void receiveResultcountByClaimInDomain(
                    long result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countByClaimInDomain operation
           */
            public void receiveErrorcountByClaimInDomain(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countByClaimsInDomain method
            * override this method for handling normal response from countByClaimsInDomain operation
            */
           public void receiveResultcountByClaimsInDomain(
                    long result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countByClaimsInDomain operation
           */
            public void receiveErrorcountByClaimsInDomain(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countClaims method
            * override this method for handling normal response from countClaims operation
            */
           public void receiveResultcountClaims(
                    org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countClaims operation
           */
            public void receiveErrorcountClaims(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countUsersInDomain method
            * override this method for handling normal response from countUsersInDomain operation
            */
           public void receiveResultcountUsersInDomain(
                    long result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countUsersInDomain operation
           */
            public void receiveErrorcountUsersInDomain(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countUsers method
            * override this method for handling normal response from countUsers operation
            */
           public void receiveResultcountUsers(
                    org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countUsers operation
           */
            public void receiveErrorcountUsers(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countRolesInDomain method
            * override this method for handling normal response from countRolesInDomain operation
            */
           public void receiveResultcountRolesInDomain(
                    long result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countRolesInDomain operation
           */
            public void receiveErrorcountRolesInDomain(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for countClaim method
            * override this method for handling normal response from countClaim operation
            */
           public void receiveResultcountClaim(
                    org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from countClaim operation
           */
            public void receiveErrorcountClaim(java.lang.Exception e) {
            }
                


    }
    