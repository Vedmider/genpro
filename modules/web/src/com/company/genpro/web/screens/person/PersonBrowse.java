package com.company.genpro.web.screens.person;

import com.company.genpro.entity.Address;
import com.github.javafaker.Faker;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.screen.*;
import com.company.genpro.entity.Person;

import javax.inject.Inject;
import java.util.Random;
import java.util.UUID;

@UiController("jsonb_Person.browse")
@UiDescriptor("person-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class PersonBrowse extends MasterDetailScreen<Person> {
    @Inject
    private DataManager dataManager;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Person person = getEditedEntity();
        Address address = new Address();
        Faker faker = new Faker();
        address.setAddress(faker.address().streetAddress());
        address.setCity(faker.address().cityName());
        address.setCountry(faker.country().name());
        address.setId(new Random().nextInt());
        person.setAddress(address);
    }

}