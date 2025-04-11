package com.example.application.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.example.application.views.supportedconditions.SupportedDiseasesView;
import java.sql.SQLException;
import com.example.application.views.about.about;
import com.example.application.views.diagnostic.ViewDiagnostic;
import com.example.application.views.diagnostic.diagnostic;

public class Authenticated extends Div {

        HorizontalLayout menu, menu2;
        VerticalLayout page;
        Button home, about, diagnostic, logOut, supportedConditions, view;

        // logged user reference;
        private int userID;

        public Authenticated(int id) throws SQLException {

                // initialization of the reference to the logged user
                userID = id;
                addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

                // page formatting
                page = new VerticalLayout();
                AuthWindow();

                // menu buttons
                home = new Button("Home");
                home.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
                home.setSizeUndefined();
                about = new Button("About");
                about.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
                about.setSizeUndefined();
                diagnostic = new Button("Generate Diagnostic");
                diagnostic.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
                diagnostic.setSizeUndefined();
                supportedConditions = new Button("Supported Conditions");
                supportedConditions.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
                supportedConditions.setSizeUndefined();
                view = new Button("View Diagnostics");
                view.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
                view.setSizeUndefined();
                logOut = new Button("Log Out");
                logOut.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
                logOut.setSizeUndefined();

                menu = new HorizontalLayout();
                menu.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);
                menu2 = new HorizontalLayout();
                menu2.addClassNames(AlignItems.CENTER, JustifyContent.CENTER);

                menu.add(home, about, diagnostic);
                menu2.add(supportedConditions, view, logOut);

                home.addClickListener(e -> {
                        AuthWindow();
                });

                about.addClickListener(e -> {
                        page.removeAll();
                        page.add(new about());
                });

                diagnostic.addClickListener(e -> {
                        try {
                                page.removeAll();
                                page.add(new diagnostic(userID));
                        } catch (SQLException e1) {
                                Notification.show("ERROR: SQLException while opening diagnsotic view.");
                                e1.printStackTrace();
                        }
                });

                supportedConditions.addClickListener(e -> {
                        page.removeAll();
                        page.add(new SupportedDiseasesView());
                });

                view.addClickListener(e -> {

                        try {
                                page.removeAll();
                                page.add(new ViewDiagnostic(userID));
                        } catch (SQLException e1) {
                                Notification.show("ERROR: SQLException while opening the view diagnostic view.");
                                e1.printStackTrace();
                        }
                });

                logOut.addClickListener(e -> {
                        try {
                                removeAll();
                                add(new Home());
                        } catch (SQLException f) {
                                Notification.show("ERROR: SQLException while opening home.");
                                f.printStackTrace();
                        }
                });

                about.addClickListener(e -> {
                        page.removeAll();
                        page.add(new about());
                });

                add(menu, menu2, page);
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

                H2 method = new H2("Methodology");
                hme.add(method);
                hme.add(new Paragraph(
                                "The path for developing the disease diagnostic expert system web application followed the Rapid Application Development (RAD) methodology. Rapid Application Development (RAD) is a software development methodology that emphasizes rapid prototyping and iterative development. The primary objective of RAD is to reduce the time and cost involved in software development by focusing on delivering working software quickly and responding to change rapidly."));
                hme.add(new Paragraph(
                                "RAD is suitable for projects that have well-defined requirements and a limited scope. It is often used for developing small to medium-sized applications where the requirements may change frequently or are not fully understood at the outset of the project. The RAD methodology involves the following phases:"));
                hme.add(new Paragraph(
                                "1.	Requirements Planning: In this phase, the project requirements are gathered from the stakeholders and documented. The scope, objectives, and deliverables of the project are defined, and a project plan is created."));
                hme.add(new Paragraph(
                                "2.	User Design: The focus of this phase is to design the user interface and user experience (UI/UX) of the application. User research is conducted to understand user needs and preferences. User personas, scenarios, and stories are developed to guide the design process."));
                hme.add(new Paragraph(
                                "3.	Rapid Prototyping: In this phase, a functional prototype of the application is developed using a tool or platform that allows for rapid prototyping. The prototype is tested with users, and feedback is collected to refine the design. This process is repeated until the prototype meets the user's needs and requirements."));
                hme.add(new Paragraph(
                                "4.	Construction and Cutover: The final version of the application is developed and tested. The software is then implemented in a production environment, and end-users are trained and supported. The application is launched, and ongoing support is provided."));
                hme.add(new Paragraph(
                                "RAD is beneficial because it allows developers to deliver working software quickly and respond to change rapidly. It also encourages collaboration between developers and users, resulting in a better understanding of user needs and requirements. RAD can lead to reduced project costs, as less time is spent on documentation and more time is spent on developing working software."));
                hme.add(new Paragraph(
                                "However, RAD may not be suitable for projects with complex requirements or a large scope. The focus on rapid development may result in a lack of attention to detail, leading to issues later in the development process. Additionally, the iterative nature of RAD may result in scope creep, where the project scope expands beyond the original requirements."));
                hme.add(new Paragraph(
                                "In conclusion, the RAD methodology is a useful approach to software development that emphasizes rapid prototyping and iterative development. It can be beneficial for small to medium-sized projects with well-defined requirements and a limited scope. RAD can result in reduced project costs and improved collaboration between developers and users. However, it may not be suitable for large or complex projects and may lead to scope creep if not managed properly."));
                hme.add(new Paragraph(
                                "This approach allows for rapid prototyping, iterative development, and quick adaptation to changing requirements. The RAD methodology will enable the team to deliver a functional product in a short amount of time, while still ensuring that the application meets the needs of the end-users."));

