package com.hungdt.jhipster.service.mapper;

import com.hungdt.jhipster.domain.*;
import com.hungdt.jhipster.service.dto.BookDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Book and its DTO BookDTO.
 */
@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper extends EntityMapper<BookDTO, Book> {

    @Mapping(source = "name.id", target = "nameId")
    @Mapping(source = "name.name", target = "nameName")
    BookDTO toDto(Book book);

    @Mapping(source = "nameId", target = "name")
    Book toEntity(BookDTO bookDTO);

    default Book fromId(Long id) {
        if (id == null) {
            return null;
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
