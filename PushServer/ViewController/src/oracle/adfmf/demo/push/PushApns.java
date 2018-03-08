package oracle.adfmf.demo.push;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.nio.ByteBuffer;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import java.util.Arrays;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.io.OutputStream;

import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import java.security.Security;

import java.util.Date;

public class PushApns {
    
    private int SOCKET_TIMEOUT = 5 * 1000; //default timeout
    private int RESPONSE_STREAM_LENGTH = 1024; //default response stream length
    private int responseStreamLength = 0; //actual response length from the socket
    private static final String ALGORITHM =
        ((Security.getProperty("ssl.KeyManagerFactory.algorithm") == null) ?
         "sunx509" : Security.getProperty("ssl.KeyManagerFactory.algorithm"));
    private static final String PROTOCOL = "TLS";
    private String sslSocketHost = "gateway.push.apple.com";
    private String sslSocketPort = "2195";
    private static final String CHAR_ENCODING = "UTF-8";
    private static final byte format = 1; // enhanced format
    private SSLSocket sslSocket;
    private String ksPath;
    private String keyPwd;
    private String proxyHost;
    private String proxyPort;

    public PushApns(String ksPath, String keyPwd) {
        this(ksPath, keyPwd, null, null);
    }
    
    public PushApns(String ksPath, String keyPwd, String proxyHost, String proxyPort) {
        this.ksPath = ksPath;
        this.keyPwd = keyPwd;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    public void sendString(String token, String messagePayload) {

        System.out.println("\nSend request received at: " + new Date());
        System.out.println("Token: " + token);
        try {
            String payload = getMessageAsString(messagePayload, 1, token, 10);
            try {
                send(payload);
                System.out.println("Status: successful!");
                //String response = readResponse();
                //System.out.println("Response: " + response);
            } catch (SocketException e) {
                System.out.println("Status: failed due to socket error! Close the current one and open a new one");
                closeSocket();
                send(payload);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void send(String payload) throws FileNotFoundException,
                                             KeyStoreException, IOException,
                                             NoSuchAlgorithmException,
                                             CertificateException,
                                             UnrecoverableKeyException,
                                             KeyManagementException {
        if (sslSocket == null || sslSocket.isClosed()) {
            getSocketConnection();
        }

        String[] payloadByteValues =
            payload.substring(1, payload.length() - 1).split(",");
        byte[] payloadBytes = new byte[payloadByteValues.length];

        for (int i = 0; i < payloadBytes.length; i++) {
            payloadBytes[i] = Byte.valueOf(payloadByteValues[i].trim());
        }

        OutputStream outputStream;

        outputStream = sslSocket.getOutputStream();
        outputStream.write(payloadBytes);
        outputStream.flush();
    }

    private void closeSocket() {
        try {
            if (sslSocket != null) {
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SSLSocket getSocketConnection() throws FileNotFoundException,
                                                   KeyStoreException,
                                                   IOException,
                                                   NoSuchAlgorithmException,
                                                   CertificateException,
                                                   UnrecoverableKeyException,
                                                   KeyManagementException {
        sslSocket = null;
        InputStream keystoreStream;
        SSLContext sslContext;
        SSLSocketFactory sslSocketFactory;


        keystoreStream = new BufferedInputStream(new FileInputStream(ksPath));
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        char[] passphrase = keyPwd.toCharArray();
        keyStore.load(keystoreStream, passphrase);
        KeyManagerFactory keyManagerFactory =
            KeyManagerFactory.getInstance(ALGORITHM);
        keyManagerFactory.init(keyStore, passphrase);

        TrustManager[] trustManagers =
            new TrustManager[] { new X509TrustManager() {
                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] certs,
                                               String authType) {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] certs,
                                               String authType) {
                }
            } };

        sslContext = SSLContext.getInstance(PROTOCOL);
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagers,
                        null);
        sslSocketFactory = sslContext.getSocketFactory();
        if ((proxyHost != null) && (!proxyHost.equals("")) &&
            (proxyPort != null) && (!proxyPort.equals(""))) {
            System.out.println("Creating socket via proxy");
            sslSocket =
                    tunnelThroughProxy(sslSocketFactory, proxyHost, Integer.parseInt(proxyPort),
                                       sslSocketHost,
                                       Integer.parseInt(sslSocketPort));

        } else {
            System.out.println("Creating socket");
            sslSocket =
                    (SSLSocket)sslSocketFactory.createSocket(sslSocketHost, Integer.parseInt(sslSocketPort));
        }


        return sslSocket;
    }

    private SSLSocket tunnelThroughProxy(SSLSocketFactory socketFactory,
                                         String tunnelHost, int tunnelPort,
                                         String sslSocketHost,
                                         int sslSocketPort) throws UnknownHostException,
                                                                   IOException {
        SSLSocket sslSocket;
        Socket tunnel = new Socket(tunnelHost, tunnelPort);
        doTunnelHandshake(tunnel, sslSocketHost, sslSocketPort);
        sslSocket =
                (SSLSocket)socketFactory.createSocket(tunnel, sslSocketHost,
                                                      sslSocketPort, true);

        return sslSocket;
    }

    private void doTunnelHandshake(Socket tunnel, String host,
                                   int port) throws IOException {

        OutputStream out = tunnel.getOutputStream();

        String msg = "CONNECT " + host + ":" + port + " HTTP/1.0\n" +
            "User-Agent: CS Server" + "\r\n\r\n";
        byte b[] = null;
        try {
            b = msg.getBytes("ASCII7");
        } catch (UnsupportedEncodingException ignored) {
            b = msg.getBytes();
        }
        out.write(b);
        out.flush();

        byte reply[] = new byte[200];
        int replyLen = 0;
        int newlinesSeen = 0;
        boolean headerDone = false;

        InputStream in = tunnel.getInputStream();

        while (newlinesSeen < 2) {
            int i = in.read();
            if (i < 0) {
                throw new IOException("Unexpected EOF from proxy");
            }
            if (i == '\n') {
                headerDone = true;
                ++newlinesSeen;
            } else if (i != '\r') {
                newlinesSeen = 0;
                if (!headerDone && replyLen < reply.length) {
                    reply[replyLen++] = (byte)i;
                }
            }
        }

        String replyStr;
        try {
            replyStr = new String(reply, 0, replyLen, "ASCII7");
        } catch (UnsupportedEncodingException ignored) {
            replyStr = new String(reply, 0, replyLen);
        }


        if (replyStr.toLowerCase().indexOf("200 connection established") ==
            -1) {
            throw new IOException("Unable to tunnel through. Proxy returns \"" +
                                  replyStr + "\"");
        }
    }

    private String readResponse() throws IOException, KeyStoreException,
                                         NoSuchAlgorithmException,
                                         CertificateException,
                                         UnrecoverableKeyException,
                                         KeyManagementException {
        if (RESPONSE_STREAM_LENGTH != 0) {
            InputStream inputStream;
            byte[] b = new byte[RESPONSE_STREAM_LENGTH];
            try {
                if (sslSocket == null) {
                    getSocketConnection();
                }
                sslSocket.setSoTimeout(SOCKET_TIMEOUT);
                inputStream = sslSocket.getInputStream();
                responseStreamLength =
                        inputStream.read(b, 0, RESPONSE_STREAM_LENGTH);
                while (responseStreamLength != -1) {
                    return Arrays.toString(b);
                }
            } catch (SocketTimeoutException se) {
                se.printStackTrace();
                return "";
            }
        }

        return "";
    }

    /**
     * @param payload
     * @param uniqueId
     * @param device_token
     * @param expiryInDays
     * @return
     * @throws IOException
     */
    public String getMessageAsString(String payload, int uniqueId,
                                     String device_token,
                                     int expiryInDays) throws IOException {
        return Arrays.toString(getMessage(payload, uniqueId, device_token,
                                          expiryInDays));
    }

    /**
     * @param payload
     * @param uniqueId
     * @param device_token
     * @return
     * @throws IOException
     */
    public byte[] getMessage(String payload, int uniqueId, String device_token,
                             int expiryInDays) throws IOException {

        long timeToLive = expiryInDays * 24 * 60 * 60 * 1000;

        long currenttime = System.currentTimeMillis();
        Long expiryDateInSeconds = ((currenttime + timeToLive) / 1000L);

        byte[] deviceTokenBytes = getdeviceTokenBytes(device_token);
        byte[] payloadBytes = getpayloadBytes(payload);

        int size =
            1 + 4 + 4 + 2 + deviceTokenBytes.length + 2 + payloadBytes.length;

        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);

        //write format
        baos.write(format);

        //write identifier
        baos.write(intTo4ByteArray(uniqueId));

        //write expiry time
        baos.write(intTo4ByteArray(expiryDateInSeconds.intValue()));


        //write device token bytes length
        baos.write(intTo2ByteArray(deviceTokenBytes.length));

        //write devicetoken bytes
        baos.write(deviceTokenBytes);


        //write payload bytes length
        baos.write(intTo2ByteArray(payloadBytes.length));

        //write payload bytes
        baos.write(payloadBytes);

        baos.flush();

        return baos.toByteArray();
    }

    private byte[] getdeviceTokenBytes(String deviceToken) {

        byte[] deviceTokenBytes = new byte[deviceToken.length() / 2];
        deviceToken = deviceToken.toUpperCase();
        int j = 0;
        try {
            for (int i = 0; i < deviceToken.length(); i += 2) {
                String str = deviceToken.substring(i, i + 2);
                int temp = Integer.parseInt(str, 16);
                deviceTokenBytes[j++] = (byte)temp;
            }
        } catch (NumberFormatException e1) {
            e1.printStackTrace();
        }

        return deviceTokenBytes;
    }

    private byte[] getpayloadBytes(String payload) {
        byte[] payloadBytes;
        try {
            payloadBytes = payload.getBytes(CHAR_ENCODING);
        } catch (UnsupportedEncodingException e) {
            payloadBytes = payload.getBytes();
        }
        return payloadBytes;
    }

    private static final byte[] intTo2ByteArray(int value) {
        int n = (value & 0xFF00) >> 8;
        int m = value & 0xFF;
        return new byte[] { (byte)n, (byte)m };
    }

    private static final byte[] intTo4ByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
}
