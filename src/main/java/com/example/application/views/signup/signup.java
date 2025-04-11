package com.example.application.views.signup;

import java.sql.SQLException;
import java.util.Random;

import com.example.application.services.DatabaseOBJ;
import com.example.application.views.main.Home;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;

public class signup extends Div {

    DatabaseOBJ data;
    private TextField id = new TextField("Passport/NationalID (What you'll use to sign in)");
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField username = new TextField("Username");
    private PasswordField password = new PasswordField("Password");
    private EmailField email = new EmailField("Email address");
    private DatePicker dob = new DatePicker("Date of Birth");
    private PhoneNumberField phone = new PhoneNumberField("Phone number");
    private TextField address = new TextField("Address");
    private TextField notes = new TextField("Notes");
    RadioButtonGroup<String> mH = new RadioButtonGroup<>("Medical History (Suffered from the most)");

    private ComboBox<String> sex = new ComboBox<>("Sex");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Sign Up");

    public signup() throws SQLException {
        data = new DatabaseOBJ();
        VerticalLayout page = new VerticalLayout();
        page.addClassNames(AlignItems.CENTER, JustifyContent.START);

        mH.setItems("Influenza", "Common Cold", "Asthma", "Diabetes", "Hypertension");

        sex.setPlaceholder("Sex");
        sex.setItems("M", "F");

        page.add(createTitle());
        page.add(createFormLayout());
        page.add(createButtonLayout());

        cancel.addClickListener(e -> {
            try {
                openHome();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });
        save.addClickListener(e -> {
            // saving details to database
            int userID = Integer.parseInt(id.getValue());
            String role = "patient";
            String usr = username.getValue();
            String pass = password.getValue();
            String nom = firstName.getValue();
            String sur = lastName.getValue();
            String ema = email.getValue();
            String dateofB = dob.getValue().toString();
            String addy = address.getValue();
            String pho = phone.getValue();
            String x = sex.getValue();
            String note = notes.getValue();
            String med = mH.getValue().toString();

            try {
                Random r = new Random();
                int y = r.nextInt();
                data.insertUser(userID, role, usr, pass, nom, sur, dateofB, x, addy, pho, ema, note);
                data.insertUserMedicalHistory(y, med, userID);
                openHome();
                Notification.show("You have been signed up!");
            } catch (SQLException e1) {
                e1.printStackTrace();
                Notification.show("ERROR: SQLException while signing user up.");
            }

        });

        add(page);
    }

    public void openHome() throws SQLException {
        removeAll();
        add(new Home());
    }

    private Component createTitle() {
        return new H3("Sign Up");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(id, firstName, lastName, username, password, dob, sex, address, phone, email, notes, mH);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private static class PhoneNumberField extends CustomField<String> {
        private ComboBox<String> countryCode = new ComboBox<>();
        private TextField number = new TextField();

        public PhoneNumberField(String label) {
            setLabel(label);
            countryCode.setWidth("120px");
            countryCode.setPlaceholder("Country");
            countryCode.setAllowedCharPattern("[\\+\\d]");
            countryCode.setItems("+354", "+91", "+62", "+98", "+964", "+353", "+44", "+972", "+39", "+225");
            countryCode.addCustomValueSetListener(e -> countryCode.setValue(e.getDetail()));
            number.setAllowedCharPattern("\\d");
            HorizontalLayout layout = new HorizontalLayout(countryCode, number);
            layout.setFlexGrow(1.0, number);
            add(layout);
        }

        @Override
        protected String generateModelValue() {
            if (countryCode.getValue() != null && number.getValue() != null) {
                String s = countryCode.getValue() + " " + number.getValue();
                return s;
            }
            return "";
        }

        @Override
        protected void setPresentationValue(String phoneNumber) {
            String[] parts = phoneNumber != null ? phoneNumber.split(" ", 2) : new String[0];
            if (parts.length == 1) {
                countryCode.clear();
                number.setValue(parts[0]);
            } else if (parts.length == 2) {
                countryCode.setValue(parts[0]);
                number.setValue(parts[1]);
            } else {
                countryCode.clear();
                number.clear();
            }
        }
    }
}
