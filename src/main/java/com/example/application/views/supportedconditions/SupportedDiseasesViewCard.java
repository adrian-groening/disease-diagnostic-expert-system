package com.example.application.views.supportedconditions;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

public class SupportedDiseasesViewCard extends ListItem {

        public SupportedDiseasesViewCard(String name, String src, String title, String cardSub, String para, String label ) {
                addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                        BorderRadius.LARGE);

                Div div = new Div();
                div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                        Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
                div.setHeight("160px");

                Image image = new Image(src, name);
                image.setWidth("100%");
                div.add(image);

                Span header = new Span();
                header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD);
                header.setText(title);

                Span subtitle = new Span();
                subtitle.addClassNames(FontSize.SMALL, TextColor.SECONDARY);
                subtitle.setText(cardSub);

                Paragraph description = new Paragraph(para);
                description.addClassName(Margin.Vertical.MEDIUM);

                Span badge = new Span();
                badge.getElement().setAttribute("theme", "badge");
                badge.setText(label);

                add(div, header, subtitle, description, badge);

    }


}

