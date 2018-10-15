/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.nar;

import org.apache.nifi.bundle.Bundle;
import org.apache.nifi.bundle.BundleCoordinate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Loads a NAR while the application is running.
 *
 * NOTE: Initially this will only be used from the NarAutoLoader which is watching a directory for new files, but eventually
 * this may also be used for loading a NAR that was downloaded from the extension registry, and thus the load method
 * is synchronized to ensure only one NAR can be in process of loading at a given time.
 */
public class NarLoader {

    private static Logger LOGGER = LoggerFactory.getLogger(NarLoader.class);

    private File extensionsWorkingDir;
    private File docsWorkingDir;
    private ExtensionMapping extensionMapping;

    public NarLoader(final File extensionsWorkingDir,
                     final File docsWorkingDir,
                     final ExtensionMapping extensionMapping) {
        this.extensionsWorkingDir = extensionsWorkingDir;
        this.docsWorkingDir = docsWorkingDir;
        this.extensionMapping = extensionMapping;
    }

    public synchronized void load(final File narFile) {
        LOGGER.info("Auto-loading new NAR {}...", new Object[]{narFile.getName()});

        try (final JarFile nar = new JarFile(narFile)) {
            final Manifest manifest = nar.getManifest();

            final Attributes attributes = manifest.getMainAttributes();
            final String groupId = attributes.getValue(NarManifestEntry.NAR_GROUP.getManifestName());
            final String narId = attributes.getValue(NarManifestEntry.NAR_ID.getManifestName());
            final String version = attributes.getValue(NarManifestEntry.NAR_VERSION.getManifestName());

            if (NarClassLoaders.FRAMEWORK_NAR_ID.equals(narId)) {
                LOGGER.error("Found a framework NAR, will not load {}", new Object[]{narFile.getAbsolutePath()});
                return;
            }

            final BundleCoordinate coordinate = new BundleCoordinate(groupId, narId, version);

            final Bundle bundle = ExtensionManager.getBundle(coordinate);
            if (bundle != null) {
                LOGGER.warn("Found existing bundle with coordinate {}, will not load {}",
                        new Object[]{coordinate, narFile.getAbsolutePath()});
                return;
            }

            final File unpackedExtension = NarUnpacker.unpackNar(narFile, extensionsWorkingDir);
            NarUnpacker.mapExtension(unpackedExtension, coordinate, docsWorkingDir, extensionMapping);

            // TODO create a Bundle and call ExtensionManager

            LOGGER.info("Completed loading NAR {}", new Object[]{narFile.getName()});
        } catch (Exception e) {
            LOGGER.error("Error auto-loading NAR from " + narFile.getAbsolutePath(), e);
        }
    }

}
