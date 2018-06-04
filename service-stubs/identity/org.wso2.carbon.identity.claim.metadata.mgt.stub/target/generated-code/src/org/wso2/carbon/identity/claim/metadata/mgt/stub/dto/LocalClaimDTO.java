
/**
 * LocalClaimDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.1-wso2v12  Built on : Mar 19, 2015 (08:32:46 UTC)
 */

            
                package org.wso2.carbon.identity.claim.metadata.mgt.stub.dto;
            

            /**
            *  LocalClaimDTO bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class LocalClaimDTO
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = LocalClaimDTO
                Namespace URI = http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for AttributeMappings
                        * This was an Array!
                        */

                        
                                    protected org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[] localAttributeMappings ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAttributeMappingsTracker = false ;

                           public boolean isAttributeMappingsSpecified(){
                               return localAttributeMappingsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[]
                           */
                           public  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[] getAttributeMappings(){
                               return localAttributeMappings;
                           }

                           
                        


                               
                              /**
                               * validate the array for AttributeMappings
                               */
                              protected void validateAttributeMappings(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param AttributeMappings
                              */
                              public void setAttributeMappings(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[] param){
                              
                                   validateAttributeMappings(param);

                               localAttributeMappingsTracker = true;
                                      
                                      this.localAttributeMappings=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO
                             */
                             public void addAttributeMappings(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO param){
                                   if (localAttributeMappings == null){
                                   localAttributeMappings = new org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[]{};
                                   }

                            
                                 //update the setting tracker
                                localAttributeMappingsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localAttributeMappings);
                               list.add(param);
                               this.localAttributeMappings =
                             (org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[])list.toArray(
                            new org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[list.size()]);

                             }
                             

                        /**
                        * field for ClaimProperties
                        * This was an Array!
                        */

                        
                                    protected org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[] localClaimProperties ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localClaimPropertiesTracker = false ;

                           public boolean isClaimPropertiesSpecified(){
                               return localClaimPropertiesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[]
                           */
                           public  org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[] getClaimProperties(){
                               return localClaimProperties;
                           }

                           
                        


                               
                              /**
                               * validate the array for ClaimProperties
                               */
                              protected void validateClaimProperties(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param ClaimProperties
                              */
                              public void setClaimProperties(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[] param){
                              
                                   validateClaimProperties(param);

                               localClaimPropertiesTracker = true;
                                      
                                      this.localClaimProperties=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO
                             */
                             public void addClaimProperties(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO param){
                                   if (localClaimProperties == null){
                                   localClaimProperties = new org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[]{};
                                   }

                            
                                 //update the setting tracker
                                localClaimPropertiesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localClaimProperties);
                               list.add(param);
                               this.localClaimProperties =
                             (org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[])list.toArray(
                            new org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[list.size()]);

                             }
                             

                        /**
                        * field for LocalClaimURI
                        */

                        
                                    protected java.lang.String localLocalClaimURI ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLocalClaimURITracker = false ;

                           public boolean isLocalClaimURISpecified(){
                               return localLocalClaimURITracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getLocalClaimURI(){
                               return localLocalClaimURI;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LocalClaimURI
                               */
                               public void setLocalClaimURI(java.lang.String param){
                            localLocalClaimURITracker = true;
                                   
                                            this.localLocalClaimURI=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":LocalClaimDTO",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "LocalClaimDTO",
                           xmlWriter);
                   }

               
                   }
                if (localAttributeMappingsTracker){
                                       if (localAttributeMappings!=null){
                                            for (int i = 0;i < localAttributeMappings.length;i++){
                                                if (localAttributeMappings[i] != null){
                                                 localAttributeMappings[i].serialize(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","attributeMappings"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd", "attributeMappings", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd", "attributeMappings", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localClaimPropertiesTracker){
                                       if (localClaimProperties!=null){
                                            for (int i = 0;i < localClaimProperties.length;i++){
                                                if (localClaimProperties[i] != null){
                                                 localClaimProperties[i].serialize(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","claimProperties"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                            writeStartElement(null, "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd", "claimProperties", xmlWriter);

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                writeStartElement(null, "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd", "claimProperties", xmlWriter);

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localLocalClaimURITracker){
                                    namespace = "http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd";
                                    writeStartElement(null, namespace, "localClaimURI", xmlWriter);
                             

                                          if (localLocalClaimURI==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localLocalClaimURI);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAttributeMappingsTracker){
                             if (localAttributeMappings!=null) {
                                 for (int i = 0;i < localAttributeMappings.length;i++){

                                    if (localAttributeMappings[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "attributeMappings"));
                                         elementList.add(localAttributeMappings[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "attributeMappings"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "attributeMappings"));
                                        elementList.add(localAttributeMappings);
                                    
                             }

                        } if (localClaimPropertiesTracker){
                             if (localClaimProperties!=null) {
                                 for (int i = 0;i < localClaimProperties.length;i++){

                                    if (localClaimProperties[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "claimProperties"));
                                         elementList.add(localClaimProperties[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "claimProperties"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                          "claimProperties"));
                                        elementList.add(localClaimProperties);
                                    
                             }

                        } if (localLocalClaimURITracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd",
                                                                      "localClaimURI"));
                                 
                                         elementList.add(localLocalClaimURI==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocalClaimURI));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static LocalClaimDTO parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            LocalClaimDTO object =
                new LocalClaimDTO();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"LocalClaimDTO".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (LocalClaimDTO)org.wso2.carbon.identity.claim.metadata.mgt.stub.types.axis2.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list1 = new java.util.ArrayList();
                    
                        java.util.ArrayList list2 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","attributeMappings").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list1.add(null);
                                                              reader.next();
                                                          } else {
                                                        list1.add(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone1 = false;
                                                        while(!loopDone1){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone1 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","attributeMappings").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list1.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list1.add(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone1 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setAttributeMappings((org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.AttributeMappingDTO.class,
                                                                list1));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","claimProperties").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list2.add(null);
                                                              reader.next();
                                                          } else {
                                                        list2.add(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone2 = false;
                                                        while(!loopDone2){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone2 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","claimProperties").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list2.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list2.add(org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone2 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setClaimProperties((org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                org.wso2.carbon.identity.claim.metadata.mgt.stub.dto.ClaimPropertyDTO.class,
                                                                list2));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dto.mgt.metadata.claim.identity.carbon.wso2.org/xsd","localClaimURI").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocalClaimURI(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    