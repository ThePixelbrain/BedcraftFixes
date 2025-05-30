package uk.bedcraft.bedcraftfixes.mixins.computercraft;

import java.net.HttpURLConnection;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import dan200.computercraft.ComputerCraft;

@Mixin(targets = "dan200.computercraft.core.apis.HTTPRequest$1", remap = false)
public abstract class HTTPRequestMixin {

    @ModifyVariable(method = "run", at = @At("STORE"))
    private HttpURLConnection setUserAgent(HttpURLConnection connection) {
        connection.setRequestProperty("User-Agent", "ComputerCraft/" + ComputerCraft.getVersion());
        return connection;
    }
}
