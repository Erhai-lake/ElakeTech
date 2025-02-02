# ElakeTech

> [!WARNING]
>
> 每次进行`datagen`如果不成功请尝试先删除原先的`generated`

[🐮佛哦🐔](//neoforged.net/)

[NeoForge](//neoforged.net/)

## 随便写些文档

### 怎么自定义工具挖掘
<details open>
<summary>点击展开或收起</summary>

https://docs.neoforged.net/docs/items/tools/

就是这么简单(如写)

#### 直接使用原版的

```java
public static final TagKey<Block> NEEDS_CUSTOM_TOOL = TagKey
        .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath("minecraft", "incorrect_for_wooden_tool"));
```

`incorrect_for_wooden_tool`: 这个是原版`Tag`的名字,像这样的还有:

* `minecraft:needs_iron_tool`: 需要铁工具Tag
* `minecraft:needs_stone_tool`: 需要石工具Tag
* `minecraft:needs_diamond_tool`: 需要钻石工具Tag
*
* `minecraft:incorrect_for_wooden_tool`: 木工具不可挖掘Tag
* `minecraft:incorrect_for_stone_tool`: 石工具不可挖掘Tag
* `minecraft:incorrect_for_iron_tool`: 铁工具不可挖掘Tag
* `minecraft:incorrect_for_gold_tool`: 金工具不可挖掘Tag
* `minecraft:incorrect_for_diamond_tool`: 钻石工具不可挖掘Tag
* `minecraft:incorrect_for_nerherite_tool`: 下界合金工具不可挖掘Tag

至于这`Tag`里写了什么,还请自行翻原版的`Tags`

#### 自定义

定义什么方块需要这个工具

```java
public static final TagKey<Block> NEEDS_CUSTOM_TOOL = TagKey
        .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(ElakeChemical.ModID, "needs_custom_tool"));
```

定义这个工具不能挖掘的方块

```java
public static final TagKey<Block> INCORRECT_FOR_CUSTOM_TOOL = TagKey
        .create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(ElakeChemical.ModID, "incorrect_for_custom_tool"));
```

然后新建`Tag`,目录在`src/main/resources/data/${modid}/tags/block`下

如果想让这个工具只能挖石头,就这样写

`needs_custom_tool.json`

```json
{
    "values": [
        "minecraft:stone"
    ]
}
```

如果想让这个工具不能挖石头,就这样写

`needs_custom_tool.json`

```json
{
    "values": [
        "minecraft:stone"
    ]
}
```

`incorrect_for_custom_tool.json`

```json
{
    "values": [
        "#minecraft:incorrect_for_diamond_tool"
    ],
    "remove": [
        "#elake_tech:needs_custom_tool"
    ]
}
```

这个的意思是,继承`minecraft:incorrect_for_diamond_tool`,但是从中去除了`elake_tech:needs_custom_tool`

> [!NOTE]
> 
> 定义了`Tier`的工具不可以单独设置耐久, `Tier`设置的耐久是多少那工具就是多少, 除非定义一个新的`Tier`不然耐久都是固定的耐久

</details>

### 如何为物品进行着色

<details open>
<summary>点击展开或收起</summary>
[如写](https://docs.neoforged.net/docs/resources/client/models/)

```java
@EventBusSubscriber(modid = ElakeChemical.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
```
</details>
