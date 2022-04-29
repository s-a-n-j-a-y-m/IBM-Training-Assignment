package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ItemEntity;
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
