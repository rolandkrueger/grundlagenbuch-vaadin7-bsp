package org.vaadin.grundlagenbuch.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI
@Theme("valo")
@Title("MediaLibrary")
public class ApplicationUI extends UI {
  @Override
  protected void init(VaadinRequest vaadinRequest) {
    setContent(buildContent());
  }

  private Component buildContent() {
    VerticalLayout mainLayout = new VerticalLayout();
    mainLayout.setMargin(true);

    createTitle(mainLayout);
    createSearchBar(mainLayout);

    HorizontalLayout navigationAndContentLayout = new HorizontalLayout();
    navigationAndContentLayout.setSizeFull();

    createNavbar(navigationAndContentLayout);
    Component contentLayout = createContentArea();

    navigationAndContentLayout.addComponent(contentLayout);
    mainLayout.addComponent(navigationAndContentLayout);

    return mainLayout;
  }

  private VerticalLayout createContentArea() {
    VerticalLayout contentLayout = new VerticalLayout();
    contentLayout.setSizeFull();
    final Label labelSuchergebnisse = new Label("Suchergebnisse");
    labelSuchergebnisse.setStyleName(ValoTheme.LABEL_H2);
    final Table table = new Table();
    table.addContainerProperty("Titel", String.class, "");
    table.addContainerProperty("Genre", String.class, "");
    table.addContainerProperty("Erworben am", String.class, "");
    table.setSizeFull();
    contentLayout.addComponents(labelSuchergebnisse, table);
    return contentLayout;
  }

  private void createNavbar(HorizontalLayout navigationAndContentLayout) {
    VerticalLayout navigationBar = new VerticalLayout();
    Label heading = new Label("Navigation");
    heading.setStyleName(ValoTheme.LABEL_H2);
    navigationBar.addComponents(heading,
            createNavbarButton("Musik"),
            createNavbarButton("Bücher"),
            createNavbarButton("Videospiele"),
            createNavbarButton("Filme")
    );
    navigationAndContentLayout.addComponent(navigationBar);
  }

  private void createTitle(VerticalLayout mainLayout) {
    final Label titleLabel = new Label("Meine Medien");
    titleLabel.addStyleName(ValoTheme.LABEL_H1);
    mainLayout.addComponent(titleLabel);
  }

  private void createSearchBar(VerticalLayout mainLayout) {
    HorizontalLayout searchBar = new HorizontalLayout();
    searchBar.setSizeFull();
    searchBar.setMargin(true);
    TextField searchBox = new TextField();
    searchBox.setInputPrompt("Suche");
    searchBar.addComponent(searchBox);
    searchBar.setComponentAlignment(searchBox, Alignment.MIDDLE_RIGHT);
    mainLayout.addComponent(searchBar);
  }

  private Button createNavbarButton(String label) {
    Button button = new Button(label);
    button.setStyleName(ValoTheme.BUTTON_LINK);
    return button;
  }
}
