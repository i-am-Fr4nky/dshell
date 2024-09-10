package com.x5.bigdata.fr4nky.example.dshell.repository.app;

import com.x5.bigdata.fr4nky.example.dshell.entity.app.BigProduct;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.hibernate.jpa.QueryHints.*;

@Repository
public interface ProductRepository extends
        JpaRepository<BigProduct, UUID> {

    @QueryHints(value = {
            @QueryHint(name = HINT_FETCH_SIZE, value = "100"),        // TODO добавить комменты
            @QueryHint(name = HINT_CACHEABLE, value = "false"),     // TODO добавить комменты
            @QueryHint(name = HINT_READONLY, value = "true")})      // TODO добавить комменты
    Stream<BigProduct> streamBy(PageRequest pageRequest);


    @Override
    @QueryHints(value = {
            @QueryHint(name = HINT_FETCH_SIZE, value = "100"),        // TODO добавить комменты
            @QueryHint(name = HINT_CACHEABLE, value = "false"),     // TODO добавить комменты
            @QueryHint(name = HINT_READONLY, value = "true")})
    List<BigProduct> findAll();
}
