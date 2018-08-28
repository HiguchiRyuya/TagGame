package com.kaigun2929.util;

import org.bukkit.ChatColor;

import static net.md_5.bungee.api.ChatColor.*;

public class ChatUtil {

    public static String format(String s){
        return ChatColor.translateAlternateColorCodes('&',s);
    }
}
