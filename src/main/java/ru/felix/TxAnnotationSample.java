package ru.felix;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TxAnnotationSample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/app-context.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("contactService",
                ContactService.class);

        List<Contact> contacts = contactService.findAll();

        for (Contact contactTemp: contacts) {
            System.out.println(contactTemp);
        }

        Optional<Contact> contact = contactService.findById(1L);
        contact.get().setFirstName("Peter");
        contactService.save(contact);
        System.out.println("Contact saved successfully: " + contact);
        System.out.println("Contact count: " + contactService.countAll());
    }
} 