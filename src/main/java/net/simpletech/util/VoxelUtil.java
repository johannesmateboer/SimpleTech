package net.simpletech.util;

import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class VoxelUtil {

    /**
     * Rotates a VoxelShape
     * @param from  Original Direction
     * @param to    Target-direction
     * @param shape A valid VoxelShape
     * @return VoxelShape
     */
    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };
        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.combine(buffer[1], VoxelShapes.cuboid(1-maxZ, minY, minX, 1-minZ, maxY, maxX), BooleanBiFunction.OR));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }
        return buffer[0];
    }

    /**
     * Creates a VoxelShape by pixelsize (from 0 to 16)
     * @param minX  Startpoint on X-axis
     * @param minY  Startpoint on Y-axis (up)
     * @param minZ  Startpoint on Z-axis
     * @param maxX  Endpoint
     * @param maxY  Endpoint
     * @param maxZ  Endpoint
     * @return  VoxelShape
     */
    public static VoxelShape createCuboid(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        return VoxelShapes.cuboid((minX/16f), (minY/16f), (minZ/16f), (maxX/16f), (maxY/16f), (maxZ/16f));
    }

}
