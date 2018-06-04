

/**
 * UserAdmin.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.user.mgt.stub;

    /*
     *  UserAdmin java interface
     */

    public interface UserAdmin {
          

        /**
          * Auto generated method signature
          * 
                    * @param changePasswordByUser58
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public void changePasswordByUser(

                        java.lang.String userName59,java.lang.String oldPassword60,java.lang.String newPassword61)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changePasswordByUser58
            
          */
        public void startchangePasswordByUser(

            java.lang.String userName59,java.lang.String oldPassword60,java.lang.String newPassword61,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param isSharedRolesEnabled63
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public boolean isSharedRolesEnabled(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param isSharedRolesEnabled63
            
          */
        public void startisSharedRolesEnabled(

            

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUsersOfRole66
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getUsersOfRole(

                        java.lang.String roleName67,java.lang.String filter68,int limit69)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUsersOfRole66
            
          */
        public void startgetUsersOfRole(

            java.lang.String roleName67,java.lang.String filter68,int limit69,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllPermittedRoleNames72
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getAllPermittedRoleNames(

                        java.lang.String filter73,java.lang.String permission74,int limit75)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllPermittedRoleNames72
            
          */
        public void startgetAllPermittedRoleNames(

            java.lang.String filter73,java.lang.String permission74,int limit75,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  addRemoveUsersOfRole(
         java.lang.String roleName79,java.lang.String[] newUsers80,java.lang.String[] deletedUsers81

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        

        /**
          * Auto generated method signature
          * 
                    * @param addUser82
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public void addUser(

                        java.lang.String userName83,java.lang.String password84,java.lang.String[] roles85,org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue[] claims86,java.lang.String profileName87)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addUser82
            
          */
        public void startaddUser(

            java.lang.String userName83,java.lang.String password84,java.lang.String[] roles85,org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue[] claims86,java.lang.String profileName87,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listAllUsers89
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] listAllUsers(

                        java.lang.String filter90,int limit91)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listAllUsers89
            
          */
        public void startlistAllUsers(

            java.lang.String filter90,int limit91,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listUserByClaim94
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] listUserByClaim(

                        org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue claimValue95,java.lang.String filter96,int maxLimit97)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listUserByClaim94
            
          */
        public void startlistUserByClaim(

            org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue claimValue95,java.lang.String filter96,int maxLimit97,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRolesOfUser100
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getRolesOfUser(

                        java.lang.String userName101,java.lang.String filter102,int limit103)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRolesOfUser100
            
          */
        public void startgetRolesOfUser(

            java.lang.String userName101,java.lang.String filter102,int limit103,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param updateUsersOfRole106
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public void updateUsersOfRole(

                        java.lang.String roleName107,org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] userList108)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param updateUsersOfRole106
            
          */
        public void startupdateUsersOfRole(

            java.lang.String roleName107,org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] userList108,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listUserByClaimWithPermission110
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserStoreException : 
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] listUserByClaimWithPermission(

                        org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue claimValue111,java.lang.String filter112,java.lang.String permission113,int maxLimit114)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserStoreException
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listUserByClaimWithPermission110
            
          */
        public void startlistUserByClaimWithPermission(

            org.wso2.carbon.user.mgt.stub.types.carbon.ClaimValue claimValue111,java.lang.String filter112,java.lang.String permission113,int maxLimit114,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRolesOfCurrentUser117
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getRolesOfCurrentUser(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRolesOfCurrentUser117
            
          */
        public void startgetRolesOfCurrentUser(

            

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  deleteRole(
         java.lang.String roleName121

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        

        /**
          * Auto generated method signature
          * 
                    * @param changePassword122
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public void changePassword(

                        java.lang.String userName123,java.lang.String newPassword124)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changePassword122
            
          */
        public void startchangePassword(

            java.lang.String userName123,java.lang.String newPassword124,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  addInternalRole(
         java.lang.String roleName127,java.lang.String[] userList128,java.lang.String[] permissions129

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  addRemoveRolesOfUser(
         java.lang.String userName131,java.lang.String[] newRoles132,java.lang.String[] deletedRoles133

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  updateRolesOfUser(
         java.lang.String userName135,java.lang.String[] newRoleList136

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        

        /**
          * Auto generated method signature
          * 
                    * @param hasMultipleUserStores137
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public boolean hasMultipleUserStores(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param hasMultipleUserStores137
            
          */
        public void starthasMultipleUserStores(

            

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllUIPermissions140
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.UIPermissionNode getAllUIPermissions(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllUIPermissions140
            
          */
        public void startgetAllUIPermissions(

            

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRolePermissions143
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.UIPermissionNode getRolePermissions(

                        java.lang.String roleName144)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRolePermissions143
            
          */
        public void startgetRolePermissions(

            java.lang.String roleName144,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getAllSharedRoleNames147
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getAllSharedRoleNames(

                        java.lang.String filter148,int limit149)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllSharedRoleNames147
            
          */
        public void startgetAllSharedRoleNames(

            java.lang.String filter148,int limit149,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  setRoleUIPermission(
         java.lang.String roleName153,java.lang.String[] rawResources154

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        

        /**
          * Auto generated method signature
          * 
                    * @param getAllRolesNames155
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] getAllRolesNames(

                        java.lang.String filter156,int limit157)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getAllRolesNames155
            
          */
        public void startgetAllRolesNames(

            java.lang.String filter156,int limit157,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteUser160
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public void deleteUser(

                        java.lang.String userName161)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteUser160
            
          */
        public void startdeleteUser(

            java.lang.String userName161,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  updateRoleName(
         java.lang.String roleName164,java.lang.String newRoleName165

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  bulkImportUsers(
         java.lang.String userStoreDomain167,java.lang.String fileName168,javax.activation.DataHandler handler169,java.lang.String defaultPassword170

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
       /**
         * Auto generated method signature for Asynchronous Invocations
         * 
                 * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */
        public void  addRole(
         java.lang.String roleName172,java.lang.String[] userList173,java.lang.String[] permissions174,boolean isSharedRole175

        ) throws java.rmi.RemoteException
        
        
               ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        

        /**
          * Auto generated method signature
          * 
                    * @param listAllUsersWithPermission176
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.FlaggedName[] listAllUsersWithPermission(

                        java.lang.String filter177,java.lang.String permission178,int limit179)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listAllUsersWithPermission176
            
          */
        public void startlistAllUsersWithPermission(

            java.lang.String filter177,java.lang.String permission178,int limit179,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listUsers182
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public java.lang.String[] listUsers(

                        java.lang.String filter183,int limit184)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listUsers182
            
          */
        public void startlistUsers(

            java.lang.String filter183,int limit184,

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getUserRealmInfo187
                
             * @throws org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException : 
         */

         
                     public org.wso2.carbon.user.mgt.stub.types.carbon.UserRealmInfo getUserRealmInfo(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getUserRealmInfo187
            
          */
        public void startgetUserRealmInfo(

            

            final org.wso2.carbon.user.mgt.stub.UserAdminCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    