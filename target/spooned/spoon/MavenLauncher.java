/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon;


/**
 * Create a Spoon launcher from a maven pom file
 */
public class MavenLauncher extends spoon.Launcher {
    private java.lang.String m2RepositoryPath;

    private spoon.MavenLauncher.SOURCE_TYPE sourceType;

    /**
     * The type of source to consider in the model
     */
    public enum SOURCE_TYPE {
        APP_SOURCE, TEST_SOURCE, ALL_SOURCE;}

    public MavenLauncher(java.lang.String mavenProject, spoon.MavenLauncher.SOURCE_TYPE sourceType) {
        this(mavenProject, java.nio.file.Paths.get(java.lang.System.getProperty("user.home"), ".m2", "repository").toString(), sourceType);
    }

    /**
     *
     *
     * @param mavenProject
     * 		the path to the root of the project
     * @param m2RepositoryPath
     * 		the path to the m2repository
     */
    public MavenLauncher(java.lang.String mavenProject, java.lang.String m2RepositoryPath, spoon.MavenLauncher.SOURCE_TYPE sourceType) {
        super();
        this.m2RepositoryPath = m2RepositoryPath;
        this.sourceType = sourceType;
        java.io.File mavenProjectFile = new java.io.File(mavenProject);
        if (!(mavenProjectFile.exists())) {
            throw new spoon.SpoonException((mavenProject + " does not exist."));
        }
        spoon.MavenLauncher.InheritanceModel model;
        try {
            model = readPOM(mavenProject, null);
        } catch (java.lang.Exception e) {
            throw new spoon.SpoonException("Unable to read the pom", e);
        }
        if (model == null) {
            throw new spoon.SpoonException("Unable to create the model, pom not found?");
        }
        // app source
        if (((spoon.MavenLauncher.SOURCE_TYPE.APP_SOURCE) == sourceType) || ((spoon.MavenLauncher.SOURCE_TYPE.ALL_SOURCE) == sourceType)) {
            java.util.List<java.io.File> sourceDirectories = model.getSourceDirectories();
            for (java.io.File sourceDirectory : sourceDirectories) {
                this.addInputResource(sourceDirectory.getAbsolutePath());
            }
        }
        // test source
        if (((spoon.MavenLauncher.SOURCE_TYPE.TEST_SOURCE) == sourceType) || ((spoon.MavenLauncher.SOURCE_TYPE.ALL_SOURCE) == sourceType)) {
            java.util.List<java.io.File> testSourceDirectories = model.getTestDirectories();
            for (java.io.File sourceDirectory : testSourceDirectories) {
                this.addInputResource(sourceDirectory.getAbsolutePath());
            }
        }
        // dependencies
        spoon.MavenLauncher.TreeDependency depTree = model.getTreeDependency();
        java.util.List<java.io.File> dependencies = depTree.toJarList();
        java.lang.String[] classpath = new java.lang.String[dependencies.size()];
        for (int i = 0; i < (dependencies.size()); i++) {
            java.io.File file = dependencies.get(i);
            classpath[i] = file.getAbsolutePath();
        }
        this.getModelBuilder().setSourceClasspath(classpath);
        // compliance level
        this.getEnvironment().setComplianceLevel(model.getSourceVersion());
    }

    /**
     * Extract the information from the pom
     *
     * @param path
     * 		the path to the pom
     * @param parent
     * 		the parent pom
     * @return the extracted model
     * @throws IOException
     * 		when the file does not exist
     * @throws XmlPullParserException
     * 		when the file is corrupted
     */
    private spoon.MavenLauncher.InheritanceModel readPOM(java.lang.String path, spoon.MavenLauncher.InheritanceModel parent) throws java.io.IOException, org.codehaus.plexus.util.xml.pull.XmlPullParserException {
        if ((!(path.endsWith(".xml"))) && (!(path.endsWith(".pom")))) {
            path = java.nio.file.Paths.get(path, "pom.xml").toString();
        }
        java.io.File pomFile = new java.io.File(path);
        if (!(pomFile.exists())) {
            return null;
        }
        org.apache.maven.model.io.xpp3.MavenXpp3Reader pomReader = new org.apache.maven.model.io.xpp3.MavenXpp3Reader();
        try (java.io.FileReader reader = new java.io.FileReader(pomFile)) {
            org.apache.maven.model.Model model = pomReader.read(reader);
            spoon.MavenLauncher.InheritanceModel inheritanceModel = new spoon.MavenLauncher.InheritanceModel(model, parent, pomFile.getParentFile());
            for (java.lang.String module : model.getModules()) {
                if (path.contains(m2RepositoryPath)) {
                    spoon.MavenLauncher.InheritanceModel modulePom = readPOM(path.replaceAll(model.getArtifactId(), module), inheritanceModel);
                    if (modulePom != null) {
                        inheritanceModel.addModule(modulePom);
                    }
                }else {
                    inheritanceModel.addModule(readPOM(java.nio.file.Paths.get(pomFile.getParent(), module).toString(), inheritanceModel));
                }
            }
            return inheritanceModel;
        }
    }

