package net.classicube.launcher;

import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import javax.swing.SwingWorker;

public class ClientUpdateTask extends SwingWorker<Boolean, Boolean> {

    private static final String ClientJar = "ClassiCubeClient.jar",
            ClientTempJar = "ClassiCubeClient.jar.tmp",
            ClientDownloadUrl = "http://www.classicube.net/static/client/client.jar",
            ClientHashUrl = "http://www.classicube.net/static/client/client.jar.md5";

    private ClientUpdateTask() {
    }
    private static ClientUpdateTask instance = new ClientUpdateTask();

    public static ClientUpdateTask getInstance() {
        return instance;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        LogUtil.Log(Level.FINE, "ClientUpdateTask.doInBackground");
        final File targetPath = LogUtil.getLauncherDir();
        final File clientFile = new File(targetPath, ClientJar);
        boolean needsUpdate;

        if (!clientFile.exists()) {
            // if local file does not exist, always update/download
            needsUpdate = true;

        } else {
            // else check if remote hash is different from local hash
            final String remoteHash = HttpUtil.downloadString(ClientHashUrl);
            if (remoteHash == null) {
                needsUpdate = false; // remote server is down, dont try to update
            } else {
                final String localHashString = computeLocalHash(clientFile);
                needsUpdate = localHashString.equalsIgnoreCase(remoteHash);
            }
        }

        if (needsUpdate) {
            // download (or re-download) the client
            final File clientTempFile = new File(targetPath, ClientTempJar);
            downloadClientJar(clientTempFile);
            replaceFile(clientTempFile, clientFile);
        }

        return needsUpdate;
    }

    private String computeLocalHash(File clientJar)
            throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        if (clientJar == null) {
            throw new IllegalArgumentException("clientJar may not be null");
        }
        final MessageDigest digest = MessageDigest.getInstance("MD5");
        final byte[] buffer = new byte[8192];
        try (FileInputStream is = new FileInputStream(clientJar)) {
            final DigestInputStream dis = new DigestInputStream(is, digest);
            while (dis.read(buffer) != -1) {
                // DigestInputStream is doing its job, we just need to read through it.
            }
        }
        final byte[] localHashBytes = digest.digest();
        return new BigInteger(1, localHashBytes).toString(16);
    }

    private void downloadClientJar(File clientJar)
            throws MalformedURLException, FileNotFoundException, IOException {
        if (clientJar == null) {
            throw new IllegalArgumentException("clientJar may not be null");
        }
        clientJar.delete();
        final URL website = new URL(ClientDownloadUrl);
        final ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        try (FileOutputStream fos = new FileOutputStream(clientJar)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    // Replace contents of destFile with sourceFile
    static void replaceFile(File sourceFile, File destFile)
            throws IOException {
        if (sourceFile == null) {
            throw new IllegalArgumentException("sourceFile may not be null");
        }
        if (destFile == null) {
            throw new IllegalArgumentException("destFile may not be null");
        }
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        try (FileChannel source = new FileInputStream(sourceFile).getChannel()) {
            try (FileChannel destination = new FileOutputStream(destFile).getChannel()) {
                destination.transferFrom(source, 0, source.size());
            }
        }

        sourceFile.delete();
    }
}