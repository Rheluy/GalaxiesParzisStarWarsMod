package com.parzivail.pswg.client.texture.stacked;

import com.mojang.authlib.minecraft.InsecureTextureException;
import com.mojang.blaze3d.systems.RenderSystem;
import com.parzivail.pswg.Client;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

@Environment(EnvType.CLIENT)
public class StackedTextureProvider
{
	private final TextureManager textureManager;
	private final String identifierRoot;

	public StackedTextureProvider(TextureManager textureManager, String identifierRoot)
	{
		this.textureManager = textureManager;
		this.identifierRoot = identifierRoot;
	}

	public Identifier loadTexture(String id, Identifier... textures)
	{
		final Identifier identifier = new Identifier(identifierRoot + "/" + id);

		Util.getMainWorkerExecutor().execute(() -> {
			try
			{
				Client.minecraft.execute(() -> {
					RenderSystem.recordRenderCall(() -> {
						AbstractTexture abstractTexture = this.textureManager.getTexture(identifier);
						// TODO: fallback texture
						if (!(abstractTexture instanceof StackedTexture))
						{
							StackedTexture remoteTexture = new StackedTexture(null, textures);
							this.textureManager.registerTexture(identifier, remoteTexture);
						}
					});
				});
			}
			catch (InsecureTextureException var7)
			{
			}
		});

		return identifier;
	}
}
