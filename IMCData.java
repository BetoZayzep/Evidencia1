import java.time.LocalDate;

public class IMCData {
    private double imc;
    private LocalDate date;

    public IMCData(double imc, LocalDate date) {
        this.imc = imc;
        this.date = date;
    }

    public double getImc() {
        return imc;
    }

    public LocalDate getDate() {
        return date;
    }
}
