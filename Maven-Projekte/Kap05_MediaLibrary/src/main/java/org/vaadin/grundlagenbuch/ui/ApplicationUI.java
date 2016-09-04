package org.vaadin.grundlagenbuch.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
@Title("MediaLibrary")
public class ApplicationUI extends UI {
  @Override
  protected void init(VaadinRequest vaadinRequest) {
    setContent(buildContent());
  }

  private Component buildContent() {
    return null;
  }
}
