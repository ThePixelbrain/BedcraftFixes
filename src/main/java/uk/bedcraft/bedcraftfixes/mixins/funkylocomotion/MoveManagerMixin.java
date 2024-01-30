package uk.bedcraft.bedcraftfixes.mixins.funkylocomotion;

import net.minecraft.network.Packet;
import net.minecraft.server.management.PlayerManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.WrapWithCondition;
import com.rwtema.funkylocomotion.movers.MoveManager;

@Mixin(value = MoveManager.class, remap = false)
public abstract class MoveManagerMixin {

    @WrapWithCondition(
        method = "startMoving",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/management/PlayerManager$PlayerInstance;sendToAllPlayersWatchingChunk(Lnet/minecraft/network/Packet;)V"))
    private static boolean onlySendWhenNotNull(PlayerManager.PlayerInstance instance, Packet packet) {
        return instance != null;
    }
}
