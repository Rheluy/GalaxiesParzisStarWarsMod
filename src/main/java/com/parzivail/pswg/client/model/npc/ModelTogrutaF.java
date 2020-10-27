package com.parzivail.pswg.client.model.npc;

import com.parzivail.util.client.ModelPartUtil;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;

public class ModelTogrutaF<T extends LivingEntity> extends PlayerEntityModel<T>
{
	public ModelPart Chest;
	public ModelPart TailBaseR;
	public ModelPart TailBaseL;
	public ModelPart TailBaseB;
	public ModelPart HeadTailR;
	public ModelPart TailUpperR;
	public ModelPart TailLowerR;
	public ModelPart HeadTailChildR;
	public ModelPart HeadTailL;
	public ModelPart TaiUpperL;
	public ModelPart TailLowerL;
	public ModelPart HeadTailChildL;
	public ModelPart HeadTailB;
	public ModelPart TailLowerB;

	public ModelTogrutaF(float scale)
	{
		super(scale, false);

		textureWidth = 64;
		textureHeight = 60;
		TailLowerB = new ModelPart(this, 36, 52);
		TailLowerB.mirror = true;
		TailLowerB.setPivot(0.5F, 4.7F, -0.4F);
		TailLowerB.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 2, 0.0F);
		Chest = new ModelPart(this, 50, 10);
		Chest.setPivot(-3.0F, 2.0F, -2.9F);
		Chest.addCuboid(0.0F, 0.0F, 0.0F, 6, 3, 1, 0.0F);
		leftArm = new ModelPart(this, 40, 16);
		leftArm.mirror = true;
		leftArm.setPivot(5.0F, 2.0F, -0.0F);
		leftArm.addCuboid(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		ModelPartUtil.setRotateAngle(leftArm, 0.0F, 0.0F, -0.10000736613927509F);
		leftLeg = new ModelPart(this, 0, 16);
		leftLeg.mirror = true;
		leftLeg.setPivot(1.9F, 12.0F, 0.1F);
		leftLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		TailBaseR = new ModelPart(this, 0, 36);
		TailBaseR.mirror = true;
		TailBaseR.setPivot(-5.4F, -7.9F, 0.2F);
		TailBaseR.addCuboid(0.0F, -1.3F, -0.8F, 4, 6, 6, 0.0F);
		ModelPartUtil.setRotateAngle(TailBaseR, -0.45378560551852565F, 0.13962634015954636F, 0.0F);
		TailLowerR = new ModelPart(this, 32, 40);
		TailLowerR.mirror = true;
		TailLowerR.setPivot(1.5F, 11.5F, 2.7F);
		TailLowerR.addCuboid(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		ModelPartUtil.setRotateAngle(TailLowerR, 0.45378560551852565F, 0.0F, 0.0F);
		HeadTailChildL = new ModelPart(this, 40, 40);
		HeadTailChildL.mirror = true;
		HeadTailChildL.setPivot(0.0F, 3.5F, 0.0F);
		HeadTailChildL.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 1, 0.0F);
		TaiUpperL = new ModelPart(this, 50, 39);
		TaiUpperL.mirror = true;
		TaiUpperL.setPivot(0.9F, -5.3F, -0.1F);
		TaiUpperL.addCuboid(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
		ModelPartUtil.setRotateAngle(TaiUpperL, 0.13962634015954636F, 0.0F, -0.13962634015954636F);
		TailLowerL = new ModelPart(this, 32, 40);
		TailLowerL.mirror = true;
		TailLowerL.setPivot(1.5F, 11.5F, 2.7F);
		TailLowerL.addCuboid(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		ModelPartUtil.setRotateAngle(TailLowerL, 0.45378560551852565F, 0.0F, 0.0F);
		rightArm = new ModelPart(this, 40, 16);
		rightArm.setPivot(-5.0F, 2.0F, 0.0F);
		rightArm.addCuboid(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
		ModelPartUtil.setRotateAngle(rightArm, 0.0F, 0.0F, 0.10000736613927509F);
		torso = new ModelPart(this, 16, 16);
		torso.setPivot(0.0F, 0.0F, 0.0F);
		torso.addCuboid(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
		TailBaseB = new ModelPart(this, 0, 50);
		TailBaseB.setPivot(-3.0F, -6.8F, 0.4F);
		TailBaseB.addCuboid(0.0F, 0.0F, 0.0F, 6, 5, 5, 0.0F);
		TailBaseL = new ModelPart(this, 0, 36);
		TailBaseL.setPivot(1.4F, -7.9F, -0.2F);
		TailBaseL.addCuboid(0.0F, -1.3F, -0.8F, 4, 6, 6, 0.0F);
		ModelPartUtil.setRotateAngle(TailBaseL, -0.45378560551852565F, -0.13962634015954636F, 0.0F);
		HeadTailChildR = new ModelPart(this, 40, 40);
		HeadTailChildR.mirror = true;
		HeadTailChildR.setPivot(0.0F, 3.5F, 0.0F);
		HeadTailChildR.addCuboid(0.0F, 0.0F, 0.0F, 3, 6, 1, 0.0F);
		HeadTailR = new ModelPart(this, 20, 35);
		HeadTailR.mirror = true;
		HeadTailR.setPivot(0.4F, -0.2F, 0.9F);
		HeadTailR.addCuboid(0.0F, 1.9F, 1.1F, 3, 10, 3, 0.0F);
		ModelPartUtil.setRotateAngle(HeadTailR, -0.06981317007977318F, 0.0F, 0.0F);
		TailUpperR = new ModelPart(this, 50, 39);
		TailUpperR.mirror = true;
		TailUpperR.setPivot(0.9F, -5.6F, 0.1F);
		TailUpperR.addCuboid(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
		ModelPartUtil.setRotateAngle(TailUpperR, 0.13962634015954636F, 0.0F, 0.13962634015954636F);
		head = new ModelPart(this, 0, 0);
		head.setPivot(0.0F, 0.0F, 0.0F);
		head.addCuboid(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		rightLeg = new ModelPart(this, 0, 16);
		rightLeg.setPivot(-1.9F, 12.0F, 0.1F);
		rightLeg.addCuboid(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
		HeadTailL = new ModelPart(this, 20, 35);
		HeadTailL.mirror = true;
		HeadTailL.setPivot(0.6F, -0.2F, 0.9F);
		HeadTailL.addCuboid(0.0F, 1.9F, 1.1F, 3, 10, 3, 0.0F);
		ModelPartUtil.setRotateAngle(HeadTailL, -0.08726646259971647F, 0.0F, 0.0F);
		HeadTailB = new ModelPart(this, 22, 50);
		HeadTailB.mirror = true;
		HeadTailB.setPivot(1.0F, 1.6F, 2.6F);
		HeadTailB.addCuboid(0.0F, 0.0F, -0.9F, 4, 7, 3, 0.0F);
		HeadTailB.addChild(TailLowerB);
		head.addChild(TailBaseR);
		HeadTailR.addChild(TailLowerR);
		HeadTailL.addChild(HeadTailChildL);
		TailBaseL.addChild(TaiUpperL);
		HeadTailL.addChild(TailLowerL);
		head.addChild(TailBaseB);
		head.addChild(TailBaseL);
		HeadTailR.addChild(HeadTailChildR);
		TailBaseR.addChild(HeadTailR);
		TailBaseR.addChild(TailUpperR);
		TailBaseL.addChild(HeadTailL);
		TailBaseB.addChild(HeadTailB);
		torso.addChild(Chest);
	}
}
