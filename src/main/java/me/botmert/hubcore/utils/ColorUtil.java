package me.botmert.hubcore.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class ColorUtil {

    public static String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
