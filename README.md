# ElakeChemical

> [!WARNING]
> 
> 我操这个模组可太模组了!!!

[NeoForged](//neoforged.net/)

## 随便写些文档

### 怎么自定义工具挖掘

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

然后新建`Tag`,目录在`src/main/resources/data/mod_id/tags/block`下

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
        "#elake_chemical:needs_custom_tool"
    ]
}
```

这个的意思是,继承`minecraft:incorrect_for_diamond_tool`,但是从中去除了`elake_chemical:needs_custom_tool`
