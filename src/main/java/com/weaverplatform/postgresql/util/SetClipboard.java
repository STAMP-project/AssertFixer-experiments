package com.weaverplatform.postgresql.util;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class SetClipboard {

  public static final void with(String data) {
    StringSelection selection = new StringSelection(data);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);
  }
}