    class TreeDependency {
        private java.lang.String groupId;

        private java.lang.String artifactId;

        private java.lang.String version;

        private java.lang.String type;

        private java.util.List<spoon.MavenLauncher.TreeDependency> dependencies = new java.util.ArrayList<>();

        TreeDependency(java.lang.String groupId, java.lang.String artifactId, java.lang.String version, java.lang.String type) {
            this.groupId = groupId;
            this.artifactId = artifactId;
            this.version = version;
            this.type = type;
        }

        void addDependence(spoon.MavenLauncher.TreeDependency dependence) {
            if (dependence != null) {
                dependencies.add(dependence);
            }
        }

        java.util.List<spoon.MavenLauncher.TreeDependency> getDependencyList() {
            java.util.List<spoon.MavenLauncher.TreeDependency> output = new java.util.ArrayList<>(dependencies);
            for (spoon.MavenLauncher.TreeDependency treeDependency : dependencies) {
                output.addAll(treeDependency.getDependencyList());
            }
            return output;
        }

        java.util.List<java.io.File> toJarList() {
            java.util.List<spoon.MavenLauncher.TreeDependency> dependencyList = getDependencyList();
            java.util.List<java.io.File> output = new java.util.ArrayList<>();
            java.util.Set<spoon.MavenLauncher.TreeDependency> addedDep = new java.util.HashSet<>();
            for (spoon.MavenLauncher.TreeDependency dep : dependencyList) {
                java.io.File file = dep.getTopLevelJar();
                if ((null != file) && (!(addedDep.contains(dep)))) {
                    addedDep.add(dep);
                    output.add(file);
                }
            }
            return output;
        }

        private java.io.File getTopLevelJar() {
            if ("pom".equals(type)) {
                return null;
            }
            if (((groupId) != null) && ((version) != null)) {
                java.lang.String fileName = ((artifactId) + "-") + (version);
                java.nio.file.Path depPath = java.nio.file.Paths.get(m2RepositoryPath, groupId.replaceAll("\\.", "/"), artifactId, version);
                java.io.File depFile = depPath.toFile();
                if (depFile.exists()) {
                    java.io.File jarFile = java.nio.file.Paths.get(depPath.toString(), (fileName + ".jar")).toFile();
                    if (jarFile.exists()) {
                        return jarFile;
                    }else {
                        spoon.Launcher.LOGGER.log(org.apache.log4j.Level.ERROR, ("Jar not found at " + jarFile));
                    }
                }else {
                    spoon.Launcher.LOGGER.log(org.apache.log4j.Level.ERROR, ("Dependency not found at " + depPath));
                }
            }
            return null;
        }

        void removeDependency(java.lang.String groupId, java.lang.String artifactId) {
            for (spoon.MavenLauncher.TreeDependency dep : new java.util.ArrayList<>(dependencies)) {
                if (((((dep.groupId) != null) && (dep.groupId.equals(groupId))) && ((dep.artifactId) != null)) && (dep.artifactId.equals(artifactId))) {
                    this.dependencies.remove(dep);
                }else {
                    dep.removeDependency(groupId, artifactId);
                }
            }
        }

        @java.lang.Override
        public boolean equals(java.lang.Object o) {
            if ((this) == o) {
                return true;
            }
            if ((o == null) || ((getClass()) != (o.getClass()))) {
                return false;
            }
            spoon.MavenLauncher.TreeDependency that = ((spoon.MavenLauncher.TreeDependency) (o));
            return (java.util.Objects.equals(groupId, that.groupId)) && (java.util.Objects.equals(artifactId, that.artifactId));
        }

        @java.lang.Override
        public int hashCode() {
            return java.util.Objects.hash(groupId, artifactId);
        }

