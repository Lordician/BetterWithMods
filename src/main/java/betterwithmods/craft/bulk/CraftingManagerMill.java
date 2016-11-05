package betterwithmods.craft.bulk;

public class CraftingManagerMill extends CraftingManagerBulk {
    private static final CraftingManagerMill instance = new CraftingManagerMill();

    public CraftingManagerMill() {
        super("mill");
    }

    public static CraftingManagerMill getInstance() {
        return instance;
    }
}
