
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:46 UTC)
 */

        
            package org.wso2.carbon.identity.claim.metadata.mgt.stub.types.axis2;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "LocalClaimDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.LocalClaimDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimDialectDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimDialectDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "AttributeMappingDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimPropertyDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://base.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "IdentityException".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.base.xsd.IdentityException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://exception.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ClaimMetadataException".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.exception.ClaimMetadataException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "ExternalClaimDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ExternalClaimDTO.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    