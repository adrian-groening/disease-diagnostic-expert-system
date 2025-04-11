package com.example.application.views.admin.patients;

import java.sql.SQLException;
import java.util.List;

import com.example.application.services.DatabaseOBJ;
import com.example.entities.user;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;

@Route(value = "patients")
public class patients extends VerticalLayout {

    DatabaseOBJ data;

    HorizontalLayout head = new HorizontalLayout();
    HorizontalLayout body = new HorizontalLayout();

    VerticalLayout v1 = new VerticalLayout();

    VerticalLayout page = new VerticalLayout();

    private TextField id = new TextField("Passport/NationalID");
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField username = new TextField("Username");
    private TextField password = new TextField("Password");
    private EmailField email = new EmailField("Email address");
    private DatePicker dob = new DatePicker("Date of Birth");
    private PhoneNumberField phone = new PhoneNumberField("Phone number");
    private TextField address = new TextField("Address");
    private TextField notes = new TextField("Notes");
    private ComboBox<String> sex = new ComboBox<>("Sex");

    Button save = new Button("Save");
    Button cancel = new Button("Cancel");

    public patients() throws SQLException {

        sex.setPlaceholder("Sex");
        sex.setItems("M", "F");

        data = new DatabaseOBJ();
        List<user> users = data.getUsers();

        Accordion accordion = new Accordion();

        H2 title = new H2("Patients");
        head.addClassNames(AlignItems.CENTER, JustifyContent.START);
        head.add(title);
        page.add(head);

        for (int i = 0; i < users.size(); i++) {
            VerticalLayout personalInformationLayout = new VerticalLayout();
            Span suserID = new Span("userID: " + users.get(i).getID());
            Span srole = new Span("Role: " + users.get(i).getRole());
            Span susername = new Span("Username: " + users.get(i).getUsername());
            Span spassword = new Span("Password: " + users.get(i).getPassword());
            Span sfirstname = new Span("Firstname: " + users.get(i).getFirstname());
            Span ssurname = new Span("Surname: " + users.get(i).getSurname());
            Span sdob = new Span("Date of Birth: " + users.get(i).getDOB());
            Span ssex = new Span("Sex: " + users.get(i).getSex());
            Span saddress = new Span("Address: " + users.get(i).getAddress());
            Span sphone = new Span("Phone: " + users.get(i).getPhone());
            Span semail = new Span("Email: " + users.get(i).getEmail());
            Span snotes = new Span("Notes: " + users.get(i).getNotes());

            personalInformationLayout.add(suserID, srole, susername, spassword,
                    sfirstname,
                    ssurname,
                    sdob, ssex, saddress, sphone, semail, snotes);
            personalInformationLayout.setSpacing(false);
            personalInformationLayout.setPadding(false);
            personalInformationLayout.addClassNames(AlignItems.CENTER, JustifyContent.START);
            accordion.add(users.get(i).getFirstname() + " " + users.get(i).getSurname(), personalInformationLayout);
            accordion.setSizeFull();
            v1.add(accordion);

            personalInformationLayout.addClickListener(e -> {
                Notification.show("Edit patient records below.");
            });

        }

        save.addClickListener(e -> {
            if (!id.isEmpty()) {
                if (!firstName.isEmpty()) {
                    try {
                        data.updateFirstname(Integer.parseInt(id.getValue()), firstName.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating firstname.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                        Notification.show("ERROR: SQLException while updating firstname.");
                    }
                }
                if (!lastName.isEmpty()) {
                    try {
                        data.updateSurname(Integer.parseInt(id.getValue()), lastName.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating surname.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating surname.");
                        e1.printStackTrace();
                    }
                }
                if (!username.isEmpty()) {
                    try {
                        data.updateUsername(Integer.parseInt(id.getValue()), username.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating username.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating username.");
                        e1.printStackTrace();
                    }
                }
                if (!password.isEmpty()) {
                    try {
                        data.updatePassword(Integer.parseInt(id.getValue()), password.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating password.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating password.");
                        e1.printStackTrace();
                    }
                }
                if (!email.isEmpty()) {
                    try {
                        data.updateEmail(Integer.parseInt(id.getValue()), email.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating email");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating email.");
                        e1.printStackTrace();
                    }
                }
                if (!dob.isEmpty()) {
                    try {
                        data.updateDOB(Integer.parseInt(id.getValue()), dob.getValue().toString());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating date of birth.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating date of birth.");
                        e1.printStackTrace();
                    }
                }
                if (!phone.isEmpty()) {
                    try {
                        data.updatePhone(Integer.parseInt(id.getValue()), phone.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating phone.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating phone.");
                        e1.printStackTrace();
                    }
                }
                if (!address.isEmpty()) {
                    try {
                        data.updateAddress(Integer.parseInt(id.getValue()), address.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating address.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating address.");
                        e1.printStackTrace();
                    }
                }
                if (!notes.isEmpty()) {
                    try {
                        data.updateNotes(Integer.parseInt(id.getValue()), notes.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating notes");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating notes");
                        e1.printStackTrace();
                    }
                }
                if (!sex.isEmpty()) {
                    try {
                        data.updateSex(Integer.parseInt(id.getValue()), sex.getValue());
                    } catch (NumberFormatException e1) {
                        Notification.show("ERROR: NumberFormatException while updating sex.");
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        Notification.show("ERROR: SQLException while updating sex.");
                        e1.printStackTrace();
                    }
                }
            } else {
                Notification.show("The user's ID is empty");
            }

            refresh();
        });

        cancel.addClickListener(e -> {
            clearFields();
        });

        page.add(v1);
        body.setSizeFull();
        page.add(body);

        page.add(createTitle());
        page.add(new Paragraph(
                "Fill in the ID of the patient and make the necessary changes and the database will be updated. Only the edited fields will be updated."));
        page.add(createFormLayout());
        page.add(createButtonLayout());
        add(page);

    }

    private void clearFields() {
        id.clear();
        firstName.clear();
        lastName.clear();
        username.clear();
        password.clear();
        email.clear();
        dob.clear();
        phone.clear();
        address.clear();
        notes.clear();
        sex.clear();
    }

    private Component createTitle() {
        return new H3("Edit a patient:");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        email.setErrorMessage("Please enter a valid email address");
        formLayout.add(id, firstName, lastName, username, password, dob, sex, address, phone, email, notes);
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

    public void refresh() {
        Notification.show("Records Updated. Click on the green patients button to see your changes");
        clearFields();

    }

}
