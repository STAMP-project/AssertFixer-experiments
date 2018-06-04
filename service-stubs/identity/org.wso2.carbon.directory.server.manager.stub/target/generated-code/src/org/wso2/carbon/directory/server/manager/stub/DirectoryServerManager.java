

/**
 * DirectoryServerManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.directory.server.manager.stub;

    /*
     *  DirectoryServerManager java interface
     */

    public interface DirectoryServerManager {
          

        /**
          * Auto generated method signature
          * 
                    * @param removeServer8
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public void removeServer(

                        java.lang.String serverName9)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeServer8
            
          */
        public void startremoveServer(

            java.lang.String serverName9,

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addServer11
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public void addServer(

                        java.lang.String serverName12,java.lang.String serverDescription13,java.lang.String serverPassword14)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addServer11
            
          */
        public void startaddServer(

            java.lang.String serverName12,java.lang.String serverDescription13,java.lang.String serverPassword14,

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param changePassword16
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public void changePassword(

                        java.lang.String serverPrinciple17,java.lang.String existingPassword18,java.lang.String newPassword19)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changePassword16
            
          */
        public void startchangePassword(

            java.lang.String serverPrinciple17,java.lang.String existingPassword18,java.lang.String newPassword19,

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getServiceNameConformanceRegularExpression21
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public java.lang.String getServiceNameConformanceRegularExpression(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getServiceNameConformanceRegularExpression21
            
          */
        public void startgetServiceNameConformanceRegularExpression(

            

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isExistingServicePrinciple24
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public boolean isExistingServicePrinciple(

                        java.lang.String servicePrinciple25)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isExistingServicePrinciple24
            
          */
        public void startisExistingServicePrinciple(

            java.lang.String servicePrinciple25,

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isKDCEnabled28
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public boolean isKDCEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isKDCEnabled28
            
          */
        public void startisKDCEnabled(

            

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPasswordConformanceRegularExpression31
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public java.lang.String getPasswordConformanceRegularExpression(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPasswordConformanceRegularExpression31
            
          */
        public void startgetPasswordConformanceRegularExpression(

            

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listServicePrinciples34
                
             * @throws org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException : 
         */

         
                     public org.wso2.carbon.directory.common.stub.types.ServerPrinciple[] listServicePrinciples(

                        java.lang.String filter35)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerDirectoryServerManagerExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listServicePrinciples34
            
          */
        public void startlistServicePrinciples(

            java.lang.String filter35,

            final org.wso2.carbon.directory.server.manager.stub.DirectoryServerManagerCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    