package uk.bedcraft.bedcraftfixes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;

@Mod(
    modid = BedcraftFixes.MODID,
    version = Tags.VERSION,
    name = "BedcraftFixes",
    acceptedMinecraftVersions = "[1.7.10]",
    acceptableRemoteVersions = "*")
public class BedcraftFixes {

    public static final String MODID = "bedcraftfixes";
    public static final Logger LOG = LogManager.getLogger(BedcraftFixes.MODID);
}
