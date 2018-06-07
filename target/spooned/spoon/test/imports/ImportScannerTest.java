package spoon.test.imports;


import java.security.AccessControlException;
import java.util.List;
import spoon.Launcher;
import spoon.SpoonModelBuilder;
import spoon.compiler.SpoonResourceHelper;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.visitor.DefaultJavaPrettyPrinter;
import spoon.reflect.visitor.ImportScanner;
import spoon.reflect.visitor.ImportScannerImpl;
import spoon.reflect.visitor.MinimalImportScanner;
import spoon.reflect.visitor.Query;
import spoon.reflect.visitor.filter.NamedElementFilter;


public class ImportScannerTest {
    @org.junit.Test
    public void testImportOnSpoon() throws java.io.IOException {
        java.io.File targetDir = new java.io.File("./target/import-test");
        Launcher spoon = new Launcher();
        spoon.addInputResource("./src/main/java/spoon/");
        spoon.getEnvironment().setAutoImports(true);
        spoon.getEnvironment().setCommentEnabled(true);
        spoon.buildModel();
        spoon.reflect.visitor.PrettyPrinter prettyPrinter = new DefaultJavaPrettyPrinter(spoon.getEnvironment());
        java.util.Map<CtType, List<String>> missingImports = new java.util.HashMap<>();
        java.util.Map<CtType, List<String>> unusedImports = new java.util.HashMap<>();
        spoon.support.JavaOutputProcessor outputProcessor;
        for (CtType<?> ctType : spoon.getModel().getAllTypes()) {
            if (!(ctType.isTopLevel())) {
                continue;
            }
            outputProcessor = new spoon.support.JavaOutputProcessor(targetDir, prettyPrinter);
            outputProcessor.setFactory(spoon.getFactory());
            outputProcessor.init();
            java.util.Set<String> computedTypeImports = new java.util.HashSet<>();
            java.util.Set<String> computedStaticImports = new java.util.HashSet<>();
            outputProcessor.createJavaFile(ctType);
            org.junit.Assert.assertEquals(1, outputProcessor.getCreatedFiles().size());
            List<String> content = java.nio.file.Files.readAllLines(outputProcessor.getCreatedFiles().get(0).toPath());
            for (String computedImport : content) {
                if (computedImport.startsWith("import")) {
                    String computedImportStr = computedImport.replace("import ", "").replace(";", "").trim();
                    if (computedImportStr.contains("static ")) {
                        computedStaticImports.add(computedImportStr.replace("static ", "").trim());
                    }else
                        if (!("".equals(computedImportStr))) {
                            computedTypeImports.add(computedImportStr);
                        }

                }
            }
            List<String> typeImports = getTypeImportsFromSourceCode(ctType.getPosition().getCompilationUnit().getOriginalSourceCode());
            List<String> staticImports = getStaticImportsFromSourceCode(ctType.getPosition().getCompilationUnit().getOriginalSourceCode());
            for (String computedImport : computedTypeImports) {
                if ((!(typeImports.contains(computedImport))) && (!(isTypePresentInStaticImports(computedImport, staticImports)))) {
                    if (!(unusedImports.containsKey(ctType))) {
                        unusedImports.put(ctType, new java.util.ArrayList<>());
                    }
                    unusedImports.get(ctType).add(computedImport);
                }
            }
            for (String computedImport : computedStaticImports) {
                String typeOfStatic = computedImport.substring(0, computedImport.lastIndexOf("."));
                if ((!(staticImports.contains(computedImport))) && (!(typeImports.contains(typeOfStatic)))) {
                    if (!(unusedImports.containsKey(ctType))) {
                        unusedImports.put(ctType, new java.util.ArrayList<>());
                    }
                    unusedImports.get(ctType).add(computedImport);
                }
            }
            for (String anImport : typeImports) {
                if (!(computedTypeImports.contains(anImport))) {
                    if (!(missingImports.containsKey(ctType))) {
                        missingImports.put(ctType, new java.util.ArrayList<>());
                    }
                    missingImports.get(ctType).add(anImport);
                }
            }
            for (String anImport : staticImports) {
                String typeOfStatic = anImport.substring(0, anImport.lastIndexOf("."));
                if ((!(computedStaticImports.contains(anImport))) && (!(computedTypeImports.contains(typeOfStatic)))) {
                    if (!(missingImports.containsKey(ctType))) {
                        missingImports.put(ctType, new java.util.ArrayList<>());
                    }
                    missingImports.get(ctType).add(anImport);
                }
            }
        }
        if ((!(missingImports.isEmpty())) || (!(unusedImports.isEmpty()))) {
            int countUnusedImports = 0;
            for (List<String> imports : unusedImports.values()) {
                countUnusedImports += imports.size();
            }
            int countMissingImports = 0;
            for (List<String> imports : missingImports.values()) {
                countMissingImports += imports.size();
            }
            Launcher.LOGGER.warn((((("ImportScannerTest: Import scanner imports " + countUnusedImports) + " unused imports and misses ") + countMissingImports) + " imports"));
            java.util.Set<CtType> keys = new java.util.HashSet<>(unusedImports.keySet());
            keys.addAll(missingImports.keySet());
        }
    }

