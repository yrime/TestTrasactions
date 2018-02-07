package ru.felix;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> findAll();
    Optional<Contact> findById(Long id);
    Contact save(Optional<Contact> contact);
    long countAll();
} 