package tk.valoeghese.winterbiomemod.compat;

import tk.valoeghese.climatic.api.Climate;
import tk.valoeghese.climatic.api.ClimateBiomes;
import tk.valoeghese.winterbiomemod.init.WinterBiomeInit;

public final class ClimaticWorldTypeCompat {
	private ClimaticWorldTypeCompat() {
	}

	public static void compat() {
		ClimateBiomes.addBiome(Climate.COOL_TEMPERATE, WinterBiomeInit.ALPINE, 6);
		ClimateBiomes.addBiome(Climate.SNOWY, WinterBiomeInit.ALPINE, 10);
	}
}
