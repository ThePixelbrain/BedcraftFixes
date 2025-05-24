package uk.bedcraft.bedcraftfixes.mixins.hqm;

import java.io.File;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import hardcorequesting.QuestingData;
import hardcorequesting.network.FileHelper;

@Mixin(value = QuestingData.class, remap = false)
public abstract class QuestingDataMixin {

    @Final
    @Shadow
    private static FileHelper FILE_HELPER;

    @Inject(
        method = "save",
        at = @At(
            value = "INVOKE",
            target = "Lhardcorequesting/network/FileHelper;saveData(Ljava/io/File;)Lhardcorequesting/network/FileHelper$SaveResult;"),
        cancellable = true,
        locals = LocalCapture.CAPTURE_FAILSOFT)
    private static void saveFromNewThread(CallbackInfo ci, File file) {
        new Thread(() -> FILE_HELPER.saveData(file)).start();
        ci.cancel();
    }
}
