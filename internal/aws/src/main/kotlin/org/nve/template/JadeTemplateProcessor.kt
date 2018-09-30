package org.nve.template

import org.glassfish.jersey.server.mvc.Viewable
import org.glassfish.jersey.server.mvc.spi.TemplateProcessor
import java.io.OutputStream
import javax.inject.Inject
import javax.print.attribute.standard.Media
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.MultivaluedMap

class JadeTemplateProcessor @Inject constructor(
        private val service: TemplateService
) : TemplateProcessor<JadeTemplateProcessor.Reference> {
    override fun resolve(
            name: String,
            mediaType: MediaType)
            : Reference? =
        if(MediaType.TEXT_HTML_TYPE == mediaType) Reference else null

    override fun writeTo(
            templateReference: Reference,
            viewable: Viewable,
            mediaType: MediaType,
            httpHeaders: MultivaluedMap<String, Any>,
            out: OutputStream) {
        val name = viewable.templateName
        @Suppress("unchecked_cast")
        val model = when(viewable.model) {
            is Map<*, *> -> viewable.model as Map<String, Any>
            else -> mapOf("model" to viewable.model)
        }
        service.write(Template(name, model), out)
    }
    object Reference
}