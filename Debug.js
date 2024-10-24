// 将该文件放入run/kubejs/server_scripts/目录下

// 潜行+右键获取手上物品id
ItemEvents.rightClicked((event) => {
	let { item, player } = event

	if (player.mainHandItem.id === item.id && player.crouching && player.mainHandItem !== "minecraft:air") {
		player.runCommandSilent("kubejs hand")
	}
})

// 潜行+右键获取方块硬度
BlockEvents.rightClicked((event) => {
	let { player } = event

	let blockState = event.getBlock().getBlockState()
	let pos = event.getBlock().getPos()
	let blockHardness = blockState.getDestroySpeed(event.getLevel(), pos)

	if (event.hand !== "MAIN_HAND" && player.crouching) {
		player.tell(`这个方块的硬度是: ${blockHardness}`)
	}
})