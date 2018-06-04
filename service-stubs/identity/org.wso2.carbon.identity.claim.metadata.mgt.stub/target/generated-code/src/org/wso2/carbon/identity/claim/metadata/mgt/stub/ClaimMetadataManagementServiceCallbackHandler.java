
/**
 * ClaimMetadataManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.claim.metadata.mgt.stub;

    /**
     *  ClaimMetadataManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ClaimMetadataManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ClaimMetadataManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ClaimMetadataManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for renameClaimDialect method
            * override this method for handling normal response from renameClaimDialect operation
            */
           public void receiveResultrenameClaimDialect(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from renameClaimDialect operation
           */
            public void receiveErrorrenameClaimDialect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addExternalClaim method
            * override this method for handling normal response from addExternalClaim operation
            */
           public void receiveResultaddExternalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addExternalClaim operation
           */
            public void receiveErroraddExternalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeLocalClaim method
            * override this method for handling normal response from removeLocalClaim operation
            */
           public void receiveResultremoveLocalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeLocalClaim operation
           */
            public void receiveErrorremoveLocalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeClaimDialect method
            * override this method for handling normal response from removeClaimDialect operation
            */
           public void receiveResultremoveClaimDialect(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeClaimDialect operation
           */
            public void receiveErrorremoveClaimDialect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addLocalClaim method
            * override this method for handling normal response from addLocalClaim operation
            */
           public void receiveResultaddLocalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addLocalClaim operation
           */
            public void receiveErroraddLocalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getLocalClaims method
            * override this method for handling normal response from getLocalClaims operation
            */
           public void receiveResultgetLocalClaims(
                    org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getLocalClaims operation
           */
            public void receiveErrorgetLocalClaims(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeExternalClaim method
            * override this method for handling normal response from removeExternalClaim operation
            */
           public void receiveResultremoveExternalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeExternalClaim operation
           */
            public void receiveErrorremoveExternalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateExternalClaim method
            * override this method for handling normal response from updateExternalClaim operation
            */
           public void receiveResultupdateExternalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateExternalClaim operation
           */
            public void receiveErrorupdateExternalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getClaimDialects method
            * override this method for handling normal response from getClaimDialects operation
            */
           public void receiveResultgetClaimDialects(
                    org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getClaimDialects operation
           */
            public void receiveErrorgetClaimDialects(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getExternalClaims method
            * override this method for handling normal response from getExternalClaims operation
            */
           public void receiveResultgetExternalClaims(
                    org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getExternalClaims operation
           */
            public void receiveErrorgetExternalClaims(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateLocalClaim method
            * override this method for handling normal response from updateLocalClaim operation
            */
           public void receiveResultupdateLocalClaim(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateLocalClaim operation
           */
            public void receiveErrorupdateLocalClaim(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addClaimDialect method
            * override this method for handling normal response from addClaimDialect operation
            */
           public void receiveResultaddClaimDialect(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addClaimDialect operation
           */
            public void receiveErroraddClaimDialect(java.lang.Exception e) {
            }
                


    }
    