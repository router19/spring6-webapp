package com.vinikuma.spring6webapp.boostrap;
import com.vinikuma.spring6webapp.domain.Author;
import com.vinikuma.spring6webapp.domain.Book;
import com.vinikuma.spring6webapp.domain.Publisher;
import com.vinikuma.spring6webapp.repository.AuthorRepository;
import com.vinikuma.spring6webapp.repository.BookRepository;
import com.vinikuma.spring6webapp.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("12345");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);



        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("6538238");

        Author rodSaved = authorRepository.save(rod);
        Book noEJPSaved = bookRepository.save(noEJB);


        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJPSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJPSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");;
        publisher.setAddress("1323 sdfsd");
        Publisher publisherSaved = publisherRepository.save(publisher);

        dddSaved.setPublisher(publisherSaved);
        noEJB.setPublisher((publisherSaved));
        //persist the book association
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJPSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count "+ authorRepository.count());
        System.out.println("Book count "+ bookRepository.count());



        System.out.println("Publisher count "+ publisherRepository.count());

    }
}
