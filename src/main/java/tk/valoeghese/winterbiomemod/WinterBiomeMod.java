package tk.valoeghese.winterbiomemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import tk.valoeghese.winterbiomemod.compat.ClimaticWorldTypeCompat;

public class WinterBiomeMod implements ModInitializer {
	
	public static final Logger logger = LogManager.getLogger("WinterBiomeMod");
	
	@Override
	public void onInitialize() {
		
		if (FabricLoader.getInstance().isModLoaded("cwt")) {
			logger.info("WinterBiomeMod has detected that Climatic World Type is installed! Loading compatibility...");
			ClimaticWorldTypeCompat.compat();
		}
	}

}
