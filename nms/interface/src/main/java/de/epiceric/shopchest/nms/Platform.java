package de.epiceric.shopchest.nms;

public interface Platform {

    FakeArmorStand createFakeArmorStand();

    FakeItem createFakeItem();

    default TextComponentHelper getTextComponentHelper() {
        return new DefaultTextComponentHelper();
    }

}
