package net.effectivecode.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("other")
public class OtherView extends VerticalLayout {

    public OtherView() {

        Button nextPageButton = new Button("Go back to home");
        nextPageButton.addClickListener(e -> UI.getCurrent().navigate(""));
        add(nextPageButton);
    }
}
