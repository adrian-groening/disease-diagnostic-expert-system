package com.example.application.views.login;

import java.sql.SQLException;

import com.example.application.services.DatabaseOBJ;
import com.example.application.views.main.Admin;
import com.example.application.views.main.Authenticated;
import com.example.application.views.main.Home;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;

public class login extends Div {
    private DatabaseOBJ data;
    private TextField username = new TextField("ID Number");
    private PasswordField password = new PasswordField("Password");
    private Button login = new Button("Log In");
    private Button cancel = new Button("Cancel");

    public login() throws SQLException {

        data = new DatabaseOBJ();

        VerticalLayout page = new VerticalLayout();
        page.addClassNames(AlignItems.CENTER, JustifyContent.START);
        page.add(createTitle());
        page.add(username, password, login, cancel);

        // login button
        login.addClickListener(e -> {

            if (username.isEmpty() || password.isEmpty()) {
                Notification.show("Fill in all fields!");
            } else {

                int enteredID = Integer.parseInt(username.getValue());
                String enteredPw = password.getValue().toString();
                String aP, aU, loggedName;

                try {

                    aP = data.getPassword(enteredID);
                    aU = data.getUsername(enteredID);
                    loggedName = data.getFirstName(enteredID);

                    // getting role for regular user or admin definition
                    String role = data.getRole(enteredID);

                    if (!aP.equals(enteredPw)) {
                        Notification.show("Username or password is incorrect");
                    } else if (aP.equals(enteredPw)) {
                        Notification.show("Welcome " + loggedName);

                        if (role.equals("admin")) {
                            authenticatedAdmin();
                        } else if (role.equals("patient")) {
                            authenticated(enteredID);
                        }

                    }

                } catch (SQLException e1) {
                    Notification.show("ERROR: SQLException while trying to log you in.");
                    e1.printStackTrace();
                }

            }
        });

        // cancel button
        cancel.addClickListener(e -> {
            try {
                openHome();
            } catch (SQLException e1) {
                Notification.show("ERROR: SQLException while opening the home page.");
                e1.printStackTrace();
            }
        });

        add(page);
    }

    private Component createTitle() {
        return new H3("Log In");
    }

    public void openHome() throws SQLException {
        removeAll();
        add(new Home());
    }

    public void authenticated(int id) throws SQLException {
        removeAll();
        add(new Authenticated(id));
    }

    public void authenticatedAdmin() throws SQLException {
        removeAll();
        add(new Admin());
    }

}