    private boolean isTypePresentInStaticImports(String type, java.util.Collection<String> staticImports) {
        for (String s : staticImports) {
            if (s.startsWith(type)) {
                return true;
            }
        }
        return false;
    }

    private List<String> getStaticImportsFromSourceCode(String sourceCode) {
        List<String> imports = new java.util.ArrayList<>();
        String[] lines = sourceCode.split("\n");
        for (int i = 0; i < (lines.length); i++) {
            String line = lines[i].trim();
            if (line.startsWith("import static ")) {
                line = line.substring(13, ((line.length()) - 1));
                imports.add(line.trim());
            }
        }
        return imports;
    }

    private List<String> getTypeImportsFromSourceCode(String sourceCode) {
        List<String> imports = new java.util.ArrayList<>();
        String[] lines = sourceCode.split("\n");
        for (int i = 0; i < (lines.length); i++) {
            String line = lines[i].trim();
            if ((line.startsWith("import ")) && (!(line.contains(" static ")))) {
                line = line.substring(7, ((line.length()) - 1));
                imports.add(line.trim());
            }
        }
        return imports;
    }

    @org.junit.Test
    public void testComputeMinimalImportsInClass() throws java.lang.Exception {
        String packageName = "spoon.test.testclasses";
        String className = "SampleImportClass";
        String qualifiedName = (packageName + ".") + className;
        Factory aFactory = spoon.testing.utils.ModelUtils.build(packageName, className).getFactory();
        CtType<?> theClass = aFactory.Type().get(qualifiedName);
        ImportScanner importContext = new MinimalImportScanner();
        importContext.computeImports(theClass);
        java.util.Collection<spoon.reflect.declaration.CtImport> imports = importContext.getAllImports();
        org.junit.Assert.assertTrue(imports.isEmpty());
    }

    @org.junit.Test
    public void testComputeImportsInClass() throws java.lang.Exception {
        String packageName = "spoon.test.testclasses";
        String className = "SampleImportClass";
        String qualifiedName = (packageName + ".") + className;
        Factory aFactory = spoon.testing.utils.ModelUtils.build(packageName, className).getFactory();
        CtType<?> theClass = aFactory.Type().get(qualifiedName);
        ImportScanner importContext = new ImportScannerImpl();
        importContext.computeImports(theClass);
        java.util.Collection<spoon.reflect.declaration.CtImport> imports = importContext.getAllImports();
        org.junit.Assert.assertEquals(4, imports.size());
    }

    @org.junit.Test
    public void testComputeImportsInClassWithSameName() throws java.lang.Exception {
        String packageName = "spoon.test.imports.testclasses2";
        String className = "ImportSameName";
        String qualifiedName = (packageName + ".") + className;
        Launcher spoon = new Launcher();
        spoon.addInputResource("src/test/resources/spoon/test/imports/testclasses2/");
        spoon.buildModel();
        Factory aFactory = spoon.getFactory();
        CtType<?> theClass = aFactory.Type().get(qualifiedName);
        ImportScanner importContext = new ImportScannerImpl();
        importContext.computeImports(theClass);
        java.util.Collection<spoon.reflect.declaration.CtImport> imports = importContext.getAllImports();
        org.junit.Assert.assertEquals(0, imports.size());
    }

    @org.junit.Test
    public void testMultiCatchImport() throws java.lang.Exception {
        Launcher spoon = new Launcher();
        Factory factory = spoon.createFactory();
        SpoonModelBuilder compiler = spoon.createCompiler(factory, SpoonResourceHelper.resources("./src/test/java/spoon/test/imports/testclasses/MultiCatch.java"));
        compiler.build();
        final List<CtClass> classes = Query.getElements(factory, new NamedElementFilter<>(CtClass.class, "MultiCatch"));
        ImportScanner importScanner = new ImportScannerImpl();
        importScanner.computeImports(classes.get(0));
        org.junit.Assert.assertTrue(importScanner.isImported(factory.Type().createReference(AccessControlException.class)));
    }

    @org.junit.Test
    public void testTargetTypeNull() throws java.lang.Exception {
        Launcher spoon = new Launcher();
        Factory factory = spoon.createFactory();
        CtFieldReference fieldRef = factory.createFieldReference();
        fieldRef.setStatic(true);
        ImportScanner importScanner = new MinimalImportScanner();
        importScanner.computeImports(fieldRef);
        java.util.Collection<spoon.reflect.declaration.CtImport> imports = importScanner.getAllImports();
        org.junit.Assert.assertEquals(0, imports.size());
    }
}

