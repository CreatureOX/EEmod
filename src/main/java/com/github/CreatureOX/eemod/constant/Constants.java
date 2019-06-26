package com.github.CreatureOX.eemod.constant;

import com.github.CreatureOX.eemod.Main;

/**
 * @description: const
 * @Author: CreatureOX
 **/
public class Constants {

	public static class Items{
		public static final String EXPERIMENT_ITEM = "experimentItem";
		public static final String HAMMER = "hammerItem";
		public static final String MAGIC_WAND = "magicwandItem";
		public static final String BESOM = "besomItem";

		public static final String PURPLE_INGOT = "purpleIngot";

		public static final String SORTING_HAT = "sortingHat";
		public static final String INVISIBLE_CLOAK = "InvisibleCloak";
		public static final String FLOO_POWDER = "FlooPowder";
		public static final String PORT_KEY = "Portkey";
		public static final String VANISHING_CABINET = "VanishingCabinet";
		public static final String ENROLLMENT_NOTICE = "enrollmentNotice";
	}

	public enum College{

		GRYFFINDOR(0, "Gryffindor", "格兰芬多"),
		SLYTHERIN(1, "Slytherin", "斯莱特林"),
		HUFFLEPUFF(2, "Hufflepuff", "赫奇帕奇"),
		RAVENCLAW(3, "Ravenclaw", "拉文克劳");

		private final Integer collegeCode;
		private final String enName;
		private final String zhName;

		private College(Integer collegeCode, String enName, String zhName){
			this.collegeCode = collegeCode;
			this.enName = enName;
			this.zhName = zhName;
		}

		public Integer getCollegeCode(){
			return collegeCode;
		}

		public String getEnName(){
			return enName;
		}

		public String getZhName(){
			return zhName;
		}

		public static College getByCode(Integer collegeCode){
			for(College college: College.values()){
				if(college.getCollegeCode().equals(collegeCode)){
					return college;
				}
			}
			return null;
		}

		public static String getLocalName(Integer collegeCode){
			String langType = Main.LANGUAGE_TYPE;
			for(College college: College.values()){
				if(college.getCollegeCode().equals(collegeCode)){
					if(langType.equals("zh_CN")){
						return college.getZhName();
					}else if(langType.equals("en_US")){
						return college.getEnName();
					}
				}
			}
			return "???";
		}
	}
	public enum Curse{
		ICE(1),
		FIRE(2),
		WIND(3);

		private final Integer value;

		private Curse(Integer value){
			this.value = value;
		}
	}

	public static class Foods{
		public static final String POISONED_APPLE = "poisonedappleItem";
		public static final String OATMEAL = "oatmealItem";
		public static final String BUN = "bunItem";
		public static final String BERTIE_BOTTS_EVERY_FLAVOR_BEANS = "flavorbeansItem";
		public static final String BUTTER_BEAR = "butterbeerItem";
		public static final String CHOLOCATE_FROG = "cholocatefrogItem";
	}

	public static class Armor{
		public static final String MAGIC_ARMOR_TEXTURE = "magic_armor";

		public static final String COLORFUL_SWORD = "colorfulSword";
		public static final String MAGIC_HELMET = "magicHelmet";
		public static final String MAGIC_CHESTPLATE = "magicChestplate";
		public static final String MAGIC_LEGGINGS = "magicLeggings";
		public static final String MAGIC_BOOTS = "magicBoots";
	}

	public static class Material{
		public static final String MAGIC = "MAGIC";
		public static final String MAGIC_ARRMOR = "MAGIC_ARRMOR";
	}

	public enum Blocks{

		EXPERIMENT_BLOCK("blackboard", "blackboard"),
		MAGIC_BLOCK("magicblock", "magicblock");

		private final String name;
		private final String unlocalizedName;

		private Blocks(String name, String unlocalizedName){
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public String getName(){
			return this.name;
		}

		public String getUnlocalizedName(){
			return this.unlocalizedName;
		}
	}

	public enum Achievements{

		BE_A_WIZARD("achievement.eemod.beAWizard", "eemod.beAWizard"),
		FIRST_USE_MAGIC("achievement.eemod.firstUseMagic", "eemod.firstUseMagic"),
		FIRST_USE_MAGIC_SMELTING("achievement.eemod.firstUseMagicSmelting", "eemod.firstUseMagicSmelting");

		private final String name;
		private final String unlocalizedName;

		private Achievements(String name, String unlocalizedName){
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public String getName(){
			return this.name;
		}

		public String getUnlocalizedName(){
			return this.unlocalizedName;
		}
	}

	public static class GUI{
		public static final int BUTTON_CURSE1 = 1;
		public static final int BUTTON_CURSE2 = 2;
		public static final int BUTTON_CURSE3 = 3;
		public static final int BUTTON_CLOSE = 0;
	}
}
