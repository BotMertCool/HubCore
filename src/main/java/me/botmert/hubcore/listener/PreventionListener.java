package me.botmert.hubcore.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class PreventionListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (player.isOp() && player.getGameMode().equals(GameMode.CREATIVE)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (player.isOp() && player.getGameMode().equals(GameMode.CREATIVE)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onBlockBurn(BlockBurnEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onBucketFill(PlayerBucketFillEvent event) {
		Player player = event.getPlayer();
		if (player.isOp() && player.getGameMode().equals(GameMode.CREATIVE)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onBucketEmpty(PlayerBucketEmptyEvent event) {
		Player player = event.getPlayer();
		if (player.isOp() && player.getGameMode().equals(GameMode.CREATIVE)) return;
		event.setCancelled(true);
	}

	@EventHandler
	public void onBucketEmpty(PlayerItemDamageEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void inventoryClick(InventoryClickEvent event) {
		if (!(event.getWhoClicked() instanceof Player)) return;
		if (event.getWhoClicked().isOp() && event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

		event.setCancelled(true);
	}

	@EventHandler
	public void inventoryClick(InventoryDragEvent event) {
		if (!(event.getWhoClicked() instanceof Player)) return;
		if (event.getWhoClicked().isOp() && event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE)) return;

		event.setCancelled(true);
	}
}