                Image rad = new Image("images/rad.png", "RAD");
                rad.setWidth("500px");
                hme.add(rad);

                H2 feasibility = new H2("Feasibility");
                hme.add(feasibility);

                hme.add(new Paragraph(
                                "Technical Feasibility: The technical feasibility of the project refers to the technical resources required to develop the system, such as hardware, software, and development skills. The development of the system using the Vaadin framework is technically feasible as Vaadin provides an extensive set of tools and libraries for developing web applications. Vaadin also allows for the creation of custom user interface components and data visualization tools, which are necessary for a system like this. Additionally, the system's hardware and software requirements must be identified to ensure that the system can operate efficiently and handle a large volume of user requests and data processing. Along with the Vaadin framework, the system can be fully implemented and deployed using Heroku, for web hosting, namecheap, providing the domain name www.diagnosticate.me, Visual Studio Code, for offline coding, Codespaces, for online, and GitHub."));
                hme.add(new Paragraph(
                                "Economic Feasibility: The economic feasibility of the project refers to the resources required to develop and maintain the system, as well as the expected benefits of the system. Developing a disease diagnostic expert system web application can be expensive, depending on the scope and complexity of the system. It is essential to perform a cost-benefit analysis to determine the financial feasibility of the project. The cost-benefit analysis should consider the potential benefits of the system, such as improved healthcare outcomes and reduced healthcare costs. Additionally, the analysis should take into account the ongoing costs associated with system maintenance and updates. In this case, with the help of the GitHub student developer pack, all the resources that will be used in this project will be free so the benefits will outweigh the costs."));
                hme.add(new Paragraph(
                                "Organizational Feasibility: The organizational feasibility of the project refers to the compatibility of the system in an organization's goals, objectives, and culture. It is essential to ensure that the system aligns with the organization's mission and values. The development of the system should also be coordinated with relevant stakeholders, including healthcare professionals and IT staff, to ensure that the system meets their needs and requirements. The system should also be designed with user-friendly interfaces and clear instructions to ensure that users can easily navigate and utilize the system. Finally, it is essential to consider the training and support necessary to ensure that users can effectively use the system."));
                hme.add(new Paragraph(
                                "The client-side hardware requirements will depend on the preferred browser of the user. For example, chrome requires that users have the following hardware specs for its 19th edition browser: Operating System: Windows (Windows Vista, Windows 7 and up), Linux (Ubuntu 10.4, Debian 6, or Fedora 14 or newer), and Mac (OS X 10.5.6 or later); Processor: Windows (Intel Pentium 4 or better), Mac (Intel), and Linux (Intel Pentium 3 or later); Memory: 128MB RAM; Disk: 100MB"));
                H2 ptf = new H2("Projecet Timeframe:");
                hme.add(ptf);
                hme.add(new Paragraph("Start Date: January 1st, 2023"));
                hme.add(new Paragraph("End Date: April 16th, 2023"));

                Image pgc = new Image("images/pgc.png", "PGC");
                pgc.setWidth("500px");
                hme.add(pgc);

                hme.add(new Paragraph(
                                "Phase 1: Requirements Planning (January 1st to January 14th): Meet with stakeholders (doctors, medical experts) to gather and document project requirements: Identify the diseases that the system will be able to diagnose, symptoms, risk factors, and diagnostic criteria for each disease; Define the scope and objectives of the project; Create a project plan; Conduct user research to understand user needs and preferences"));
                hme.add(new Paragraph(
                                "Phase 2: User Design (January 15th to February 14th): Develop use cases for users; Create UI/UX design for the web application"));
                hme.add(new Paragraph(
                                "Phase 3: Rapid Prototyping (February 15th to March 15th): Develop a functional prototype of the web application; Implement a rule-based diagnostic engine that takes in the symptoms and risk factors from the patient and provides a diagnostic output; Conduct user testing to evaluate the usability of the prototype; Refine the prototype; Conduct alpha testing to identify and fix bugs; Prepare documentation for the web application"));
                hme.add(new Paragraph(
                                "Phase 4: Construction and Cutover (March 16th to April 16th): Develop the final version of the web application; Develop a secure login system for users; Conduct beta testing; Address any issues or bugs identified during beta testing; Launch the web application and provide ongoing support"));

