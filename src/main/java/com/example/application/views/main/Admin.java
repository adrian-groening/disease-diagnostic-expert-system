package com.example.application.views.main;

import com.example.application.views.admin.patients.patients;

import java.sql.SQLException;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;

public class Admin extends Div {
    HorizontalLayout menu;
    VerticalLayout page;
    Button home, patients, logOut;

    patients pat;

    public Admin() throws SQLException {
        addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        pat = new patients();

        // page formatting
        page = new VerticalLayout();
        AuthWindow();

        // menu buttons
        home = new Button("Home");
        home.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        patients = new Button("Patients");
        patients.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
        logOut = new Button("Log Out");
        logOut.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);

        menu = new HorizontalLayout();
        menu.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

        menu.add(home, patients, logOut);

        home.addClickListener(e -> {
            AuthWindow();
        });

        patients.addClickListener(e -> {
            page.removeAll();
            try {
                page.add(new patients());
            } catch (SQLException e1) {
                Notification.show("ERROR: SQLException while opening patients.");
                e1.printStackTrace();
            }
        });

        logOut.addClickListener(e -> {
            try {
                removeAll();
                add(new Home());
            } catch (SQLException f) {
                f.printStackTrace();
            }
        });

        add(menu, page);
    }

    public void AuthWindow() {
        page.removeAll();
        VerticalLayout hme = new VerticalLayout();
        hme.addClassNames(AlignItems.CENTER, JustifyContent.START);
        H2 header = new H2("Welcome");
        hme.add(header);
        hme.add(new Paragraph(
                "In recent years, there has been a growing interest in the use of artificial intelligence (AI) in healthcare, particularly in the area of disease diagnosis. Expert systems are one type of AI-based software program that has been developed and used to aid in the diagnosis of various diseases. An expert system is a computer program that uses knowledge and inference techniques to solve complex problems that would typically require human expertise. These systems are designed to replicate the decision-making processes of a human expert in a particular domain."));
        hme.add(new Paragraph(
                "The potential benefits of expert systems for disease diagnosis are numerous. For instance, expert systems can improve the accuracy of diagnoses by leveraging machine learning, or more broadly, artificial intelligence to analyze a patient's symptoms and medical history. Studies have shown that expert systems can outperform human doctors in diagnosing certain conditions (Grover, 2019). In addition, expert systems can be accessed remotely, making them a convenient option for patients who may not have easy access to healthcare facilities (World Health Organization, 2018). This can help to reduce wait times for diagnosis and treatment, which is particularly important in cases where time is of the essence."));
        hme.add(new Paragraph(
                "Expert systems can also help to improve the efficiency of healthcare by reducing the need for expensive diagnostic tests. By providing accurate diagnoses, expert systems can help to eliminate unnecessary tests and procedures, ultimately lowering healthcare costs for patients and providers (Sturtz, 2021). This can be especially beneficial for patients who may not have access to affordable healthcare or for healthcare providers who are struggling with resource constraints."));
        hme.add(new Paragraph(
                "Despite the potential benefits of expert systems, there are also limitations to their use in disease diagnosis. For example, expert systems may not be able to take into account all the relevant factors that can impact a patient's diagnosis, such as social and environmental factors. Additionally, the accuracy of an expert system is heavily dependent on the quality of the data used to train it. Therefore, it is important to ensure that the data used to develop and train these systems is of high quality and that the systems are regularly updated and maintained."));
        page.add(hme);
    }

}
