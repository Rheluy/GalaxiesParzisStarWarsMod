package com.parzivail.util.item;

import com.parzivail.pswg.container.SwgPackets;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class LeftClickHandler
{
	public static void handleInputEvents(CallbackInfo ci)
	{
		MinecraftClient mc = MinecraftClient.getInstance();

		if (!mc.options.keyAttack.isPressed())
			return;

		assert mc.player != null;

		ItemStack stack = mc.player.getMainHandStack();

		if (stack.getItem() instanceof ILeftClickConsumer)
		{
			TypedActionResult<ItemStack> tar = ((ILeftClickConsumer)stack.getItem()).useLeft(mc.player.world, mc.player, Hand.MAIN_HAND);
			ActionResult ar = tar.getResult();

			if (ar == ActionResult.PASS)
				return;

			ci.cancel();
		}

		ClientSidePacketRegistry.INSTANCE.sendToServer(SwgPackets.C2S.PacketPlayerLeftClickItem, new PacketByteBuf(Unpooled.buffer()));
	}

	public static void handleLeftClickPacket(PacketContext packetContext, PacketByteBuf packetByteBuf)
	{
		PlayerEntity player = packetContext.getPlayer();
		ItemStack stack = player.getMainHandStack();

		if (stack.getItem() instanceof ILeftClickConsumer)
		{
			((ILeftClickConsumer)stack.getItem()).useLeft(player.world, player, Hand.MAIN_HAND);
		}
	}
}