package org.nve.template

import java.io.OutputStream

interface TemplateService {
    fun write(template: Template, output: OutputStream)
}