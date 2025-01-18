package com.github.ipecter.rtustudio.tags;

import com.github.ipecter.rtustudio.tags.commands.MainCommand;
import com.github.ipecter.rtustudio.tags.loader.*;
import kr.rtuserver.framework.bukkit.api.RSPlugin;
import lombok.Getter;
import org.bukkit.NamespacedKey;

@Getter
public class Tags extends RSPlugin {

    private static Tags instance;

    private BiomeLoader biome;
    private BlockLoader block;
    private EntityTypeLoader entityType;
    private FluidLoader fluid;
    private ItemLoader item;


    @Override
    public void enable() {
        instance = this;
        initLoader();
        registerCommand(new MainCommand(this), true);
    }

    public void initLoader() {
        biome = new BiomeLoader(this);
        block = new BlockLoader(this);
        entityType = new EntityTypeLoader(this);
        fluid = new FluidLoader(this);
        item = new ItemLoader(this);
    }

}