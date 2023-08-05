package uk.bedcraft.bedcraftfixes.mixins.ftbutilities;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import ftb.utils.mod.handlers.FTBUChunkEventHandler;
import ftb.utils.world.claims.ClaimedChunk;

@Mixin(value = FTBUChunkEventHandler.class, remap = false)
public abstract class FTBUChunkEventHandlerMixin {

    @ModifyVariable(
        method = "ticketsLoaded(Ljava/util/List;Lnet/minecraft/world/World;)V",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraftforge/common/ForgeChunkManager;forceChunk(Lnet/minecraftforge/common/ForgeChunkManager$Ticket;Lnet/minecraft/world/ChunkCoordIntPair;)V"))
    private ClaimedChunk setForced(ClaimedChunk chunk) {
        chunk.isForced = true;
        return chunk;
    }
}
