package com.example.application.views.main;

import java.sql.SQLException;

import com.example.application.views.login.login;
import com.example.application.views.signup.signup;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Diagnosticate.Me")
@Route(value = "")
public class Home extends Div {

    private Button su;
    private Button li;

    public Home() throws SQLException {

        Paragraph disclaimer = new Paragraph(
                "DISCLAIMER: App may fail due to unexpected traffic.");

        VerticalLayout page = new VerticalLayout();
        page.addClassNames(AlignItems.CENTER, JustifyContent.START);

        VerticalLayout buttons = new VerticalLayout();
        buttons.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

        Image logo = new Image("images/logo.png", "Logo");
        logo.setWidth("300px");

        page.add(logo);
        page.add(disclaimer);

        page.add(new Paragraph(
                "In recent years, there has been a growing interest in the use of artificial intelligence (AI) in healthcare, particularly in the area of disease diagnosis. Expert systems are one type of AI-based software program that has been developed and used to aid in the diagnosis of various diseases. An expert system is a computer program that uses knowledge and inference techniques to solve complex problems that would typically require human expertise. These systems are designed to replicate the decision-making processes of a human expert in a particular domain."));
        page.add(new Paragraph(
                "The potential benefits of expert systems for disease diagnosis are numerous. For instance, expert systems can improve the accuracy of diagnoses by leveraging machine learning, or more broadly, artificial intelligence to analyze a patient's symptoms and medical history. Studies have shown that expert systems can outperform human doctors in diagnosing certain conditions (Grover, 2019). In addition, expert systems can be accessed remotely, making them a convenient option for patients who may not have easy access to healthcare facilities (World Health Organization, 2018). This can help to reduce wait times for diagnosis and treatment, which is particularly important in cases where time is of the essence."));
        page.add(new Paragraph(
                "Expert systems can also help to improve the efficiency of healthcare by reducing the need for expensive diagnostic tests. By providing accurate diagnoses, expert systems can help to eliminate unnecessary tests and procedures, ultimately lowering healthcare costs for patients and providers (Sturtz, 2021). This can be especially beneficial for patients who may not have access to affordable healthcare or for healthcare providers who are struggling with resource constraints."));
        page.add(new Paragraph(
                "Despite the potential benefits of expert systems, there are also limitations to their use in disease diagnosis. For example, expert systems may not be able to take into account all the relevant factors that can impact a patient's diagnosis, such as social and environmental factors. Additionally, the accuracy of an expert system is heavily dependent on the quality of the data used to train it."));
        add(page);

        su = new Button("Sign Up");
        li = new Button("Log In");

        su.addClickListener(e -> {
            try {
                openSU();
            } catch (SQLException e1) {
                Notification.show("ERROR: SQLException while opening sign up view.");
                e1.printStackTrace();
            }
        });

        li.addClickListener(e -> {
            try {
                openLI();
            } catch (SQLException e1) {
                Notification.show("ERROR: SQLException while opening log in view.");
                e1.printStackTrace();
            }
        });

        su.setSizeFull();
        li.setSizeFull();
        buttons.add(su, li);

        add(buttons);

    }

    public void openSU() throws SQLException {
        removeAll();
        add(new signup());
    }

    public void openLI() throws SQLException {
        removeAll();
        add(new login());
    }

    public Home removeButtons() throws SQLException {
        Home a = new Home();
        a.remove(su, li);
        return a;
    }

}
