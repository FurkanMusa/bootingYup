package com.ltp.contacts.service;

import org.springframework.stereotype.Service;

import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    
    Contact getContactById(String id);

    void saveContact(Contact contact);

}
