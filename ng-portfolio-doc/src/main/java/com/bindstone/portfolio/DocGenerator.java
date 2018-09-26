package com.bindstone.portfolio;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DocGenerator {
    public static void main(String[] args) throws IOException {
        //tag::build[]
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();

        Map<String, Object> options = OptionsBuilder.options()
                .inPlace(true)
                .backend("pdf")
                .safe(SafeMode.UNSAFE)
                .baseDir(new File("./ng-portfolio-doc/src/doc/"))
                .toDir(new File("./ng-portfolio-doc/target/"))
                .asMap();

        String outfile = asciidoctor.convertFile(new File("./ng-portfolio-doc/src/doc/main.adoc"), options);

        //end::build[]
    }
}
