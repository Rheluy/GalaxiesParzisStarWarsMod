package com.parzivail.pswg.entity;

import com.parzivail.pswg.Client;
import com.parzivail.pswg.util.MathUtil;
import com.parzivail.util.math.QuatUtil;
import net.minecraft.client.options.Perspective;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class ChaseCam
{
	public Vec3d prevPos;
	public Vec3d pos;

	public void tick(ShipEntity parent)
	{
		if (parent == null || parent.removed)
			return;

		if (pos == null)
			pos = parent.getPos();

		prevPos = new Vec3d(pos.x, pos.y, pos.z);

		World world = parent.world;

		float lerpAmount = 0.4f;

		Quaternion q = parent.getViewRotation(1);

		float camDistTarget = getCamDistTarget(parent, q);
		Vec3d camTargetPosition = parent.getPos().add(QuatUtil.rotate(new Vec3d(0, 0, camDistTarget), q));
		Vec3d camDpos = camTargetPosition.subtract(pos);

		Vec3d lerpPos = pos.add(camDpos.multiply(lerpAmount));
		BlockHitResult result = world.raycast(new RaycastContext(parent.getPos(), lerpPos, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, parent));

		double totalDistance = parent.getPos().distanceTo(result.getPos());
		if (totalDistance == 0)
			pos = result.getPos();
		else
			pos = MathUtil.lerp((float)((totalDistance - 0.05) / totalDistance), parent.getPos(), result.getPos());
	}

	private float getCamDistTarget(ShipEntity parent, Quaternion q)
	{
		Perspective perspective = Client.minecraft.options.getPerspective();
		int scalar = 1;
		if (perspective == Perspective.FIRST_PERSON)
			return 0;
		else if (perspective == Perspective.THIRD_PERSON_FRONT)
			scalar = -1;
		float throttle = 1;
		return scalar * (13 + 3 * throttle);
	}
}
