
/**
 * IdentityGovernanceAdminServiceIdentityGovernanceExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

package org.wso2.carbon.identity.governance.stub;

public class IdentityGovernanceAdminServiceIdentityGovernanceExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1528114731087L;
    
    private org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceException faultMessage;

    
        public IdentityGovernanceAdminServiceIdentityGovernanceExceptionException() {
            super("IdentityGovernanceAdminServiceIdentityGovernanceExceptionException");
        }

        public IdentityGovernanceAdminServiceIdentityGovernanceExceptionException(java.lang.String s) {
           super(s);
        }

        public IdentityGovernanceAdminServiceIdentityGovernanceExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public IdentityGovernanceAdminServiceIdentityGovernanceExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceException msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.identity.governance.stub.IdentityGovernanceAdminServiceIdentityGovernanceException getFaultMessage(){
       return faultMessage;
    }
}
    