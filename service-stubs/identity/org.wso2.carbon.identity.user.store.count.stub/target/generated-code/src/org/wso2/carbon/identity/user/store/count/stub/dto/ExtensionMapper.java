
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:46 UTC)
 */

        
            package org.wso2.carbon.identity.user.store.count.stub.dto;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://exception.count.store.user.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "UserStoreCounterException".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.user.store.count.stub.exception.UserStoreCounterException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.count.store.user.identity.carbon.wso2.org/xsd".equals(namespaceURI) &&
                  "PairDTO".equals(typeName)){
                   
                            return  org.wso2.carbon.identity.user.store.count.stub.dto.PairDTO.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    