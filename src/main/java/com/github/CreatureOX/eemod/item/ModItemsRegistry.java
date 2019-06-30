package com.github.CreatureOX.eemod.item;

import com.github.CreatureOX.eemod.Main;
import com.github.CreatureOX.eemod.constant.Constants;
import com.github.CreatureOX.eemod.creativetab.ModCreativeTabs;
import com.github.CreatureOX.eemod.item.items.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItemsRegistry {

	// Items
	public static Item experimentItem;
	public static Item hammerItem;
	public static Item MagicWand;
	public static Item PurpleIngot;

	// Foods
	public static ItemFood PoisonedApple;
	public static ItemFood Oatmeal;
	public static ItemFood Bun;
	public static ItemFood BertieBottsEveryFlavorBeans;
	public static ItemFood ButterBeer;
	public static ItemFood CholocateFrog;

	// Swords
	public static ItemSword ColorfulSword;

	// Armors
	public static Item magicHelmet;
	public static Item magicChestplate;
	public static Item magicLeggings;
	public static Item magicBoots;

	// Others
	public static Item SortingHat;
	public static Item InvisibleCloak;
	public static Item FlooPowder;
	public static Item Portkey;
	public static Item VanishingCabinet;
	public static Item Besom;
	public static Item EnrollmentNotice;

	public static ToolMaterial MAGIC = EnumHelper.addToolMaterial(Constants.Material.MAGIC, 3, 1561/2, 12.0F, 0, 22);
	public static ArmorMaterial MAGIC_ARMOR = EnumHelper.addArmorMaterial(Constants.Material.MAGIC_ARRMOR, 16,  new int[] {3,8,6,3}, 30);
	
	public static final void init(){
		// Item
		experimentItem = new Item().setUnlocalizedName(Constants.Items.EXPERIMENT_ITEM).setTextureName(Main.MODID + ":" + Constants.Items.EXPERIMENT_ITEM).setCreativeTab(CreativeTabs.tabMisc);
		hammerItem     = new Hammer().setUnlocalizedName(Constants.Items.HAMMER).setTextureName(Main.MODID + ":" + Constants.Items.HAMMER).setCreativeTab(CreativeTabs.tabMisc);
		MagicWand      = new MagicWand().setUnlocalizedName(Constants.Items.MAGIC_WAND).setTextureName(Main.MODID + ":" + Constants.Items.MAGIC_WAND).setCreativeTab(ModCreativeTabs.tabEEmod);
		Besom		   = new Besom().setUnlocalizedName(Constants.Items.BESOM).setTextureName(Main.MODID + ":" + Constants.Items.BESOM).setCreativeTab(CreativeTabs.tabMisc);

		// Ore
		PurpleIngot = new Item().setUnlocalizedName(Constants.Items.PURPLE_INGOT).setTextureName(Main.MODID + ":" + Constants.Items.PURPLE_INGOT).setCreativeTab(ModCreativeTabs.tabEEmod);

		// Food
		// poison effect to the item which lasts for 10 seconds (!), has an amplifier of 0 (Level 1 of the potion);
		PoisonedApple               = new ModItemFoods(Constants.Foods.POISONED_APPLE, 2, 0.2f, false,new PotionEffect(Potion.poison.id, 200, 4)).setAlwaysEdible();
		Oatmeal                     = new ModItemFoods(Constants.Foods.OATMEAL,5, 0.2f, false, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible();
		Bun                         = new ModItemFoods(Constants.Foods.BUN,5, 0.2f, false, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible();
		BertieBottsEveryFlavorBeans = new ModItemFoods(Constants.Foods.BERTIE_BOTTS_EVERY_FLAVOR_BEANS,5, 0.2f, false, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible();
		ButterBeer                  = new ModItemFoods(Constants.Foods.BUTTER_BEAR,5, 0.2f, false, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible();
		CholocateFrog               = new ModItemFoods(Constants.Foods.CHOLOCATE_FROG,5, 0.2f, false, new PotionEffect(Potion.regeneration.id, 200, 1)).setAlwaysEdible();

		//Others
		SortingHat			= new SortingHat().setUnlocalizedName(Constants.Items.SORTING_HAT).setTextureName(Main.MODID + ":" + Constants.Items.SORTING_HAT).setCreativeTab(ModCreativeTabs.tabEEmod);
		InvisibleCloak		= new Item().setUnlocalizedName(Constants.Items.INVISIBLE_CLOAK).setTextureName(Main.MODID + ":" +  Constants.Items.INVISIBLE_CLOAK).setCreativeTab(CreativeTabs.tabMisc);
		FlooPowder			= new Item().setUnlocalizedName(Constants.Items.FLOO_POWDER).setTextureName(Main.MODID + ":" +  Constants.Items.FLOO_POWDER).setCreativeTab(CreativeTabs.tabMisc);
		Portkey				= new Item().setUnlocalizedName(Constants.Items.PORT_KEY).setTextureName(Main.MODID + ":" +  Constants.Items.PORT_KEY).setCreativeTab(CreativeTabs.tabMisc);
		VanishingCabinet	= new Item().setUnlocalizedName(Constants.Items.VANISHING_CABINET).setTextureName(Main.MODID + ":" +  Constants.Items.VANISHING_CABINET).setCreativeTab(CreativeTabs.tabMisc);
		EnrollmentNotice    = new EnrollmentNotice().setUnlocalizedName(Constants.Items.ENROLLMENT_NOTICE).setTextureName(Main.MODID + ":" +  Constants.Items.ENROLLMENT_NOTICE).setCreativeTab(ModCreativeTabs.tabEEmod);

		GameRegistry.registerItem(experimentItem, Constants.Items.EXPERIMENT_ITEM);
		GameRegistry.registerItem(hammerItem, Constants.Items.HAMMER);
		GameRegistry.registerItem(MagicWand, Constants.Items.MAGIC_WAND);
		GameRegistry.registerItem(PurpleIngot, Constants.Items.PURPLE_INGOT);
		
		GameRegistry.registerItem(PoisonedApple, Constants.Foods.POISONED_APPLE);
		GameRegistry.registerItem(Oatmeal, Constants.Foods.OATMEAL);
		GameRegistry.registerItem(Bun, Constants.Foods.BUN);
		GameRegistry.registerItem(BertieBottsEveryFlavorBeans, Constants.Foods.BERTIE_BOTTS_EVERY_FLAVOR_BEANS);
		GameRegistry.registerItem(ButterBeer, Constants.Foods.BUTTER_BEAR);
		GameRegistry.registerItem(CholocateFrog, Constants.Foods.CHOLOCATE_FROG);
		GameRegistry.registerItem(SortingHat, Constants.Items.SORTING_HAT);
		GameRegistry.registerItem(EnrollmentNotice, Constants.Items.ENROLLMENT_NOTICE);

		GameRegistry.registerItem(ColorfulSword = new ModItemSwords(Constants.Armor.COLORFUL_SWORD, MAGIC), Constants.Armor.COLORFUL_SWORD);
		// 0 for helmet
		GameRegistry.registerItem(magicHelmet = new ModItemArmors(Constants.Armor.MAGIC_HELMET, MAGIC_ARMOR, Constants.Armor.MAGIC_ARMOR_TEXTURE, 0), Constants.Armor.MAGIC_HELMET);
		// 1 for chestplate
		GameRegistry.registerItem(magicChestplate = new ModItemArmors(Constants.Armor.MAGIC_CHESTPLATE, MAGIC_ARMOR, Constants.Armor.MAGIC_ARMOR_TEXTURE, 1), Constants.Armor.MAGIC_CHESTPLATE);
		// 2 for leggings
		GameRegistry.registerItem(magicLeggings = new ModItemArmors(Constants.Armor.MAGIC_LEGGINGS, MAGIC_ARMOR, Constants.Armor.MAGIC_ARMOR_TEXTURE, 2), Constants.Armor.MAGIC_LEGGINGS);
		// 3 for boots
		GameRegistry.registerItem(magicBoots = new ModItemArmors(Constants.Armor.MAGIC_BOOTS, MAGIC_ARMOR, Constants.Armor.MAGIC_ARMOR_TEXTURE, 3), Constants.Armor.MAGIC_BOOTS);

		
	}
}
