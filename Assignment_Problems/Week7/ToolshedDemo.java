abstract class GardenTool {

    public GardenTool() {
    }

    protected String baseUse() {
        return "Using the tool in the garden, ";
    }

    public abstract String use();
}

class CuttingTool extends GardenTool {

    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return baseUse() + "blade sharpened first";
    }
}

class Pruner extends CuttingTool {

    public Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}

public class ToolshedDemo {

    public static void main(String[] args) {

        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}