package org.nve.template

import java.io.OutputStream
import java.lang.reflect.Type
import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap
import javax.ws.rs.ext.MessageBodyWriter

class JadeMessageBodyWriter @Inject constructor(
        private val service: TemplateService
) : MessageBodyWriter<Template> {

    override fun isWriteable(type: Class<*>,
                             genericType: Type,
                             annotations: Array<out Annotation>,
                             mediaType: MediaType): Boolean =
            MediaType.TEXT_HTML_TYPE == mediaType && Template::class == type.kotlin

    override fun writeTo(template: Template,
                         type: Class<*>,
                         genericType: Type,
                         annotations: Array<out Annotation>,
                         mediaType: MediaType,
                         httpHeaders: MultivaluedMap<String, Any>,
                         output: OutputStream) {
        service.write(template, output)
    }

    override fun getSize(template: Template,
                         type: Class<*>,
                         genericType: Type,
                         annotations: Array<out Annotation>,
                         mediaType: MediaType): Long = -1
}