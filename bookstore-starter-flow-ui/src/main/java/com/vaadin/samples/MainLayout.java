package com.vaadin.samples;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.samples.about.AboutView;
import com.vaadin.samples.crud.SampleCrudView;

/**
 * The layout of the pages e.g. About and Inventory.
 */
@HtmlImport("css/shared-styles.html")
@Theme(value = Lumo.class)
@PWA(name = "Bookstore Starter", shortName = "Bookstore")
public class MainLayout extends FlexLayout implements RouterLayout {
    private Menu menu;

    public MainLayout() {
        setSizeFull();
        setClassName("main-layout");

        menu = new Menu();
        menu.addView(SampleCrudView.class, SampleCrudView.VIEW_NAME,
                VaadinIcon.EDIT.create());
        menu.addView(AboutView.class, AboutView.VIEW_NAME,
                VaadinIcon.INFO_CIRCLE.create());

        add(menu);

        UI.getCurrent().addShortcutListener(
                Shortcut.of('L', KeyModifier.ALT), menu::logout);
        UI.getCurrent().addShortcutListener(
                Shortcut.of('1', KeyModifier.ALT), this::crudView);
        UI.getCurrent().addShortcutListener(
                Shortcut.of('2', KeyModifier.ALT), this::aboutView);

    }

    private void crudView() {
        System.out.println("!!! crudView");

        UI.getCurrent().navigate(SampleCrudView.class);
    }

    private void aboutView() {
        System.out.println("!!! aboutView");

        UI.getCurrent().navigate(AboutView.class);
    }
}
