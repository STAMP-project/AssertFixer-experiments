package com.weaverplatform.queue;

import com.google.gson.Gson;
import com.weaverplatform.util.Cuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author bastbijl, Sysunite 2018
 */
public class StatusReport {

  static Logger logger = LoggerFactory.getLogger(StatusReport.class);

  public static Gson gson = new Gson();

  public String id;
  public Boolean done;
  public Boolean pending;
  public Boolean errored;
  public String message;
  public String log;
  public String fileId;
  public int progress;
  public int scale;

  public StatusReport() {
    this.id = Cuid.getRandomBlock();
  }

  public StatusReport(boolean done) {
    this.done = done;
  }

  public StatusReport(boolean done, String message) {
    this.done = done;
    setMessage(message);
  }

  public StatusReport setDone(boolean done) {
    this.done = done;
    return this;
  }

  public StatusReport setPending(boolean pending) {
    this.pending = pending;
    return this;
  }

  public StatusReport setErrored(boolean errored) {
    this.errored = errored;
    return this;
  }

  public StatusReport setMessage(String message) {
    this.message = message;
    logger.info("Set message on job: "+message);
    return this;
  }

  public StatusReport setLog(String log) {
    this.log = log;
    return this;
  }

  public StatusReport setFileId(String fileId) {
    this.fileId = fileId;
    return this;
  }

  public StatusReport setProgress(int progress) {
    this.progress = progress;
    return this;
  }

  public StatusReport setScale(int scale) {
    this.scale = scale;
    return this;
  }

  public String getId() {
    return id;
  }

  public String toString() {
    return gson.toJson(this);
  }
}
