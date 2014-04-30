package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Book;

public interface BookService {
  Book loadBook(Long id);
}
