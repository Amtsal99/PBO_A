abstract class MakhlukHidup {
    public abstract String bernapas();
}

class Manusia extends MakhlukHidup {
    @Override
    public String bernapas() {
        return "Manusia bernapas dengan paru-paru.";
    }
}

class Hewan extends MakhlukHidup {
    @Override
    public String bernapas() {
        return "Hewan bernapas dengan paru-paru atau insang.";
    }
}

class Tumbuhan extends MakhlukHidup {
    @Override
    public String bernapas() {
        return "Tumbuhan bernapas melalui stomata.";
    }
}

public class Main {
    public static void main(String[] args) {
        MakhlukHidup[] makhluk = {
            new Manusia(),
            new Hewan(),
            new Tumbuhan()
        };

        for (MakhlukHidup m : makhluk) {
            System.out.println(m.bernapas());
        }
    }
}
