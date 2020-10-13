package com.company.genpro.web.screens.doc;

import com.company.genpro.web.forms.JForm;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.genpro.entity.Doc;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.web.gui.components.WebForm;
import com.haulmont.cuba.web.gui.components.WebTabSheet;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.inject.Inject;
import java.util.*;

@UiController("genpro_Doc.browse")
@UiDescriptor("doc-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class DocBrowse extends MasterDetailScreen<Doc> {

    @Inject
    private Form form;
    @Inject
    UiComponents uiComponents;

    @Inject
    private InstanceContainer<Doc> docDc;

    @Inject
    DataManager dataManager;

    @Subscribe("table")
    public void onTableSelection(Table.SelectionEvent<Doc> event) {
        String jsonBody = event.getSelected().iterator().next().getJsonBody();
        JForm jForm = new JForm(jsonBody,uiComponents);
        jForm.createForm(form);
    }

    @Subscribe("saveBtn")
    public void onSaveBtnClick(Button.ClickEvent event) {
        enableEditControls(true);
        WebForm webForm = (WebForm) form.getComponent("formTab1");
        Collection<Component> components = webForm.getComponents(0);
        String json = JForm.createJSONObjectFromComponents(components).toString();
        System.out.println(json);
        Doc doc = docDc.getItem();
        doc.setJsonBody(json);
        dataManager.commit(doc);
        getEditedEntity().setDocJ(json);
    }
}