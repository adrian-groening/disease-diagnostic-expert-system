package com.example.application.views.supportedconditions;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

public class SupportedDiseasesView extends Main implements HasComponents, HasStyle {
        private OrderedList imageContainer;

        public SupportedDiseasesView() {

                constructUI();

                imageContainer.add(new SupportedDiseasesViewCard("Influenza",
                                "images/flu(pexels-andrea-piacquadio).jpg", "Influenza", "",
                                "A contagious viral respiratory illness. It can lead to serious complications, especially in high-risk individuals such as young children, the elderly, and those with underlying health conditions.",
                                "Fever, Cough, Sore throat, Runny/stuffy nose, Body aches, Headache, Chills, Fatigue, Nausea/vomiting"));
                imageContainer.add(new SupportedDiseasesViewCard("Common Cold",
                                "images/commoncold(pexels-ivan-samkov).jpg", "Common Cold", "",
                                " A mild viral respiratory illness that can cause symptoms such as runny or stuffy nose, cough, sore throat, and mild body aches. It typically resolves on its own within a week to ten days. ",
                                "Runny/stuffy nose, Sore throat, Cough, Congestion, Sneezing, Fatigue, Headache, Body aches, Low-grade fever"));
                imageContainer.add(new SupportedDiseasesViewCard("Asthma",
                                "images/asthma(pexels-cottonbro-studio).jpg", "Asthma", "",
                                "A chronic respiratory condition that causes inflammation and narrowing of the airways, leading to symptoms such as wheezing, coughing, and shortness of breath. It can be triggered by various factors such as allergies, exercise, and respiratory infections.",
                                "Shortness of breath, Wheezing, Coughing, Chest tightness/pain, Difficulty breathing, Rapid breathing, Reduced exercise tolerance"));
                imageContainer.add(new SupportedDiseasesViewCard("Diabetes",
                                "images/diabetes(pexels-photomix-company).jpg", "Diabetes", "",
                                "A metabolic disorder characterized by high blood sugar levels resulting from the body's inability to produce or properly use insulin. It can lead to various complications such as heart disease, kidney disease, and nerve damage.",
                                "Frequent urination, Increased thirst/hunger, Fatigue, Blurred vision, Slow-healing wounds, Tingling/numbness in hands or feet, Dry mouth, Itchy skin"));
                imageContainer.add(new SupportedDiseasesViewCard("Hypertension (High blood pressure)",
                                "images/hbp(pexels-pavel-danilyuk).jpg", "Hypertension (HBP)", "",
                                "A condition in which the force of blood against the walls of the arteries is consistently high. High blood pressure can lead to heart disease, stroke, and other complications. Symptoms are usually not noticeable, but it can be detected by regular blood pressure checks.",
                                "Headaches, Shortness of breath, Nosebleeds, Dizziness, Chest pain, Fatigue, Irregular heartbeat, Vision problems"));
                imageContainer.add(new SupportedDiseasesViewCard("Hypertension (Underactive thyroid)",
                                "images/underactivethyroid(chart attack).jpg", "Underactive Thyroid", "",
                                "A condition where the thyroid gland does not produce enough thyroid hormone. Symptoms include weight gain, fatigue, constipation, dry skin, and cold intolerance.",
                                "Fatigue, Weight gain, Cold intolerance, Constipation, Dry skin, Hair loss, Weakness, Joint pain, Muscle stiffness/cramps, Depression"));
                imageContainer.add(new SupportedDiseasesViewCard("Hypertension (Overactive thyroid)",
                                "images/overactivethyroid(telemedi).jpg", "Overactive Thyroid", "",
                                "A condition where the thyroid gland produces too much thyroid hormone. Symptoms include weight loss, rapid heartbeat, sweating, anxiety, and tremors.",
                                "Weight loss, Increased appetite, Rapid heartbeat, Anxiety, Tremors, Sweating, Heat intolerance, Difficulty sleeping"));
                imageContainer.add(new SupportedDiseasesViewCard("Migraines",
                                "images/migraine(pexels-andrea-piacquadio).jpg", "Migraines", "",
                                "A type of headache characterized by intense pain on one side of the head, often accompanied by nausea, vomiting, and sensitivity to light and sound. ",
                                "Throbbing/pulsing pain on one side of the head, Sensitivity to light/sound/smell, Nausea/vomiting, Blurred vision, Light-headedness, Fatigue, Mood changes, Neck pain/stiffness"));
                imageContainer.add(new SupportedDiseasesViewCard("Pneumonia",
                                "images/pneumonia(pexels-klaus-nielsen).jpg", "Pneumonia", "",
                                "An infection that inflames the air sacs in one or both lungs, causing them to fill with fluid or pus. Symptoms include cough, fever, chills, shortness of breath, chest pain, and fatigue.",
                                "Cough (may produce phlegm), Fever, Sweating, Shaking chills, Shortness of breath, Rapid breathing, Chest pain (worsens with deep breathing or coughing), Headache, Fatigue, Muscle aches"));
                imageContainer.add(new SupportedDiseasesViewCard("Urinary Tract Infection (UTI)",
                                "images/uti(pexels-sora-shimazaki).jpg", "Urinary Tract Infection (UTI)", "",
                                "An infection in any part of the urinary system, including the kidneys, bladder, ureters, and urethra. Symptoms include pain or burning during urination, frequent urination, cloudy or bloody urine, and strong-smelling urine.",
                                "Strong/persistent urge to urinate, Burning sensation when urinating, Passing frequent/small amounts of urine, Cloudy/strong-smelling urine, Blood in the urine, Pain/pressure in lower abdomen or back, Fatigue, Fever/chills (if infection has spread to kidneys)"));
        }

        private void constructUI() {
                addClassNames("supported-diseases-view");
                addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE,
                                Padding.Horizontal.LARGE);

                HorizontalLayout container = new HorizontalLayout();
                container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

                VerticalLayout headerContainer = new VerticalLayout();
                headerContainer.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);
                H2 header = new H2("Supported Diseases");
                Paragraph description = new Paragraph("Diseases that the expert system can detect");
                headerContainer.add(header, description);

                imageContainer = new OrderedList();
                imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

                container.add(headerContainer);
                add(container, imageContainer);

        }
}
