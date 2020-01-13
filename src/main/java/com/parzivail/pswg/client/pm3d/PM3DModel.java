package com.parzivail.pswg.client.pm3d;

import com.parzivail.pswg.client.model.SimpleModel;
import com.parzivail.util.primative.Vector2f;
import com.parzivail.util.primative.Vector3f;
import net.fabricmc.fabric.api.renderer.v1.material.RenderMaterial;
import net.fabricmc.fabric.api.renderer.v1.mesh.Mesh;
import net.fabricmc.fabric.api.renderer.v1.mesh.MeshBuilder;
import net.fabricmc.fabric.api.renderer.v1.mesh.MutableQuadView;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.ModelHelper;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;

import java.util.HashMap;
import java.util.function.Function;

public class PM3DModel extends SimpleModel
{
	private final PM3DFile container;
	private final HashMap<String, Sprite> sprites = new HashMap<>();

	private PM3DModel(Sprite sprite, Function<SpriteIdentifier, Sprite> spriteMap, PM3DFile container)
	{
		super(sprite, ModelHelper.MODEL_TRANSFORM_BLOCK);
		this.container = container;

		sprites.put("0", spriteMap.apply(new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("minecraft:block/stone"))));
	}

	private void emitFace(QuadEmitter quadEmitter, PM3DObject object, PM3DFace face)
	{
		quadEmitter.spriteColor(0, 0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff).material(getMaterial(face)).colorIndex(1);

		PM3DVertPointer a = face.verts.get(0);
		PM3DVertPointer b = face.verts.get(1);
		PM3DVertPointer c = face.verts.get(2);
		PM3DVertPointer d = face.verts.size() == 4 ? face.verts.get(3) : c;

		Vector3f vA = container.verts.get(a.getVertex());
		Vector3f vB = container.verts.get(b.getVertex());
		Vector3f vC = container.verts.get(c.getVertex());
		Vector3f vD = container.verts.get(d.getVertex());

		Vector3f nA = container.normals.get(a.getNormal());
		Vector3f nB = container.normals.get(b.getNormal());
		Vector3f nC = container.normals.get(c.getNormal());
		Vector3f nD = container.normals.get(d.getNormal());

		Vector2f tA = container.uvs.get(a.getTexture());
		Vector2f tB = container.uvs.get(b.getTexture());
		Vector2f tC = container.uvs.get(c.getTexture());
		Vector2f tD = container.uvs.get(d.getTexture());

		quadEmitter.pos(0, vA.toMinecraft()).normal(0, nA.toMinecraft()).sprite(0, 0, tA.x, tA.y);
		quadEmitter.pos(1, vB.toMinecraft()).normal(1, nB.toMinecraft()).sprite(1, 0, tB.x, tB.y);
		quadEmitter.pos(2, vC.toMinecraft()).normal(2, nC.toMinecraft()).sprite(2, 0, tC.x, tC.y);
		quadEmitter.pos(3, vD.toMinecraft()).normal(3, nD.toMinecraft()).sprite(3, 0, tD.x, tD.y);

		quadEmitter.spriteBake(0, sprites.get("0"), MutableQuadView.BAKE_NORMALIZED);

		quadEmitter.emit();
	}

	private RenderMaterial getMaterial(PM3DFace face)
	{
		switch (face.material)
		{
			case 0:
				return MAT_DIFFUSE_OPAQUE;
			case 1:
				return MAT_DIFFUSE_CUTOUT;
			case 2:
				return MAT_DIFFUSE_TRANSLUCENT;
			case 3:
				return MAT_EMISSIVE;
			default:
			{
				CrashReport crashReport = CrashReport.create(null, String.format("Unknown material ID: %s", face.material));
				throw new CrashException(crashReport);
			}
		}
	}

	@Override
	protected Mesh createMesh()
	{
		MeshBuilder meshBuilder = RENDERER.meshBuilder();
		QuadEmitter quadEmitter = meshBuilder.getEmitter();

		for (PM3DObject o : container.objects)
			for (PM3DFace face : o.faces)
				emitFace(quadEmitter, o, face);

		return meshBuilder.build();
	}

	public static PM3DModel create(Function<SpriteIdentifier, Sprite> spriteMap, PM3DFile container)
	{
		return new PM3DModel(spriteMap.apply(new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEX, new Identifier("minecraft:block/stone"))), spriteMap, container);
	}
}