                H2 req = new H2("Requirements Specification ");
                hme.add(req);
                hme.add(new Paragraph(
                                "The disease diagnostic expert system web application is an interactive software tool that will help patients diagnose diseases themselves based on symptoms and other patient information. This application was developed using the Vaadin framework, which is an open-source web application framework that enables developers to build modern web applications."));
                hme.add(new Paragraph(
                                "1.	User Requirements - The disease diagnostic expert system web application must fulfil the following user requirements:"));
                hme.add(new Paragraph(
                                "-	The application should allow patients to input patient information, including symptoms, medical history and lifestyle habits."));
                hme.add(new Paragraph(
                                "-	The application should provide potential diseases based on the patient information entered."));
                hme.add(new Paragraph(
                                "-	The application should provide information on each potential disease, including symptoms, causes, and treatments."));
                hme.add(new Paragraph(
                                "-	The application should allow patients to refine the diagnosis by adding or removing symptoms and medical history."));
                hme.add(new Paragraph(
                                "-	The application should provide a final diagnosis based on the refined patient information."));
                hme.add(new Paragraph(
                                "2.	Technical Requirements - The disease diagnostic expert system web application must fulfil the following technical requirements:"));
                hme.add(new Paragraph("-	The application will be developed using the Vaadin framework."));
                hme.add(new Paragraph(
                                "-	The application must be compatible with the latest versions of popular web browsers, including Chrome, Firefox, and Safari."));
                hme.add(new Paragraph(
                                "-	The application must be hosted on a web server that is secure and can handle high levels of traffic."));
                hme.add(new Paragraph(
                                "-	The application must have a responsive design that is optimized for use on desktop and mobile devices."));
                hme.add(new Paragraph(
                                "-	The application must be integrated with a database to store patient information and diagnosis history."));
                hme.add(new Paragraph(
                                "3.	Functional Requirements - The disease diagnostic expert system web application must fulfil the following functional requirements:"));
                hme.add(new Paragraph(
                                "-	The application must allow patients to register for an account and login to the application."));
                hme.add(new Paragraph(
                                "-	The application must provide a user-friendly interface for entering patient information, including symptoms and medical history."));
                hme.add(new Paragraph(
                                "-	The application must provide a list of potential diseases based on the patient information entered."));
                hme.add(new Paragraph(
                                "-	The application must provide information on each potential disease, including symptoms and causes."));
                hme.add(new Paragraph(
                                "-	The application must provide a final diagnosis based on the refined patient information."));
                hme.add(new Paragraph(
                                "-	The application must allow users to save patient information and diagnosis history for future reference."));
                hme.add(new Paragraph(
                                "-	The application must provide a user-friendly interface for managing patient information."));
                hme.add(new Paragraph(
                                "4.	Non-functional Requirements - The disease diagnostic expert system web application must fulfill the following non-functional requirements:"));
                hme.add(new Paragraph(
                                "-	The application must be reliable and available 24/7, with minimal downtime for maintenance."));
                hme.add(new Paragraph(
                                "-	The application must be fast and responsive, with quick load times and minimal lag."));
                hme.add(new Paragraph(
                                "-	The application must be easy to use and intuitive, with clear instructions and error messages."));
                hme.add(new Paragraph(
                                "The disease diagnostic expert system web application will be deemed acceptable if it fulfils the following acceptance criteria:"));
                hme.add(new Paragraph(
                                "-	The application allows users to register for an account and login to the application."));
                hme.add(new Paragraph(
                                "-	The application provides a user-friendly interface for entering patient information, including symptoms and medical history."));
                hme.add(new Paragraph(
                                "-	The application uses a decision tree or other logic to reach a patient diagnostic."));
                hme.add(new Paragraph("-	The application can be accessed online."));
                hme.add(new Paragraph("-	The application can display information from an earlier date."));

                H2 data = new H2("Data Storage ");
                hme.add(data);

                Image erd = new Image("images/erd.png", "ERD");
                erd.setWidth("500px");
                hme.add(erd);

