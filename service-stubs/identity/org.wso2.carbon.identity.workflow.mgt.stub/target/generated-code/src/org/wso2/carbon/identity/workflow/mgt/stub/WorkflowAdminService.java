

/**
 * WorkflowAdminService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:27 UTC)
 */

    package org.wso2.carbon.identity.workflow.mgt.stub;

    /*
     *  WorkflowAdminService java interface
     */

    public interface WorkflowAdminService {
          

        /**
          * Auto generated method signature
          * 
                    * @param addWorkflow29
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void addWorkflow(

                        org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowWizard workflow30)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addWorkflow29
            
          */
        public void startaddWorkflow(

            org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowWizard workflow30,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeAssociation32
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void removeAssociation(

                        java.lang.String associationId33)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeAssociation32
            
          */
        public void startremoveAssociation(

            java.lang.String associationId33,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param addAssociation35
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void addAssociation(

                        java.lang.String associationName36,java.lang.String workflowId37,java.lang.String eventId38,java.lang.String condition39)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param addAssociation35
            
          */
        public void startaddAssociation(

            java.lang.String associationName36,java.lang.String workflowId37,java.lang.String eventId38,java.lang.String condition39,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getWorkflowsOfRequest41
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.bean.WorkflowRequestAssociation[] getWorkflowsOfRequest(

                        java.lang.String requestId42)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getWorkflowsOfRequest41
            
          */
        public void startgetWorkflowsOfRequest(

            java.lang.String requestId42,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listWorkflows45
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowWizard[] listWorkflows(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listWorkflows45
            
          */
        public void startlistWorkflows(

            

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listTemplates48
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.Template[] listTemplates(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listTemplates48
            
          */
        public void startlistTemplates(

            

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getWorkflow51
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowWizard getWorkflow(

                        java.lang.String workflowId52)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getWorkflow51
            
          */
        public void startgetWorkflow(

            java.lang.String workflowId52,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getEvent55
                
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowEvent getEvent(

                        java.lang.String eventId56)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getEvent55
            
          */
        public void startgetEvent(

            java.lang.String eventId56,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param changeAssociationState59
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void changeAssociationState(

                        java.lang.String associationId60,boolean isEnable61)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param changeAssociationState59
            
          */
        public void startchangeAssociationState(

            java.lang.String associationId60,boolean isEnable61,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getTemplate63
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.Template getTemplate(

                        java.lang.String templateId64)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getTemplate63
            
          */
        public void startgetTemplate(

            java.lang.String templateId64,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getWorkflowImpl67
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowImpl getWorkflowImpl(

                        java.lang.String templateId68,java.lang.String implementationId69)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getWorkflowImpl67
            
          */
        public void startgetWorkflowImpl(

            java.lang.String templateId68,java.lang.String implementationId69,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRequestsCreatedByUser72
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.bean.WorkflowRequest[] getRequestsCreatedByUser(

                        java.lang.String user73,java.lang.String beginDate74,java.lang.String endDate75,java.lang.String dateCategory76,java.lang.String status77)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRequestsCreatedByUser72
            
          */
        public void startgetRequestsCreatedByUser(

            java.lang.String user73,java.lang.String beginDate74,java.lang.String endDate75,java.lang.String dateCategory76,java.lang.String status77,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param getRequestsInFilter80
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.bean.WorkflowRequest[] getRequestsInFilter(

                        java.lang.String beginDate81,java.lang.String endDate82,java.lang.String dateCategory83,java.lang.String status84)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param getRequestsInFilter80
            
          */
        public void startgetRequestsInFilter(

            java.lang.String beginDate81,java.lang.String endDate82,java.lang.String dateCategory83,java.lang.String status84,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param deleteWorkflowRequest87
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void deleteWorkflowRequest(

                        java.lang.String requestId88)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param deleteWorkflowRequest87
            
          */
        public void startdeleteWorkflowRequest(

            java.lang.String requestId88,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listAllAssociations90
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.Association[] listAllAssociations(

                        )
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listAllAssociations90
            
          */
        public void startlistAllAssociations(

            

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listWorkflowImpls93
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowImpl[] listWorkflowImpls(

                        java.lang.String templateId94)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listWorkflowImpls93
            
          */
        public void startlistWorkflowImpls(

            java.lang.String templateId94,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param removeWorkflow97
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public void removeWorkflow(

                        java.lang.String id98)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param removeWorkflow97
            
          */
        public void startremoveWorkflow(

            java.lang.String id98,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listAssociations100
                
             * @throws org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException : 
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.Association[] listAssociations(

                        java.lang.String workflowId101)
                        throws java.rmi.RemoteException
             
          ,org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceWorkflowException;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listAssociations100
            
          */
        public void startlistAssociations(

            java.lang.String workflowId101,

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        /**
          * Auto generated method signature
          * 
                    * @param listWorkflowEvents104
                
         */

         
                     public org.wso2.carbon.identity.workflow.mgt.stub.metadata.WorkflowEvent[] listWorkflowEvents(

                        )
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param listWorkflowEvents104
            
          */
        public void startlistWorkflowEvents(

            

            final org.wso2.carbon.identity.workflow.mgt.stub.WorkflowAdminServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    