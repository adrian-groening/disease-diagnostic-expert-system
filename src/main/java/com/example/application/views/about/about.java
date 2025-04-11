package com.example.application.views.about;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

public class about extends Div {

        public about() {

                VerticalLayout page = new VerticalLayout();
                page.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

                H2 problemtext = new H2("Problem Statement");
                page.add(problemtext);

                Paragraph ptext = new Paragraph(
                                "Medical professionals exist because humans need health assurances. Problems rise when these assurances arenâ€™t met because of error, most importantly during the diagnosis process. In a fairly recent 2016 study by Johns Hopkins University, it was found that the third leading cause of death (10% of all deaths) in the U.S. is due to medical error (JHU, 2016). Contrary to what some may believe, doctors have limits to their abilities and that is when specialists come into play and even then, there are often instances of professionals not being able to handle patients accordingly. Though the number of these deaths are likely low compared to potential deaths without the assistance of health professionals, the desired outcome would be that of a diminished death rate in medical errors. The most obvious way to confront this this situation is to remove the error from medical. A solution worth implementing would be a disease diagnostic expert system where the error and diagnostic time could be significantly cut back allowing for more accurate results and less strenuous schedules for professionals to focus on more deserving tasks. A health professional would have to operate the system, fill in any information that may be required and be given a diagnostic of the patient possibly according to symptoms, test samples, and other data. Such systems, which use many kinds of intelligence components, have been proven in a study (as well as many others) with 11 pathologists to provide more accurate and faster results (Bejnordi et al., 2017). Since using algorithms and data is evidently a better and faster alternative in disease diagnostic, it would be considered a crime not to take action and implement this system.");
                page.add(ptext);

                H2 title = new H2("Tools Used");
                title.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
                page.add(title);

                Paragraph intro = new Paragraph(
                                "In this context, the technologies and tools that have been used include the Vaadin framework, Namecheap, Codespaces, GitHub, Heroku, Spring framework, Maven, Java, MariaDB, MySQL, and the GitHub student developer pack.");
                Paragraph vdn = new Paragraph(
                                "The Vaadin framework is a Java web application framework that simplifies the process of building web user interfaces. It allows developers to create web applications using Java code, which is then compiled into HTML, CSS, and JavaScript. The framework includes a set of pre-built user interface components that can be used to quickly create web applications. One of the benefits of Vaadin is that it reduces the amount of JavaScript code that needs to be written.");
                Paragraph nc = new Paragraph(
                                "Namecheap is a domain name registrar that provides affordable domain name registration services. It also provides web hosting services, email hosting, and SSL certificates. Namecheap has a reputation for being a reliable and affordable domain name registrar. Namecheap provided the domain name: Diagnosticate.me, free of charge all thanks to the GitHub student developer pack.");
                Paragraph cs = new Paragraph(
                                "Codespaces in conjunction with Visual Studio Code, is an online development environment provided by GitHub. It allows developers to work on code from anywhere, without needing to set up a local development environment. Codespaces provides access to a virtual machine that includes all the necessary tools and libraries for developing web applications. One of the benefits of Codespaces is that it allows developers to easily collaborate on code with others and it is extremely light and easy to run on low-end machines.");
                Paragraph gh = new Paragraph(
                                "GitHub is a web-based platform that provides version control and collaboration tools for software development. It allows developers to store code in repositories, track changes to code, and collaborate with others on code. GitHub provides a range of features, including issue tracking, pull requests, and code reviews. One of the benefits of GitHub is that it makes it easy to collaborate on code with others, even if they are located in different parts of the world. Also it can be convenien for migrating projects to other machines.");
                Paragraph hrk = new Paragraph(
                                "Heroku is a cloud platform that allows developers to deploy, manage, and scale web applications. It supports a range of programming languages, including Java, Ruby, Python, and Node.js. Heroku provides a range of features, including automatic scaling, add-ons, and a command-line interface. One of the benefits of Heroku is that it allows developers to easily deploy and scale web applications without needing to manage the underlying infrastructure. Heroku cloud hosting was provided by the GitHub student developer pack, free of charge.");
                Paragraph spr = new Paragraph(
                                "The Spring framework is a popular Java framework that provides a range of features for building web applications. It includes a set of pre-built modules that can be used to quickly develop web applications. The Spring framework provides features such as dependency injection, AOP, and MVC. One of the benefits of the Spring framework is that it simplifies the process of building web applications, by providing a set of pre-built components. The Vaadin framework is built off of the spring framework and the two work in conjunction with each other.");
                Paragraph mav = new Paragraph(
                                "Maven is a build automation tool used primarily for Java projects. It provides a way to manage project dependencies, build and package projects, and generate documentation. Maven allows developers to easily manage project dependencies, by automatically downloading and including the required libraries. Maven simplifies the process of building and managing Java projects.");
                Paragraph jav = new Paragraph(
                                "Java is a popular programming language used for building web applications. It is a statically typed language that is designed to be platform-independent. Java provides a range of features, including object-oriented programming, memory management, and exception handling. One of the benefits of Java is that it is widely used, which means that there is a large community and a wide range of libraries and tools available.");
                Paragraph mdbmsql = new Paragraph(
                                "MariaDB and MySQL are both open-source relational database management systems (RDBMS). They are both based on the SQL language and provide similar features, such as ACID compliance, transaction support, and a range of data types. MariaDB is a fork of MySQL and provides some additional features and improvements over MySQL. One of the benefits of MariaDB and MySQL is that they are widely used, which means that there is a large community and a wide range of tools and libraries available. The expert system's database was built using MySQL and tamed using a MariaDB tool called HeidiSQL.");
                Paragraph gsdp = new Paragraph(
                                "The GitHub student developer pack is a set of tools, services, and resources provided by GitHub to help students learn and develop their skills. It includes access to various tools and services, such as GitHub Pro, Heroku, Namecheap, and many others. One of the benefits of the GitHub student developer pack is that it provides students with access to a range of tools and resources that they might not otherwise have access to, all free of charge.");

                Image vaadin = new Image("images/vaadin logo.png", "Vaadin");
                Image namecheap = new Image("images/namecheap logo.png", "Namecheap");
                Image codespaces = new Image("images/codespaces logo.png", "Codespaces");
                Image github = new Image("images/github logo.png", "GitHub");
                Image heroku = new Image("images/heroku logo.png", "Vaadin");
                Image spring = new Image("images/spring.png", "Spring");
                Image mvn = new Image("images/mvn.png", "MVN");
                Image java = new Image("images/java.png", "Java");
                Image mariadb = new Image("images/mariadb.png", "MariaDB");
                Image mysql = new Image("images/mysql.png", "MySQL");
                Image sdp = new Image("images/sdp.png", "Student Developer Pack");

                vaadin.setWidth("150px");
                namecheap.setWidth("150px");
                codespaces.setWidth("150px");
                github.setWidth("150px");
                heroku.setWidth("150px");
                spring.setWidth("150px");
                mvn.setWidth("150px");
                java.setWidth("150px");
                mariadb.setWidth("150px");
                mysql.setWidth("150px");
                sdp.setWidth("150px");

                Footer foot = new Footer();
                foot.setText(
                                "copyright Diagnosticate.me 2023 | \nBuilt by Adrian Groening |\n201903910@ub.ac.bw |\ngroeningadrian@gmail.com");

                VerticalLayout container = new VerticalLayout();
                container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);
                container.add(intro, vaadin, vdn, namecheap, nc, codespaces, cs, github, gh, heroku, hrk, spring, spr,
                                mvn, mav,
                                java, jav, mariadb, mysql, mdbmsql, sdp, gsdp);

                page.add(container);

                H2 misc = new H2("Misc.");
                page.add(misc);

                page.add(foot);
                add(page);

        }

}
