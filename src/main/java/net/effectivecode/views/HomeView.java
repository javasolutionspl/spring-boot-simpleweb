package net.effectivecode.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("my_style.css")
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new H1("Welcome to basic Spring Boot application with Vaadin!"));
        Button nextPageButton = new Button("Go to next page");
        nextPageButton.addClickListener(e -> UI.getCurrent().navigate("other"));
        nextPageButton.addClassNames("yellow-button");
        add(nextPageButton);
    }
}
