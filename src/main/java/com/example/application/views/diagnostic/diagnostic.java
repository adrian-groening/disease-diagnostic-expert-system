package com.example.application.views.diagnostic;

import java.sql.SQLException;

import com.example.application.services.DatabaseOBJ;
import com.example.application.views.core.Scoreboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class diagnostic extends Div {

    Scoreboard score;
    DatabaseOBJ data;
    H2 dgsc = new H2("Diagnostic");
    Paragraph p1 = new Paragraph(
            "The disease diagnostic expert system will be a software program designed to aid healthcare professionals in the accurate and efficient diagnosis of various diseases.");
    Paragraph p2 = new Paragraph(
            "The system will leverage machine learning and artificial intelligence to analyze a patient's symptoms and medical history and provide a diagnosis. The objectives of the system are to:");
    Paragraph p3 = new Paragraph("-	Improve the accuracy and speed of disease diagnosis.");
    Paragraph p4 = new Paragraph("-	Reduce the potential for medical errors during the diagnostic process.");
    Paragraph p5 = new Paragraph(
            "-	Reduce the workload of healthcare professionals by automating parts of the diagnostic process.");
    Paragraph p6 = new Paragraph("-	Reduce the need for expensive diagnostic tests and procedures.");
    Paragraph p7 = new Paragraph("-	Increase access to healthcare by allowing for remote diagnosis.");
    Paragraph p8 = new Paragraph("-	Enhance the overall efficiency of healthcare.");
    Paragraph p9 = new Paragraph(
            "The system will be designed to take into account a variety of factors, such as patient demographics, medical history, and symptoms, to arrive at an accurate diagnosis. It will be designed to provide recommendations to healthcare professionals, who will ultimately be responsible for making the final diagnosis and treatment decisions. The scope of the system will be limited to the diagnostic process, and will not be responsible for the treatment or management of diseases. The system will be designed to work in conjunction with existing healthcare technologies and practices, and will be compliant with applicable healthcare regulations and standards.");

    TextArea textArea = new TextArea();

    HorizontalLayout s = new HorizontalLayout();

    HorizontalLayout l = new HorizontalLayout();

    HorizontalLayout buttons = new HorizontalLayout();

    VerticalLayout page = new VerticalLayout();

    VerticalLayout page1 = new VerticalLayout();

    VerticalLayout head = new VerticalLayout();

    Button generate = new Button("Generate");

    private int userID;

    Random rand;

    public diagnostic(int id) throws SQLException {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(date);

        rand = new Random();

        userID = id;

        addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        add(head);

        head.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);
        head.add(dgsc);

        textArea.setWidthFull();
        textArea.setLabel("Diagnostic");
        textArea.setHeightFull();

        data = new DatabaseOBJ();

        s.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

        l.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

        buttons.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

        page.addClassNames(AlignItems.CENTER, JustifyContent.START);

        page.addClassNames(AlignItems.CENTER, JustifyContent.START);

        // symptoms heading
        H2 sym = new H2("Symptom Selection");
        s.add(sym);

        // symptoms checkboxes
        CheckboxGroup<String> ss = new CheckboxGroup<>();
        ss.setLabel("Please select the symptoms that you are experiencing");
        ss.setItems("Fever", "Cough", "Sore throat", "Runny nose", "Body aches", "Headache", "Chills", "Fatigue",
                "Vomitting", "Congestion", "Sneezing", "Shortness of breath", "Wheezing", "Chest pain",
                "Difficulty breathing", "Rapid breathing", "Reduced exercise tolerance", "Frequent urination",
                "Increased hunger", "Vision problems", "Slow healing wounds", "Numbness in hands or feet", "Dry mouth",
                "Itchy skin", "Nosebleeds", "Dizziness", "Irregular heartbeat");
        ss.addThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD);
        ss.setRequired(true);
        ss.setWidthFull();
        page.add(ss);

        // lifestyle habits heading
        H2 lyf = new H2("Lifestyle Habits Selection");
        l.add(lyf);

        // lifestyle habits checkbox
        CheckboxGroup<String> lh = new CheckboxGroup<>();
        lh.setLabel("Please select the lifestyle habits that you take part in");
        lh.setItems("Lack of sleep", "Stress", "Smoking", "Poor diet", "Lack of exercise", "Exposure to air pollution",
                "Poor indoor air quality", "Obesity", "Excessive alcohol consumption");
        lh.addThemeVariants(CheckboxGroupVariant.LUMO_HELPER_ABOVE_FIELD);
        lh.setRequired(false);
        page1.add(lh);

        // buttons
        Button generate = new Button("Generate");

        add(p1, p2, p3, p4, p5, p6, p7, p8, p9);
        add(s, page, l, page1);
        buttons.add(generate);
        add(buttons);
        add(textArea);

        generate.addClickListener(ea -> {

            score = new Scoreboard();

            String symptoms = "";
            String lifestylehabits = "";

            if (ss.getValue().isEmpty()) {
                Notification.show("Please select symptoms");
            } else {

                if (ss.getValue().contains("Fever")) {
                    symptoms += " [Fever] ";
                    score.plusFlu();
                    score.plusCC();
                }

                if (ss.getValue().contains("Cough")) {
                    symptoms += " [Cough] ";
                    score.plusFlu();
                    score.plusCC();
                    score.plusAsthma();

                }

                if (ss.getValue().contains("Sore throat")) {
                    symptoms += " [Sore throat] ";
                    score.plusFlu();
                    score.plusCC();
                }

                if (ss.getValue().contains("Runny nose")) {
                    symptoms += " [Runny nose] ";
                    score.plusFlu();
                    score.plusCC();
                }

                if (ss.getValue().contains("Body aches")) {
                    symptoms += " [Body aches] ";
                    score.plusFlu();
                    score.plusCC();
                }

                if (ss.getValue().contains("Headache")) {
                    symptoms += " [Headache] ";
                    score.plusFlu();
                    score.plusCC();
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Chills")) {
                    symptoms += " [Chills] ";
                    score.plusFlu();
                }

                if (ss.getValue().contains("Fatigue")) {
                    symptoms += " [Fatigue] ";
                    score.plusFlu();
                    score.plusCC();
                    score.plusDiabetes();
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Vomitting")) {
                    symptoms += " [Vomitting] ";
                    score.plusFlu();
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Congestion")) {
                    symptoms += " [Congestion] ";
                    score.plusCC();
                }

                if (ss.getValue().contains("Sneezing")) {
                    symptoms += " [Sneezing] ";
                    score.plusCC();
                }

                if (ss.getValue().contains("Shortness of breath")) {
                    symptoms += " [Shortness of breath] ";
                    score.plusAsthma();
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Wheezing")) {
                    symptoms += " [Wheezing] ";
                    score.plusAsthma();
                }

                if (ss.getValue().contains("Chest pain")) {
                    symptoms += " [Chest pain] ";
                    score.plusAsthma();
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Difficulty breathing")) {
                    symptoms += " [Difficulty breathing] ";
                    score.plusAsthma();
                }

                if (ss.getValue().contains("Rapid breathing")) {
                    symptoms += " [Rapid breathing] ";
                    score.plusAsthma();
                }

                if (ss.getValue().contains("Reduced exercise tolerance")) {
                    symptoms += " [Reduced exercise tolerance] ";
                    score.plusAsthma();
                }

                if (ss.getValue().contains("Frequent urination")) {
                    symptoms += " [Frequent urination] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Increased hunger")) {
                    symptoms += " [Increased hunger] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Vision Problems")) {
                    symptoms += " [Vision Problems] ";
                    score.plusDiabetes();
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Slow healing wounds")) {
                    symptoms += " [Slow healing wounds] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Numbness in hands or feet")) {
                    symptoms += " [Numbness in hands or feet] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Dry mouth")) {
                    symptoms += " [Dry mouth] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Itchy skin")) {
                    symptoms += " [Itchy skin] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Nosebleeds")) {
                    symptoms += " [Nosebleeds] ";
                    score.plusDiabetes();
                }

                if (ss.getValue().contains("Dizziness")) {
                    symptoms += " [Dizziness] ";
                    score.plusHypertension();
                }

                if (ss.getValue().contains("Irregular heartbeat")) {
                    symptoms += " [Irregular heartbeat] ";
                    score.plusHypertension();
                }

                if (!lh.getValue().isEmpty()) {

                    if (lh.getValue().contains("Lack of sleep")) {
                        lifestylehabits += " [Lack of sleep] ";
                        score.plusFlu();
                        score.plusCC();
                    }

                    if (lh.getValue().contains("Stress")) {
                        lifestylehabits += " [Stress] ";
                        score.plusFlu();
                        score.plusCC();
                        score.plusAsthma();
                        score.plusHypertension();
                    }

                    if (lh.getValue().contains("Smoking")) {
                        lifestylehabits += " [Smoking] ";
                        score.plusFlu();
                        score.plusCC();
                        score.plusAsthma();
                        score.plusDiabetes();
                        score.plusHypertension();
                    }

                    if (lh.getValue().contains("Poor diet")) {
                        lifestylehabits += " [Poor diet] ";
                        score.plusFlu();
                        score.plusCC();
                        score.plusAsthma();
                        score.plusDiabetes();
                        score.plusHypertension();
                    }

                    if (lh.getValue().contains("Lack of exercise")) {
                        lifestylehabits += " [Lack of exercise] ";
                        score.plusFlu();
                        score.plusCC();
                        score.plusAsthma();
                        score.plusDiabetes();
                        score.plusHypertension();
                    }

                    if (lh.getValue().contains("Exposure to air pollution")) {
                        lifestylehabits += " [Exposure to air pollution] ";
                        score.plusAsthma();
                    }

                    if (lh.getValue().contains("Poor indoor air quality")) {
                        lifestylehabits += " [Poor indoor air quality] ";
                        score.plusAsthma();
                    }

                    if (lh.getValue().contains("Obesity")) {
                        lifestylehabits += " [Obesity] ";
                        score.plusDiabetes();
                        score.plusHypertension();
                    }

                    if (lh.getValue().contains("Excessive alcohol consumption")) {
                        lifestylehabits += " [Excessive alcohol consumption] ";
                        score.plusDiabetes();
                        score.plusHypertension();

                    }

                    // counting medial history
                    String mH = "";
                    try {
                        mH = data.getMedialHistory(userID);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting user medical history.");
                        e.printStackTrace();
                    }

                    if (mH.equals("Influenza")) {
                        for (int i = 0; i < 5; i++) {
                            score.plusFlu();
                        }
                    } else if (mH.equals("Common Cold")) {
                        for (int i = 0; i < 5; i++) {
                            score.plusCC();
                        }
                    } else if (mH.equals("Asthma")) {
                        for (int i = 0; i < 5; i++) {
                            score.plusAsthma();
                        }
                    } else if (mH.equals("Diabetes")) {
                        for (int i = 0; i < 5; i++) {
                            score.plusDiabetes();
                        }
                    } else if (mH.equals("Hypertension")) {
                        for (int i = 0; i < 5; i++) {
                            score.plusHypertension();
                        }
                    }

                }

                String viewSymptoms = symptoms;
                String viewLH = lifestylehabits;
                String diseasedesc = "";

                if (score.getWinner().contains("Flu")) {
                    try {
                        diseasedesc = data.getFluInfo();
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting flu.");
                    }
                } else if (score.getWinner().contains("Common Cold")) {
                    try {
                        diseasedesc = data.getCCInfo();
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting common cold.");
                    }
                } else if (score.getWinner().contains("Asthma")) {
                    try {
                        diseasedesc = data.getAsthmaInfo();
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting asthma.");
                    }
                } else if (score.getWinner().contains("Diabetes")) {
                    try {
                        diseasedesc = data.getDiabetesInfo();
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting diabtetes.");
                    }
                } else if (score.getWinner().contains("Hypertension")) {
                    try {
                        diseasedesc = data.getHypertensionInfo();
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while getting hypertension.");
                    }
                }

                // fetching user info
                String fn = "";
                String sn = "";
                String un = "";
                String dob = "";
                String sx = "";
                String addy = "";
                String pn = "";
                String email = "";
                String not = "";

                try {
                    fn = data.getFirstName(userID);
                    sn = data.getSurname(userID);
                    un = data.getUsername(userID);
                    dob = data.getDOB(userID);
                    sx = data.getSex(userID);
                    addy = data.getAddress(userID);
                    pn = data.getPhone(userID);
                    email = data.getEmail(userID);
                    not = data.getNotes(userID);
                } catch (SQLException e) {
                    Notification.show("ERROR: SQLException while fetching user info.");
                    e.printStackTrace();
                }

                textArea.setReadOnly(true);
                // setting diagnostic text area
                textArea.setValue("\nName: " + fn + " " + sn + "\nUsername: " + un + "\nDate of Birth: " + dob +
                        "\nSex: " + sx + "\nAddress: " + addy + "\nPhone: " + pn + "\nEmail: " + email +
                        "\nExtra: " + not + "\n\nDiagnosed Disease: " + score.getWinner() + "\nSymptoms: " +
                        viewSymptoms + "\nLifestyle Habits: " + viewLH + "\n\n\nDisease Tally: " + "\nFlu: "
                        + score.getFlu() + "\nCommon Cold: " + score.getCC() + "\nAsthma: " +
                        score.getAsthma() + "\nHypertension: " + score.getHypertension() + "\nDiabetes: "
                        + score.getdiabetes() + "\n" + diseasedesc);

                int diagnosticID = rand.nextInt();

                if (score.getWinner().contains("Flu")) {
                    try {
                        data.insertDiagnostic(diagnosticID, strDate, textArea.getValue(), userID, 1);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while inserting diagnostic");
                    }
                } else if (score.getWinner().contains("Common Cold")) {
                    try {
                        data.insertDiagnostic(diagnosticID, strDate, textArea.getValue(), userID, 2);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while inserting diagnostic");
                    }
                } else if (score.getWinner().contains("Asthma")) {
                    try {
                        data.insertDiagnostic(diagnosticID, strDate, textArea.getValue(), userID, 3);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while inserting diagnostic");
                    }
                } else if (score.getWinner().contains("Diabetes")) {
                    try {
                        data.insertDiagnostic(diagnosticID, strDate, textArea.getValue(), userID, 4);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while inserting diagnostic");
                    }
                } else if (score.getWinner().contains("Hypertension")) {
                    try {
                        data.insertDiagnostic(diagnosticID, strDate, textArea.getValue(), userID, 5);
                    } catch (SQLException e) {
                        Notification.show("ERROR: SQLException while inserting diagnostic");
                    }
                }

                Notification.show("Winner: " + score.getWinner());

            }

            ss.clear();
            lh.clear();

        });

    }

    public void addAll() {
        add(p1, p2, p3, p4, p5, p6, p7, p8, p9);
        add(s, page, l, page1);
        buttons.add(generate);
        add(buttons);
        add(textArea);
    }

}
