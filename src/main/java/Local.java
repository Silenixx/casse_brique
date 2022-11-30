public class Local implements Mensualisable{

    private int surface;
    private int coutMetreCarre;

    public Local(int surface, int coutMetreCarre) {
        this.surface = surface;
        this.coutMetreCarre = coutMetreCarre;
    }

    @Override
    public int getCoutMensuel() {
        return surface * coutMetreCarre;
    }
}
