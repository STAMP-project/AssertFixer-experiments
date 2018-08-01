package org.eclipse.lsp4xml.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.MessageActionItem;
import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PublishDiagnosticsParams;
import org.eclipse.lsp4j.ShowMessageRequestParams;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4xml.XMLLanguageServer;
import org.eclipse.lsp4xml.commons.BadLocationException;
import org.eclipse.lsp4xml.internal.parser.XMLParser;
import org.eclipse.lsp4xml.model.XMLDocument;
import org.eclipse.lsp4xml.services.XMLLanguageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * LoggerTest
 */
public class LoggerTest {
  private String path = "target/logs/testLogFile.log";
  private MockLanguageClient mockLanguageClient;
  private File logFile;
  private XMLLanguageService languageService;
  private XMLDocument xmlDocument;

  @Before
  public void startup() {
    deleteLogFile();
    mockLanguageClient = createLanguageClient(MessageType.Error, "Log Message");
    InitializeParams params = createInitializationOptionsParams(path);
    LogHelper.initializeRootLogger(mockLanguageClient, XMLLanguageServer.getInitializationOptions(params));
    logFile = new File(path);
  }

  @After
  public void cleanUp() {
    Handler[] handlers = Logger.getLogger("").getHandlers();
    for (Handler h : handlers) {
      h.close();
    }
    deleteLogFile();
  }

  @Test
  public void testLogCreated() {
    assertTrue(logFile.exists());
    Logger.getLogger("").log(Level.SEVERE, "Log Message");
    assertTrue(logFile.exists());
  }

  @Test
  public void testLogFormat() throws IOException {
    assertTestFormatting(logFile);
  }

  @Test
  public void testClientReceivesLog() {
    Logger.getLogger("").log(Level.SEVERE, "Log Message");
    assertTrue(mockLanguageClient.wasLogRecieved());
  }

  // ---------------------Tools-------------------------------

  public void assertTestFormatting(File logFile) throws IOException {

    Level level = Level.SEVERE;
    long recordMillis = 874400705000L;
    DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
    String formattedDate = formatter.format(recordMillis);
    String recordSourceClassName = "org.my.test.Class";
    String recordSourceMethodName = "mySourceMethod";
    String recordMessage = "Formatting Log Message";
    Throwable throwable = new Throwable() {
      public void printStackTrace(PrintWriter s) {
        StackTraceElement[] trace = getStackTrace();
        for (StackTraceElement traceElement : trace) {
            s.println("\tat " + traceElement);
        }
      }
    };
    StackTraceElement recordStackTrace1 = new StackTraceElement("declaringClass", "methodName", "fileName.java", 1);
    StackTraceElement recordStackTrace2 = new StackTraceElement("declaringClass2", "methodName2.drl.java", "fileName2.java", 2);
    StackTraceElement recordStackTrace3 = new StackTraceElement("declaringClass", "methodName.apk.java", "fileName", 3);
    StackTraceElement[] recordStackTrace = { recordStackTrace1, recordStackTrace2, recordStackTrace3 };
    throwable.setStackTrace(recordStackTrace);

    LogRecord record = new LogRecord(level, recordMessage);
    record.setMillis(recordMillis);
    record.setSourceClassName(recordSourceClassName);
    record.setSourceMethodName(recordSourceMethodName);
    record.setMessage(recordMessage);
    record.setThrown(throwable);
    String expectedOutput = 
    "Sep 16, 1997 05:05:05 org.my.test.Class mySourceMethod()\n" + 
    "Message: Formatting Log Message\n" +
    "\tat declaringClass.methodName(fileName.java:1)\n" +
    "\tat declaringClass2.methodName2.drl.java(fileName2.java:2)\n" +
    "\tat declaringClass.methodName.apk.java(fileName:3)\n";

    assertEquals(expectedOutput, ClientLogHandler.formatRecord(record));
    

  }

  private MockLanguageClient createLanguageClient(MessageType messageType, String message) {
    MockLanguageClient newLanguageClient = new MockLanguageClient(messageType, message);
    return newLanguageClient;
  }

  class MockLanguageClient implements LanguageClient {
    MessageType expectedMessageType;
    String message;
    Boolean logWasRecieved = false;

    public MockLanguageClient(MessageType expectedMessageType, String message) {
      this.expectedMessageType = expectedMessageType;
      this.message = message;
    }
    public void telemetryEvent(Object object) {}
    @Override public CompletableFuture<MessageActionItem> showMessageRequest(ShowMessageRequestParams requestParams) {return null;}
    @Override public void showMessage(MessageParams messageParams) {}
    @Override public void publishDiagnostics(PublishDiagnosticsParams diagnostics) {}
    @Override
    public void logMessage(MessageParams messageParams) {
      assertEquals(expectedMessageType, messageParams.getType());
      this.logWasRecieved = true;
    }
    public Boolean wasLogRecieved() {
      return this.logWasRecieved;
    }

  }

  private InitializeParams createInitializationOptionsParams(String path) {
    InitializeParams params = new InitializeParams();
    Map<String, String> options = new HashMap<>();
    options.put("lsp4xml.LogPath", path);
    params.setInitializationOptions(options);
    return params;
  }

  private FileHandler createFileHandler(String path) {
    FileHandler expectedFileHandler = null;
    try {
      expectedFileHandler = LogHelper.getFileHandler(path);
    } catch (SecurityException | IOException e) {
      fail("FileHandler could not be created");
    }
    return expectedFileHandler;
  }

  public void deleteLogFile() {
    File f = new File(path);
    if (f.exists()) {
      f.delete();
    }
  }

}