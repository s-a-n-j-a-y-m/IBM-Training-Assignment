package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.ItemEntity;
import com.example.demo.repo.ItemRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	@Override
	public ItemEntity createItem(ItemEntity itemEntity) {
		return itemRepository.save(itemEntity);
	}

}
