ItemEvents.rightClicked((event) => {
    let { item, player } = event

    if (player.mainHandItem.id === item.id && player.crouching && player.mainHandItem !== "minecraft:air") {
        player.runCommandSilent("kubejs hand")
    }
})

BlockEvents.rightClicked((event) => {
    let { player } = event

    let blockState = event.getBlock().getBlockState()
    let pos = event.getBlock().getPos()
    let blockHardness = blockState.getDestroySpeed(event.getLevel(), pos)

    if (event.hand !== "MAIN_HAND" && player.crouching) {
        player.tell(`这个方块的硬度是: ${ blockHardness }`)
    }
})

PlayerEvents.chat((event) => {
    let { player, message, server } = event

    for (let i = 0; i < global.debugUserName.length; i ++) {
        // 输入-ki删除所有掉落物
        if (message.trim().equalsIgnoreCase("-ki")) {
            server.runCommandSilent("kill @e[type=item]")
            server.runCommandSilent("tellraw @a '掉落物已清除'")
            event.cancel()
        }

        // 输入-kf获得[夜视 力量 抗性]buff
        if (message.trim().equalsIgnoreCase("-kf")) {
            player.runCommandSilent("effect give @s minecraft:night_vision infinite 255 true")
            player.runCommandSilent("effect give @s minecraft:strength infinite 255 true")
            player.runCommandSilent("effect give @s minecraft:resistance infinite 255 true")
            event.cancel()
        }

        // 输入-efc清除自身所有buff
        if (message.trim().equalsIgnoreCase("-efc")) {
            player.runCommandSilent("effect clear")
            event.cancel()
        }

        // 输入-kla清除玩家之外的所有实体
        if (message.trim().equalsIgnoreCase("-kla")) {
            server.runCommandSilent("kill @e[type=!player]")
            event.cancel()
        }
    }
})