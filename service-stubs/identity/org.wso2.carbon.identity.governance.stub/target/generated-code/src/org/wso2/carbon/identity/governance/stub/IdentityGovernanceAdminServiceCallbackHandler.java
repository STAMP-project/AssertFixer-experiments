
/**
 * IdentityGovernanceAdminServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.governance.stub;

    /**
     *  IdentityGovernanceAdminServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class IdentityGovernanceAdminServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public IdentityGovernanceAdminServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public IdentityGovernanceAdminServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for updateConfigurations method
            * override this method for handling normal response from updateConfigurations operation
            */
           public void receiveResultupdateConfigurations(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateConfigurations operation
           */
            public void receiveErrorupdateConfigurations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getConnectorList method
            * override this method for handling normal response from getConnectorList operation
            */
           public void receiveResultgetConnectorList(
                    org.wso2.carbon.identity.governance.stub.bean.ConnectorConfig[] result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getConnectorList operation
           */
            public void receiveErrorgetConnectorList(java.lang.Exception e) {
            }
                


    }
    