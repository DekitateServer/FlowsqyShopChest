package de.epiceric.shopchest.nms.paper.v1_21_7;

import de.epiceric.shopchest.nms.FakeArmorStand;
import de.epiceric.shopchest.nms.FakeItem;
import de.epiceric.shopchest.nms.Platform;
import de.epiceric.shopchest.nms.TextComponentHelper;

public class PlatformImpl implements Platform {

    @Override
    public TextComponentHelper getTextComponentHelper() {
        return new TextComponentHelperImpl();
    }

    @Override
    public FakeArmorStand createFakeArmorStand() {
        return new FakeArmorStandImpl();
    }

    @Override
    public FakeItem createFakeItem() {
        return new FakeItemImpl();
    }

}
