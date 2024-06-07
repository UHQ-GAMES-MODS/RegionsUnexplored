package net.regions_unexplored;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "regions_unexplored";
	public static final String MOD_NAME = "Regions Unexplored";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}}