        @java.lang.Override
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(groupId);
            sb.append(":");
            sb.append(artifactId);
            sb.append(":");
            sb.append(version);
            if (!(dependencies.isEmpty())) {
                sb.append(" {\n");
                for (spoon.MavenLauncher.TreeDependency dep : dependencies) {
                    java.lang.String child = dep.toString();
                    for (java.lang.String s : child.split("\n")) {
                        sb.append("\t");
                        sb.append(s);
                        sb.append("\n");
                    }
                }
                sb.append("}");
            }
            return sb.toString();
        }
    }

    class InheritanceModel {
        private java.util.List<spoon.MavenLauncher.InheritanceModel> modules = new java.util.ArrayList<>();

        private org.apache.maven.model.Model model;

        private spoon.MavenLauncher.InheritanceModel parent;

        private java.io.File directory;

        private java.util.Map<java.lang.String, java.lang.String> dependencyManagements = new java.util.HashMap<>();

        InheritanceModel(org.apache.maven.model.Model model, spoon.MavenLauncher.InheritanceModel parent, java.io.File directory) {
            this.model = model;
            this.parent = parent;
            this.directory = directory;
            // if possible, build the parent model from the relative path
            if ((parent == null) && ((model.getParent()) != null)) {
                try {
                    java.io.File parentPath = new java.io.File(directory, model.getParent().getRelativePath());
                    this.parent = readPOM(parentPath.getPath(), null);
                    if ((this.parent) == null) {
                        java.lang.String groupId = model.getParent().getGroupId();
                        java.lang.String version = model.getParent().getVersion();
                        this.parent = readPom(groupId, model.getParent().getArtifactId(), version);
                        if (((this.model.getGroupId()) == null) && ((this.parent) != null)) {
                            this.model.setGroupId(this.parent.model.getGroupId());
                        }
                        if (((this.model.getVersion()) == null) && ((this.parent) != null)) {
                            this.model.setVersion(this.parent.model.getVersion());
                        }
                    }
                } catch (java.lang.Exception e) {
                    spoon.Launcher.LOGGER.debug(("Parent model cannot be resolved: " + (e.getMessage())));
                }
            }
            org.apache.maven.model.DependencyManagement dependencyManagement = model.getDependencyManagement();
            if (dependencyManagement != null) {
                java.util.List<org.apache.maven.model.Dependency> dependencies = dependencyManagement.getDependencies();
                for (org.apache.maven.model.Dependency dependency : dependencies) {
                    if ("import".equals(dependency.getScope())) {
                        spoon.MavenLauncher.InheritanceModel pom = readPom(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion());
                        if (pom != null) {
                            for (java.lang.String depKey : pom.dependencyManagements.keySet()) {
                                if (!(dependencyManagements.containsKey(depKey))) {
                                    dependencyManagements.put(depKey, pom.dependencyManagements.get(depKey));
                                }
                            }
                        }
                    }else {
                        java.lang.String depKey = ((dependency.getGroupId()) + ":") + (dependency.getArtifactId());
                        if (!(dependencyManagements.containsKey(depKey))) {
                            dependencyManagements.put(depKey, extractVersion(dependency.getGroupId(), dependency.getArtifactId(), dependency.getVersion()));
                        }
                    }
                }
            }
        }

        void addModule(spoon.MavenLauncher.InheritanceModel module) {
            modules.add(module);
        }

        public org.apache.maven.model.Model getModel() {
            return model;
        }

        /**
         * Get the parent model
         *
         * @return the parent model
         */
        public spoon.MavenLauncher.InheritanceModel getParent() {
            return parent;
        }

        /**
         * Get the list of source directories of the project
         *
         * @return the list of source directories
         */
        java.util.List<java.io.File> getSourceDirectories() {
            java.util.List<java.io.File> output = new java.util.ArrayList<>();
            java.lang.String sourcePath = null;
            org.apache.maven.model.Build build = model.getBuild();
            if (build != null) {
                sourcePath = build.getSourceDirectory();
            }
            if (sourcePath == null) {
                sourcePath = java.nio.file.Paths.get(directory.getAbsolutePath(), "src", "main", "java").toString();
            }
            java.io.File source = new java.io.File(sourcePath);
            if (source.exists()) {
                output.add(source);
            }
            java.io.File generatedSource = java.nio.file.Paths.get(directory.getAbsolutePath(), "target", "generated-sources").toFile();
            if (generatedSource.exists()) {
                output.add(generatedSource);
            }
            for (spoon.MavenLauncher.InheritanceModel module : modules) {
                output.addAll(module.getSourceDirectories());
            }
            return output;
        }

        /**
         * Get the list of test directories of the project
         *
         * @return the list of test directories
         */
        java.util.List<java.io.File> getTestDirectories() {
            java.util.List<java.io.File> output = new java.util.ArrayList<>();
            java.lang.String sourcePath = null;
            org.apache.maven.model.Build build = model.getBuild();
            if (build != null) {
                sourcePath = build.getTestSourceDirectory();
            }
            if (sourcePath == null) {
                sourcePath = java.nio.file.Paths.get(directory.getAbsolutePath(), "src", "test", "java").toString();
            }
            java.io.File source = new java.io.File(sourcePath);
            if (source.exists()) {
                output.add(source);
            }
            java.io.File generatedSource = java.nio.file.Paths.get(directory.getAbsolutePath(), "target", "generated-test-sources").toFile();
            if (generatedSource.exists()) {
                output.add(generatedSource);
            }
            for (spoon.MavenLauncher.InheritanceModel module : modules) {
                output.addAll(module.getTestDirectories());
            }
            return output;
        }

        /**
         * Extract the variable from a string
         */
        private java.lang.String extractVariable(java.lang.String value) {
            if ((value != null) && (value.startsWith("$"))) {
                value = getProperty(value.substring(2, ((value.length()) - 1)));
            }
            return value;
        }

        private java.lang.String extractVersion(java.lang.String groupId, java.lang.String artifactId, java.lang.String version) {
            if (version == null) {
                java.lang.String depKey = (groupId + ":") + artifactId;
                if (dependencyManagements.containsKey(depKey)) {
                    return dependencyManagements.get(depKey);
                }else
                    if ((this.parent) != null) {
                        return this.parent.extractVersion(groupId, artifactId, version);
                    }

            }
            version = extractVariable(version);
            // TODO: Handle range version
            if ((version != null) && (version.startsWith("["))) {
                version = version.substring(1, version.indexOf(','));
            }
            return version;
        }

        private spoon.MavenLauncher.InheritanceModel readPom(java.lang.String groupId, java.lang.String artifactId, java.lang.String version) {
            version = extractVersion(groupId, artifactId, version);
            groupId = groupId.replace(".", "/");
            java.lang.String fileName = (artifactId + "-") + version;
            java.nio.file.Path depPath = java.nio.file.Paths.get(m2RepositoryPath, groupId, artifactId, version, (fileName + ".pom"));
            try {
                return readPOM(depPath.toString(), null);
            } catch (java.lang.Exception e) {
                spoon.Launcher.LOGGER.log(org.apache.log4j.Level.ERROR, ("Unable to read the POM:" + (depPath.toString())), e);
                return null;
            }
        }

        private spoon.MavenLauncher.TreeDependency getTreeDependency(org.apache.maven.model.Dependency dependency, boolean isLib, java.util.Set<spoon.MavenLauncher.TreeDependency> hierarchy) {
            java.lang.String groupId = extractVariable(dependency.getGroupId());
            java.lang.String artifactId = extractVariable(dependency.getArtifactId());
            java.lang.String version = extractVersion(groupId, artifactId, dependency.getVersion());
            if (version == null) {
                spoon.Launcher.LOGGER.warn(((((("A dependency version cannot be resolved: " + groupId) + ":") + artifactId) + ":") + version));
                return null;
            }
            // pass only the optional dependency if it's in a library dependency
            if (isLib && (dependency.isOptional())) {
                return null;
            }
            // ignore test dependencies for app source code
            if (("test".equals(dependency.getScope())) && (((spoon.MavenLauncher.SOURCE_TYPE.APP_SOURCE) == (sourceType)) || isLib)) {
                return null;
            }
            // ignore not transitive dependencies
            if (isLib && ((("test".equals(dependency.getScope())) || ("provided".equals(dependency.getScope()))) || ("compile".equals(dependency.getScope())))) {
                spoon.Launcher.LOGGER.log(org.apache.log4j.Level.WARN, ((((("Dependency ignored (scope: provided or test):" + (dependency.getGroupId())) + ":") + (dependency.getArtifactId())) + ":") + version));
                return null;
            }
            spoon.MavenLauncher.TreeDependency dependence = new spoon.MavenLauncher.TreeDependency(groupId, artifactId, version, dependency.getType());
            try {
                spoon.MavenLauncher.InheritanceModel dependencyModel = readPom(groupId, artifactId, version);
                if (dependencyModel != null) {
                    dependence = dependencyModel.getTreeDependency(true, hierarchy);
                    dependence.groupId = groupId;
                    dependence.artifactId = artifactId;
                    dependence.version = version;
                    if ((dependency.getExclusions()) != null) {
                        for (int i = 0; i < (dependency.getExclusions().size()); i++) {
                            org.apache.maven.model.Exclusion exclusion = dependency.getExclusions().get(i);
                            dependence.removeDependency(exclusion.getGroupId(), exclusion.getArtifactId());
                        }
                    }
                }
            } catch (java.lang.Exception ignore) {
                // ignore the dependencies of the dependency
            }
            return dependence;
        }

        private spoon.MavenLauncher.TreeDependency getTreeDependency() {
            return getTreeDependency(false, new java.util.HashSet<>());
        }

        /**
         * Get the list of dependencies available in the local maven repository
         *
         * @param isLib:
         * 		If false take dependency of the main project; if true, take dependencies of a library of the project
         * @return the list of  dependencies
         */
        private spoon.MavenLauncher.TreeDependency getTreeDependency(boolean isLib, java.util.Set<spoon.MavenLauncher.TreeDependency> hierarchy) {
            java.lang.String groupId = extractVariable(model.getGroupId());
            java.lang.String artifactId = extractVariable(model.getArtifactId());
            java.lang.String version = extractVersion(groupId, artifactId, model.getVersion());
            spoon.MavenLauncher.TreeDependency dependence = new spoon.MavenLauncher.TreeDependency(groupId, artifactId, version, model.getPackaging());
            if (hierarchy.contains(dependence)) {
                return dependence;
            }
            hierarchy.add(dependence);
            // add the parent has a dependency
            if ((this.parent) != null) {
                dependence.addDependence(this.parent.getTreeDependency(isLib, hierarchy));
            }
            java.util.List<org.apache.maven.model.Dependency> dependencies = model.getDependencies();
            for (org.apache.maven.model.Dependency dependency : dependencies) {
                dependence.addDependence(getTreeDependency(dependency, isLib, hierarchy));
            }
            if (!isLib) {
                for (spoon.MavenLauncher.InheritanceModel module : modules) {
                    if ((module.model.getGroupId()) == null) {
                        module.model.setGroupId(groupId);
                    }
                    if ((module.model.getVersion()) == null) {
                        module.model.setVersion(version);
                    }
                    dependence.addDependence(module.getTreeDependency(isLib, hierarchy));
                }
            }
            return dependence;
        }

        /**
         * Get the value of a property
         *
         * @param key
         * 		the key of the property
         * @return the property value if key exists or null
         */
        private java.lang.String getProperty(java.lang.String key) {
            if ("project.version".equals(key)) {
                if ((model.getVersion()) != null) {
                    return model.getVersion();
                }
            }else
                if ("project.groupId".equals(key)) {
                    if ((model.getGroupId()) != null) {
                        return model.getGroupId();
                    }
                }else
                    if ("project.artifactId".equals(key)) {
                        if ((model.getArtifactId()) != null) {
                            return model.getArtifactId();
                        }
                    }


            java.lang.String value = extractVariable(model.getProperties().getProperty(key));
            if (value == null) {
                if ((parent) == null) {
                    return null;
                }
                return parent.getProperty(key);
            }
            return value;
        }

        /**
         * Get the source version of the project
         *
         * @return the source version of the project
         */
        int getSourceVersion() {
            if ((model.getBuild()) != null) {
                for (org.apache.maven.model.Plugin plugin : model.getBuild().getPlugins()) {
                    if (!("maven-compiler-plugin".equals(plugin.getArtifactId()))) {
                        continue;
                    }
                    org.codehaus.plexus.util.xml.Xpp3Dom configuration = ((org.codehaus.plexus.util.xml.Xpp3Dom) (plugin.getConfiguration()));
                    org.codehaus.plexus.util.xml.Xpp3Dom source = configuration.getChild("source");
                    if (source != null) {
                        return java.lang.Integer.parseInt(extractVariable(source.getValue()).substring(2));
                    }
                    break;
                }
            }
            java.lang.String javaVersion = getProperty("java.version");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("java.src.version");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("maven.compiler.source");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            javaVersion = getProperty("maven.compile.source");
            if (javaVersion != null) {
                return java.lang.Integer.parseInt(extractVariable(javaVersion).substring(2));
            }
            // return the current compliance level of spoon
            return getEnvironment().getComplianceLevel();
        }

        @java.lang.Override
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(model.getGroupId());
            sb.append(":");
            sb.append(model.getArtifactId());
            sb.append(":");
            sb.append(model.getVersion());
            if (modules.isEmpty()) {
                return sb.toString();
            }
            sb.append(" {\n");
            for (spoon.MavenLauncher.InheritanceModel inheritanceModel : modules) {
                java.lang.String child = inheritanceModel.toString();
                for (java.lang.String s : child.split("\n")) {
                    sb.append("\t");
                    sb.append(s);
                    sb.append("\n");
                }
            }
            sb.append("}");
            return sb.toString();
        }
    }
}

