package io.axway.iron.core.spi.file;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import com.google.common.base.Throwables;
import io.axway.iron.error.StoreException;

import static java.nio.file.Files.*;
import static java.util.Arrays.*;
import static java.util.Optional.*;
import static java.util.regex.Pattern.*;
import static java.util.stream.Collectors.*;

/**
 * Migration script to migrate iron snapshots files from 0.5.0 layout to 0.6.0 layout
 */
public class IronMigration {

    private static final String GLOBAL_DIRECTORY_NAME = "global";
    private static final String SNAPSHOT_DIRECTORY_NAME = "snapshot";
    private static final String SNAPSHOT_SUFFIX = ".snapshot";
    private static final String TX_DIRECTORY_NAME = "tx";
    private static final String TMP_DIRECTORY_NAME = ".tmp";
    private static final int TX_ID_FILENAME_LENGTH = 20;

    public static void main(String[] args) {
        try {
            // Check arguments
            if (args.length != 4) {
                throw new IllegalArgumentException("Missing arguments");
            }
            Path originIronPath = Paths.get(args[0]);
            if (!originIronPath.toFile().exists() || !originIronPath.toFile().isDirectory()) {
                throw new IllegalArgumentException("Unknown iron directory : " + args[0]);
            }
            String globalStoreManagerName = args[1];
            String storesStoreManagerName = args[2];
            if (globalStoreManagerName.length() == 0 || storesStoreManagerName.length() == 0) {
                throw new IllegalArgumentException("globalStoreManagerName and storesStoreManagerName must not be empty");
            }
            String targetIronPath = args[3];

            Path globalPath = originIronPath.resolve(GLOBAL_DIRECTORY_NAME).resolve(SNAPSHOT_DIRECTORY_NAME);
            Path targetGlobalPath = Paths.get(targetIronPath).resolve(globalStoreManagerName);
            Path targetStoresPath = Paths.get(targetIronPath).resolve(storesStoreManagerName);

            copyGlobalSnapshots(globalPath, targetGlobalPath);
            copyTenantSnapshots(originIronPath, targetStoresPath);
            completeStoreSnapshotWithMissingInstanceSnapshots(targetStoresPath);
            alignStoreTransactionIdWithLastSnapshotId(Paths.get(targetIronPath), globalStoreManagerName);
            alignStoreTransactionIdWithLastSnapshotId(Paths.get(targetIronPath), storesStoreManagerName);

            System.out.printf("Migration done from %s to %s.%n", originIronPath, targetIronPath);
        } catch (Exception e) {
            System.err.println(
                    "Usage of migration tool : java -jar migrationTool.jar uriToIronDirectory globalStoreManagerName storesStoreManagerName uriToTargetDirectory\n"
                            + "\tglobalStoreManagerName and storesStoreManagerName must correspond to the names given in the code of traceability-ui");
            throw Throwables.propagate(e);
        }
    }

    /**
     * Add an empty transaction which id is the last snapshotId.
     * As a consequence, the next transaction will have an id greater than the last snapshotId,
     * and then this transaction will be processed if the node restarts abruptly (ie without triggering the creation of a snapshot).
     *
     * @param targetIronPath the path of iron
     * @param storeManagerName the name of the storeManager (globalStoreManagerName or storesStoreManagerName)
     */
    private static void alignStoreTransactionIdWithLastSnapshotId(Path targetIronPath, String storeManagerName) throws IOException {
        String emptyTransactionStoreName = getFirstStoreOfLastSnapshot(targetIronPath, storeManagerName);
        if (emptyTransactionStoreName == null) {
            return;
        }

        Path targetStorePath = targetIronPath.resolve(storeManagerName);

        Pattern txFileNamePattern = compile("\\d+_.*\\.tx");
        Path txTargetPath = targetStorePath.resolve(TX_DIRECTORY_NAME);
        Path snapshotTargetPath = targetStorePath.resolve(SNAPSHOT_DIRECTORY_NAME);
        Optional<BigInteger> maxTxId = txTargetPath.toFile().exists() ? list(txTargetPath).
                map(txPath -> txFileNamePattern.matcher(txPath.getFileName().toString()).group(1)).
                map(BigInteger::new).
                max(BigInteger::compareTo) : empty();
        Optional<BigInteger> maxSnapshotId = list(snapshotTargetPath).
                map(snapshotDirectory -> snapshotDirectory.getFileName().toString()).
                map(BigInteger::new).
                max(BigInteger::compareTo);
        if (maxSnapshotId.isPresent() && (!maxTxId.isPresent() || maxSnapshotId.get().compareTo(maxTxId.get()) > 0)) {
            createEmptyTransaction(targetIronPath, storeManagerName, emptyTransactionStoreName, txTargetPath, maxSnapshotId.get());
        }
    }

    private static String getFirstStoreOfLastSnapshot(Path targetIronPath, String storeManagerName) throws IOException {
        Optional<Path> lastSnapshot;
        try (Stream<Path> snapshotFiles = list(
                targetIronPath.resolve(storeManagerName).resolve(SNAPSHOT_DIRECTORY_NAME))) {// snapshot directory of the storeManager
            lastSnapshot = snapshotFiles.max(Path::compareTo);
        }
        if (!lastSnapshot.isPresent()) {
            return null;
        }
        Optional<Path> firstInstance;
        try (Stream<Path> instanceFiles = list(lastSnapshot.get())) {// snapshot directory of the storeManager
            firstInstance = instanceFiles.min(Path::compareTo);
        }
        if (!firstInstance.isPresent()) {
            return null;
        }
        String emptyTransactionStoreFileName = firstInstance.get().getFileName().toString();
        return emptyTransactionStoreFileName.substring(0, emptyTransactionStoreFileName.lastIndexOf('.'));
    }

