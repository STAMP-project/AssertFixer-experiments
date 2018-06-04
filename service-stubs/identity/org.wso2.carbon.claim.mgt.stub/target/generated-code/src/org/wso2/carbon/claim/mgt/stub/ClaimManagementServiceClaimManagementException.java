
/**
 * ClaimManagementServiceClaimManagementException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

package org.wso2.carbon.claim.mgt.stub;

public class ClaimManagementServiceClaimManagementException extends java.lang.Exception{

    private static final long serialVersionUID = 1528114648795L;
    
    private org.wso2.carbon.claim.mgt.stub.types.axis2.ClaimManagementServiceClaimManagementException faultMessage;

    
        public ClaimManagementServiceClaimManagementException() {
            super("ClaimManagementServiceClaimManagementException");
        }

        public ClaimManagementServiceClaimManagementException(java.lang.String s) {
           super(s);
        }

        public ClaimManagementServiceClaimManagementException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ClaimManagementServiceClaimManagementException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.claim.mgt.stub.types.axis2.ClaimManagementServiceClaimManagementException msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.claim.mgt.stub.types.axis2.ClaimManagementServiceClaimManagementException getFaultMessage(){
       return faultMessage;
    }
}
    