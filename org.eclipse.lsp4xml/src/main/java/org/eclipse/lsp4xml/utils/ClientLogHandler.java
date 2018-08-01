package org.eclipse.lsp4xml.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.eclipse.lsp4j.MessageParams;
import org.eclipse.lsp4j.MessageType;
import org.eclipse.lsp4j.services.LanguageClient;

/**
 * LogHandler
 */
public class ClientLogHandler extends Handler{
  private LanguageClient languageClient;

  public ClientLogHandler(LanguageClient languageClient) {
    this.languageClient = languageClient;
  }

  public LanguageClient getLanguageClient() {
    return this.languageClient;
  }

  @Override
  public void publish(LogRecord record) {
    if(languageClient == null) {
      return;
    }

    String msg = formatRecord(record);
    MessageType messageType= getMessageType(record.getLevel());
    MessageParams mp = new MessageParams(messageType, msg);
    languageClient.logMessage(mp);
    
  }
  
  public static String formatRecord(LogRecord record) {
    DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
    long date = record.getMillis();
    String formattedDate = formatter.format(date);
    StringBuilder sb = new StringBuilder();
    sb.append(formattedDate)
    .append(" ")
    .append(record.getSourceClassName())
    .append(" ")
    .append(record.getSourceMethodName())
    .append("()\n")
    .append("Message: " + record.getMessage());
    if (record.getThrown() != null) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      pw.println();
      record.getThrown().printStackTrace(pw);
      pw.close();
      sb.append(sw.toString());       
    }
    
    return sb.toString();
  }

  private static MessageType getMessageType(Level level) {
    if(level == Level.WARNING) {
      return MessageType.Warning;
    }
    if(level == Level.SEVERE) {
      return MessageType.Error;
    }
    return MessageType.Info;
  }

  @Override
  public void flush() {
  }

  @Override
  public void close() throws SecurityException {
  }

  @Override
  public boolean equals(Object o) {
    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

    /*
     * Check if o is an instance of Complex or not "null instanceof [type]" also
     * returns false
     */
    if (!(o instanceof ClientLogHandler)) {
      return false;
    }

    // typecast o to Complex so that we can compare data members
    ClientLogHandler c = (ClientLogHandler) o;

    // Compare the data members and return accordingly
    return this.languageClient == c.getLanguageClient();
  }
  
  
}