package com.inventory.repository;

public interface InventoryRepository {
	boolean reduceInventory(int productId, int quantity);
}
