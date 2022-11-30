public class Employe implements Mensualisable{

    private int salaireAnnuel;

    public Employe(int salaireAnnuel) {
        this.salaireAnnuel = salaireAnnuel;
    }

    @Override
    public int getCoutMensuel() {
        return salaireAnnuel / 12;
    }

    public int getSalaireAnnuel() {
        return salaireAnnuel;
    }

    public void setSalaireAnnuel(int salaireAnnuel) {
        this.salaireAnnuel = salaireAnnuel;
    }
}
