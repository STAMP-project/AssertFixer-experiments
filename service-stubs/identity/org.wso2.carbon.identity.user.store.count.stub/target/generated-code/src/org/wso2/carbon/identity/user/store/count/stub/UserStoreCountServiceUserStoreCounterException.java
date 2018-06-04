
/**
 * UserStoreCountServiceUserStoreCounterException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

package org.wso2.carbon.identity.user.store.count.stub;

public class UserStoreCountServiceUserStoreCounterException extends java.lang.Exception{

    private static final long serialVersionUID = 1528114727936L;
    
    private org.wso2.carbon.identity.user.store.count.stub.exception.UserStoreCountServiceUserStoreCounterException faultMessage;

    
        public UserStoreCountServiceUserStoreCounterException() {
            super("UserStoreCountServiceUserStoreCounterException");
        }

        public UserStoreCountServiceUserStoreCounterException(java.lang.String s) {
           super(s);
        }

        public UserStoreCountServiceUserStoreCounterException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public UserStoreCountServiceUserStoreCounterException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(org.wso2.carbon.identity.user.store.count.stub.exception.UserStoreCountServiceUserStoreCounterException msg){
       faultMessage = msg;
    }
    
    public org.wso2.carbon.identity.user.store.count.stub.exception.UserStoreCountServiceUserStoreCounterException getFaultMessage(){
       return faultMessage;
    }
}
    