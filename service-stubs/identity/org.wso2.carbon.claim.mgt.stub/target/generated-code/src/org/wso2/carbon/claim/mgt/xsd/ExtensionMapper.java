
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:46 UTC)
 */

        
            package org.wso2.carbon.claim.mgt.xsd;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://dto.mgt.claim.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimAttributeDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.claim.mgt.stub.dto.ClaimAttributeDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://mgt.claim.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimManagementException".equals(typeName)){
                   
                            return  org.wso2.carbon.claim.mgt.xsd.ClaimManagementException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.claim.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimDialectDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.claim.mgt.stub.dto.ClaimDialectDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.claim.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.claim.mgt.stub.dto.ClaimDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.claim.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimMappingDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.claim.mgt.stub.dto.ClaimMappingDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://base.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "IdentityException".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.base.xsd.IdentityException.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    