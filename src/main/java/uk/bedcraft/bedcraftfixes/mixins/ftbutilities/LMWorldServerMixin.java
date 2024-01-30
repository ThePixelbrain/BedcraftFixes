package uk.bedcraft.bedcraftfixes.mixins.ftbutilities;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.util.FakePlayer;

import org.spongepowered.asm.mixin.Mixin;

import cpw.mods.fml.relauncher.Side;
import ftb.utils.world.LMFakeServerPlayer;
import ftb.utils.world.LMPlayer;
import ftb.utils.world.LMPlayerServer;
import ftb.utils.world.LMWorld;
import ftb.utils.world.LMWorldServer;

@Mixin(value = LMWorldServer.class, remap = false)
public abstract class LMWorldServerMixin extends LMWorld {

    protected LMWorldServerMixin(Side s) {
        super(s);
    }

    // Fix taken from https://github.com/GTNewHorizons/FTB-Utilities/pull/1
    // Licensed under LGPL-3.0
    @Override
    public LMPlayerServer getPlayer(Object o) {
        if (o instanceof FakePlayer) return new LMFakeServerPlayer((LMWorldServer) (Object) this, (FakePlayer) o);
        LMPlayer p = super.getPlayer(o);
        if (p == null) {
            return null;
        }
        LMPlayerServer mp = p.toPlayerMP();
        if (o instanceof EntityPlayerMP) mp.setPlayer((EntityPlayerMP) o);
        return mp;
    }
}
