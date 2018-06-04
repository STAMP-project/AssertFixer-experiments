
/**
 * ClaimManagementServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.claim.mgt.stub;

    /**
     *  ClaimManagementServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ClaimManagementServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ClaimManagementServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ClaimManagementServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
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
            * auto generated Axis2 call back method for removeClaimMapping method
            * override this method for handling normal response from removeClaimMapping operation
            */
           public void receiveResultremoveClaimMapping(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeClaimMapping operation
           */
            public void receiveErrorremoveClaimMapping(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getClaimMappingByDialect method
            * override this method for handling normal response from getClaimMappingByDialect operation
            */
           public void receiveResultgetClaimMappingByDialect(
                    org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getClaimMappingByDialect operation
           */
            public void receiveErrorgetClaimMappingByDialect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewClaimDialect method
            * override this method for handling normal response from addNewClaimDialect operation
            */
           public void receiveResultaddNewClaimDialect(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewClaimDialect operation
           */
            public void receiveErroraddNewClaimDialect(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getClaimMappings method
            * override this method for handling normal response from getClaimMappings operation
            */
           public void receiveResultgetClaimMappings(
                    org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getClaimMappings operation
           */
            public void receiveErrorgetClaimMappings(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addNewClaimMapping method
            * override this method for handling normal response from addNewClaimMapping operation
            */
           public void receiveResultaddNewClaimMapping(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addNewClaimMapping operation
           */
            public void receiveErroraddNewClaimMapping(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for upateClaimMapping method
            * override this method for handling normal response from upateClaimMapping operation
            */
           public void receiveResultupateClaimMapping(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from upateClaimMapping operation
           */
            public void receiveErrorupateClaimMapping(java.lang.Exception e) {
            }
                


    }
    