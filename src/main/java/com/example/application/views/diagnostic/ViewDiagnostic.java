package com.example.application.views.diagnostic;

import java.sql.SQLException;
import java.util.List;

import com.example.application.services.DatabaseOBJ;
import com.example.entities.diagnostics;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class ViewDiagnostic extends VerticalLayout {
    DatabaseOBJ data;
    VerticalLayout diagnosticInfo = new VerticalLayout();
    VerticalLayout page = new VerticalLayout();
    Span diagnosticID, date, description, userID, diseaseID;
    Accordion accordion = new Accordion();

    public ViewDiagnostic(int id) throws SQLException {
        data = new DatabaseOBJ();
        List<diagnostics> diagnosticList = data.getDiagnostics(id);

        for (int i = 0; i < diagnosticList.size(); i++) {
            TextArea desc = new TextArea();
            desc.setValue(diagnosticList.get(i).getDescription());
            desc.setReadOnly(true);
            desc.setSizeFull();
            add(desc);
        }

        for (int i = 0; i < diagnosticList.size(); i++) {
            VerticalLayout diagnostic = new VerticalLayout();
            diagnosticID = new Span("diagnosticID: " +
                    diagnosticList.get(i).getDiagnosticID());
            date = new Span("Date: " + diagnosticList.get(i).getDate());
            userID = new Span("userID: " + diagnosticList.get(i).getUserID());
            diseaseID = new Span("diseaseID: " + diagnosticList.get(i).getDiseaseID());
            diagnostic.add(diagnosticID, date, userID, diseaseID);
            diagnostic.setSpacing(false);
            diagnostic.setPadding(false);
            accordion.add("" + diagnosticList.get(i).getDate(), diagnostic);
            accordion.setSizeFull();
            add(accordion);
        }

    }
}
