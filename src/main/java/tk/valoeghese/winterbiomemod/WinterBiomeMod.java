package tk.valoeghese.winterbiomemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import tk.valoeghese.winterbiomemod.compat.ClimaticWorldTypeCompat;
import tk.valoeghese.winterbiomemod.init.WinterBiomeInit;
import tk.valoeghese.winterbiomemod.init.WinterGenInit;
import tk.valoeghese.winterbiomemod.init.WinterSurfaceInit;

public class WinterBiomeMod implements ModInitializer {
	
	public static final Logger logger = LogManager.getLogger("WinterBiomeMod");
	
	@Override
	public void onInitialize() {
		WinterSurfaceInit.init();
		WinterBiomeInit.init();
		WinterGenInit.init();
		
		if (FabricLoader.getInstance().isModLoaded("cwt")) {
			logger.info("WinterBiomeMod has detected that Climatic World Type is installed! Loading compatibility...");
			ClimaticWorldTypeCompat.compat();
		}
	}
	
	public static Identifier id(String name) {
		return new Identifier("winterbiomemod", name);
	}

}
