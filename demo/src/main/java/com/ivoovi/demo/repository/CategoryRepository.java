package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Locale;
@Repository
public interface CategoryRepository extends JpaRepository <Type,Long>{

    Type findByName(String name);
}