    private static void createEmptyTransaction(Path targetIronPath, String storeManagerName, String storeName, Path txTargetPath, BigInteger maxSnapshotId)
            throws IOException {
        String txContent = "{\"transactionModelVersion\":1,\"synchronizationId\":\"" + UUID.randomUUID() + "\",\"commands\":[]}";
        createDirectories(txTargetPath);
        FileTransactionStoreBuilder fileTransactionStoreBuilder = new FileTransactionStoreBuilder(storeManagerName).setDir(targetIronPath);
        FileTransactionStore fileTransactionStore = (FileTransactionStore) fileTransactionStoreBuilder.get();
        String fileName = fileTransactionStore.getFileName(maxSnapshotId.longValueExact(), storeName);
        Path txAlignedWithSnapshot = txTargetPath.resolve(fileName);
        try (PrintWriter out = new PrintWriter(txAlignedWithSnapshot.toFile())) {
            out.println(txContent);
        }
    }

    private static void copyTenantSnapshots(Path ironPath, Path targetStoresPath) throws IOException {
        Files.walkFileTree(ironPath, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                String name = dir.getFileName().toString();
                if (GLOBAL_DIRECTORY_NAME.equals(name) || TMP_DIRECTORY_NAME.equals(name) || TX_DIRECTORY_NAME.equals(name)) {
                    return FileVisitResult.SKIP_SUBTREE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String store = file.getName(file.getNameCount() - 3).toString();
                String tx = file.getFileName().toString().substring(0, TX_ID_FILENAME_LENGTH);
                Path snapshotDir = targetStoresPath.resolve(SNAPSHOT_DIRECTORY_NAME).resolve(tx);
                snapshotDir.toFile().mkdirs();
                copy(file, snapshotDir.resolve(store + SNAPSHOT_SUFFIX));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                throw new StoreException(exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void copyGlobalSnapshots(Path globalPath, Path targetGlobalPath) throws IOException {
        try (Stream<Path> pathStream = Files.walk(globalPath)) {
            pathStream                                                    //
                    .map(Path::toFile)                                                //
                    .filter(File::isFile)                                             //
                    .filter(file -> file.getName().endsWith(SNAPSHOT_SUFFIX))             //
                    .forEach(file -> {                                                //
                        String tx = file.getName().substring(0, 20);
                        try {
                            Path snapshotDir = targetGlobalPath.resolve(SNAPSHOT_DIRECTORY_NAME).resolve(tx);
                            snapshotDir.toFile().mkdirs();
                            copy(file.toPath(), snapshotDir.resolve(GLOBAL_DIRECTORY_NAME + SNAPSHOT_SUFFIX));
                        } catch (IOException e) {
                            throw Throwables.propagate(e);
                        }
                    });
        }
    }

    /**
     * Complete snapshot N with lacking instance snapshots from snapshot N - 1
     *
     * @param targetStoresPath path to store target iron
     */
    private static void completeStoreSnapshotWithMissingInstanceSnapshots(Path targetStoresPath) {
        String transactionIdRegexAlone = "\"transactionId\"\\s*:\\s*\\d+\\s*,";
        String transactionIdRegexReplace = "(.*\"transactionId\"\\s*:\\s*)\\d+(\\s*,.*)";
        Pattern transactionIdPattern = compile(transactionIdRegexAlone);
        Set<File> previousSnapshots = new HashSet<>();
        List<File> snapshots = asList(targetStoresPath.resolve(SNAPSHOT_DIRECTORY_NAME).toFile().listFiles());
        Collections.sort(snapshots);
        snapshots.forEach(snapshot -> {
            Set<String> snapshotNames = stream(snapshot.listFiles()).map(File::getName).collect(toSet());
            previousSnapshots.stream().
                    filter(previousSnapshot -> !snapshotNames.contains(previousSnapshot.getName())).
                    forEach(previousSnapshot -> {
                        try {
                            Path targetPath = snapshot.toPath().resolve(previousSnapshot.getName());
                            Path sourcePath = previousSnapshot.toPath();
                            long count = countTransactionId(transactionIdPattern, sourcePath);
                            if (count != 1L) {
                                throw new StoreException("transactionId not found once", args -> args.add("found count", count));
                            }
                            BigInteger newTransactionId = new BigInteger(snapshot.getName());
                            replaceTransactionIdValue(transactionIdRegexReplace, sourcePath, targetPath, newTransactionId.toString());
                        } catch (IOException e) {
                            throw Throwables.propagate(e);
                        }
                    });
            previousSnapshots.clear();
            previousSnapshots.addAll(stream(snapshot.listFiles()).collect(toSet()));
        });
    }

    private static long countTransactionId(Pattern transactionIdPattern, Path targetPath) throws IOException {
        try (Stream<String> lines = Files.lines(targetPath)) {
            // TODO: to be improved with Java 9 Matcher.results()
            return lines.mapToLong(line -> {
                Long foundTransactionIdCount = 0L;
                Matcher matcher = transactionIdPattern.matcher(line);
                while (matcher.find()) {
                    foundTransactionIdCount++;
                }
                return foundTransactionIdCount;
            }).sum();
        }
    }

    private static void replaceTransactionIdValue(String transactionIdRegex, Path sourcePath, Path targetPath, String newTransactionId) throws IOException {
        try (Stream<String> lines = Files.lines(sourcePath)) {
            Files.write(targetPath, lines.map(line -> line.replaceAll(transactionIdRegex, "$1" + newTransactionId + "$2")).collect(toList()));
        }
    }
}