                hme.add(new Paragraph(
                                "The database schema is designed to hold information about users, which can be either admin or patient, patient medical history, the generated diagnostic, diseases, diseases and their relation to symptoms and lifestyle habits."));
                hme.add(new Paragraph(
                                "-	The 'user' table is the main table and contains information about all patients of the system. It includes fields such as userID, role, username, password, firstname, and surname. "));
                hme.add(new Paragraph(
                                "-	The 'MedicalHistory' table is used to store information about a patient's medical history, including their medical ID and any related data."));
                hme.add(new Paragraph(
                                "-	The 'Diagnostics' table contains information about a patient's diagnostics, including the diagnostic ID, patient ID, life ID, disease ID, date, and description."));
                hme.add(new Paragraph(
                                "-	The 'Disease' table contains information about specific diseases, such as the disease ID, name, and description, its related symptoms and lifestyle habits."));

                hme.add(new Paragraph("Data Logic: "));

                Image dfd1 = new Image("images/condfd.png", "Context Level");
                dfd1.setWidth("500px");
                hme.add(dfd1);
                Image dfd2 = new Image("images/0dfd.png", "Level 1");
                dfd2.setWidth("500px");
                hme.add(dfd2);

                hme.add(new Paragraph("Logging in:"));
                Image loginprocess = new Image("images/login.png", "Log In");
                loginprocess.setWidth("500px");
                hme.add(loginprocess);

                hme.add(new Paragraph("Signing Up:"));
                Image signupprocess = new Image("images/signup.png", "Sign Up");
                signupprocess.setWidth("500px");
                hme.add(signupprocess);

                hme.add(new Paragraph("Generating a Diagnostic:"));
                Image generate = new Image("images/generate.png", "Generate");
                generate.setWidth("500px");
                hme.add(generate);

                hme.add(new Paragraph("Viewing Diagnostic"));
                Image view = new Image("images/view.png", "View");
                view.setWidth("500px");
                hme.add(view);

                hme.add(new Paragraph("Managing Patients"));
                Image manage = new Image("images/manage.png", "Manage");
                manage.setWidth("500px");

                hme.add(manage);

                H2 arch = new H2("System Architecture ");
                hme.add(arch);

                Image archi = new Image("images/architecture.png", "Sys Arch");
                archi.setWidth("500px");
                hme.add(archi);

                hme.add(new Paragraph(
                                "1.	Presentation Layer (Client-Side): The client-side or presentation tier is responsible for presenting the user interface to the end-users. It consists of the user interface components and handles user input, such as mouse clicks, keyboard inputs, and form submissions. It communicates with the application tier through APIs and web services. The presentation has been built using modern web technologies such as HTML, CSS, JavaScript, using the Vaadin framework."));
                hme.add(new Paragraph(
                                "2.	Application Layer (Server-Side): The application tier or server-side is responsible for managing the business logic of the system. It contains the application code and data access layer. It handles user requests, processes data, and communicates with the data tier. It contains the diagnostic engine which uses rules and algorithms to determine the possible diagnosis for the given set of symptoms. The application tier can be built using server-side technologies such as Java, Spring, and Vaadin."));
                hme.add(new Paragraph(
                                "3.	Data Layer (Database): The data tier or database is responsible for managing the data used by the system. It stores the patient's medical records, symptoms, and other relevant data. It communicates with the application tier through data access layer."));

                Image ss = new Image("images/subsystems.png", "Subsystems");
                ss.setWidth("500px");
                hme.add(ss);

                hme.add(new Paragraph(
                                "For the disease diagnostic expert system to work as intended, the following subsystems were erected:"));
                hme.add(new Paragraph(
                                "1.	User Management Subsystem: Responsible for managing user accounts, authentication and authorization, and setting the state for their previous medical history. Contains login registration and password management."));
                hme.add(new Paragraph(
                                "2.	Diagnostic Subsystem: Responsible for allowing the user to select their symptoms and lifestyle habits. Contains a checklist of lifestyle habits and symptoms the user can select and generates a diagnostic based on the details filled."));
                hme.add(new Paragraph(
                                "3.	Scoreboard Subsystem: Works hand in hand with the diagnostic subsystem and tallies all the potential diseases that could result in the diagnostic. A patient will have their medical history, symptoms and lifestyle habits filled out. When the diagnostic generator has been initiated, the scoreboard will count which disease got the greatest number of tallies."));
                hme.add(new Paragraph(
                                "4.	Reporting Subsystem: It will compile the results allowing for string data to be added for the end when the report has been generated."));
                hme.add(new Paragraph(
                                "5.	UI Subsystem: Houses the components together for the user to be able to access. Connects the user to all the systems."));
                hme.add(new Paragraph(
                                "6.	Database Service Subsystem: Performs functional CRUD operations on the database."));

                H2 itf = new H2("Interface Design ");
                hme.add(itf);

                Image intfc = new Image("images/interface.png", "Interface");
                intfc.setWidth("500px");
                hme.add(intfc);

                page.add(hme);

        }

}
