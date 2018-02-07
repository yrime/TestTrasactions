package ru.felix;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;

    @Transactional(readOnly=true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Transactional(readOnly=true)
    public Optional<Contact> findById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact save(Optional<Contact> contact) {
        return contactRepository.save(contact.get());
    }

    @Transactional(propagation= Propagation.NEVER)
    public long countAll() {
        return contactRepository.countAllContacts();
    }

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
