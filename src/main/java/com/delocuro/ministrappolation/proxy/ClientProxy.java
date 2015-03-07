package com.delocuro.ministrappolation.proxy;

import com.delocuro.ministrappolation.init.MinistrappolationBlocks;
import com.delocuro.ministrappolation.init.MinistrappolationItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders()
	{
		MinistrappolationBlocks.registerRenders();
		MinistrappolationItems.registerRenders();
	}
}
