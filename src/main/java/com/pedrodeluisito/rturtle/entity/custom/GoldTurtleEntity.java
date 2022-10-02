package com.pedrodeluisito.rturtle.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.world.World;

public class GoldTurtleEntity extends TurtleEntity {
    public GoldTurtleEntity(EntityType<? extends TurtleEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
