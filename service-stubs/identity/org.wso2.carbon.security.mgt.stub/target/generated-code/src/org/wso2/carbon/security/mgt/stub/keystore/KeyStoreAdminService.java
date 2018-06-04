

/**
 * KeyStoreAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.security.mgt.stub.keystore;

    /*
     *  KeyStoreAdminService java interface
     */

    public interface KeyStoreAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param importCertToStore6
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void importCertToStore(

                        org.wso2.carbon.security.mgt.stub.keystore.ImportCertToStore importCertToStore6)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param importCertToStore6
            
          */
        public void startimportCertToStore(

            org.wso2.carbon.security.mgt.stub.keystore.ImportCertToStore importCertToStore6,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.keystore.GetKeyStoresResponse getKeyStores(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
          */
        public void startgetKeyStores(

            

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeCertFromStore10
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void removeCertFromStore(

                        org.wso2.carbon.security.mgt.stub.keystore.RemoveCertFromStore removeCertFromStore10)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeCertFromStore10
            
          */
        public void startremoveCertFromStore(

            org.wso2.carbon.security.mgt.stub.keystore.RemoveCertFromStore removeCertFromStore10,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addKeyStore12
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void addKeyStore(

                        org.wso2.carbon.security.mgt.stub.keystore.AddKeyStore addKeyStore12)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addKeyStore12
            
          */
        public void startaddKeyStore(

            org.wso2.carbon.security.mgt.stub.keystore.AddKeyStore addKeyStore12,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getStoreEntries14
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.keystore.GetStoreEntriesResponse getStoreEntries(

                        org.wso2.carbon.security.mgt.stub.keystore.GetStoreEntries getStoreEntries14)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getStoreEntries14
            
          */
        public void startgetStoreEntries(

            org.wso2.carbon.security.mgt.stub.keystore.GetStoreEntries getStoreEntries14,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getKeystoreInfo16
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.keystore.GetKeystoreInfoResponse getKeystoreInfo(

                        org.wso2.carbon.security.mgt.stub.keystore.GetKeystoreInfo getKeystoreInfo16)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getKeystoreInfo16
            
          */
        public void startgetKeystoreInfo(

            org.wso2.carbon.security.mgt.stub.keystore.GetKeystoreInfo getKeystoreInfo16,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteStore18
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void deleteStore(

                        org.wso2.carbon.security.mgt.stub.keystore.DeleteStore deleteStore18)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteStore18
            
          */
        public void startdeleteStore(

            org.wso2.carbon.security.mgt.stub.keystore.DeleteStore deleteStore18,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getPaginatedKeystoreInfo20
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public org.wso2.carbon.security.mgt.stub.keystore.GetPaginatedKeystoreInfoResponse getPaginatedKeystoreInfo(

                        org.wso2.carbon.security.mgt.stub.keystore.GetPaginatedKeystoreInfo getPaginatedKeystoreInfo20)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getPaginatedKeystoreInfo20
            
          */
        public void startgetPaginatedKeystoreInfo(

            org.wso2.carbon.security.mgt.stub.keystore.GetPaginatedKeystoreInfo getPaginatedKeystoreInfo20,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addTrustStore22
                
             * @throws org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException : 
         */

         
                     public void addTrustStore(

                        org.wso2.carbon.security.mgt.stub.keystore.AddTrustStore addTrustStore22)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceSecurityConfigExceptionException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addTrustStore22
            
          */
        public void startaddTrustStore(

            org.wso2.carbon.security.mgt.stub.keystore.AddTrustStore addTrustStore22,

            final org.wso2.carbon.security.mgt.stub.keystore.KeyStoreAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    